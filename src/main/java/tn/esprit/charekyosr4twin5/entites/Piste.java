package tn.esprit.charekyosr4twin5.entites;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;

    private int length;
    private int slope;
    private LocalTime birthDate;

    @Enumerated(EnumType.STRING)
    private Color color;

}