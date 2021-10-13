package entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private int number;

    @ManyToMany
    List<Person> persons;
}
