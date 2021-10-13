package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;
    private int number;
    private int limit;
    private int balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;

    @OneToOne
    private Pincode pincode;
}
