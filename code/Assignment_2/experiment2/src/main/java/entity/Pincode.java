package entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;

@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue
    private Long id;
    private String pincode;
    private int count;
}
