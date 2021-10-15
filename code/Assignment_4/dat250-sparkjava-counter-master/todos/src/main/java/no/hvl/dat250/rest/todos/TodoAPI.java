package no.hvl.dat250.rest.todos;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

/**
 * Rest-Endpoint.
 */
public class TodoAPI {
    static ArrayList<Todo> todos = new ArrayList<Todo>();

    public static void main(String[] args) {
        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        Todo dummyTodo = new Todo(1L, "Dummy Summary", "Dummy Description");
        todos.add(dummyTodo);

        after((req, res) -> {
            res.type("application/json");
        });

        get("/hello", (req, res) -> "Hello World!");

        get("/todo", (req, res) -> {
            Gson gson = new Gson();
            return gson.toJson(todos);
        });

        put("/todo", (req,res) -> {

            Gson gson = new Gson();
            Todo newTodo = gson.fromJson(req.body(), Todo.class);

            for(Todo todo : todos) {
                if(todo.getId() == newTodo.getId()) {
                    todos.remove(todo);
                    todos.add(newTodo);
                    return gson.toJson(todo);
                }
            }
            return "ID does not exist";
        });

        post("/todo", (req, res) -> {

            Gson gson = new Gson();
            Todo newTodo = gson.fromJson(req.body(), Todo.class);
            for (Todo todo : todos) {
                if (newTodo.getId() == todo.getId()) {
                    return "ID is not unique";
                }
            }

            todos.add(newTodo);
            return gson.toJson(todos);
        });

        delete("/todo", (req, res) -> {
            Gson gson = new Gson();
            Map<String, Double> map = gson.fromJson(req.body(), Map.class);
            int searchedID = (map.get("id")).intValue();
            for (Todo todo : todos) {
                if (todo.getId() == searchedID) {
                    todos.remove(todo);
                    break;
                }
            }
            return gson.toJson(todos);
        });
    }
}
