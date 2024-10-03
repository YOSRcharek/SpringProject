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

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numRegistraion ;
    private int numWeek ;


}