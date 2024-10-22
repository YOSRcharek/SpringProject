package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.time.LocalDate;

public interface ISkieurRepository extends CrudRepository <Skieur, Long> {
    Skieur findFirstByFirstNameAndLastName(String firstName, String lastName);
    Skieur findFirstByBirthDate(LocalDate date);

}
