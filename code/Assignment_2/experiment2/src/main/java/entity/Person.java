package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany
    List<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditCard> creditcards = new ArrayList<>();
}
