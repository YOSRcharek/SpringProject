package tn.esprit.charekyosr4twin5.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table//(name="t_skier")
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idskier;
    private String name;

    private LocalDate birthDate;
    private String city;

    @OneToOne
    Subscription subscription;
}

