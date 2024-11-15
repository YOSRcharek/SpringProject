package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.charekyosr4twin5.entities.Skieur;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

public interface ISkieurRepository extends CrudRepository <Skieur, Long> {
    Skieur findFirstByFirstNameAndLastName(String firstName, String lastName);
    Skieur findFirstByBirthDate(LocalDate date);
    List<Skieur> findBySubscription_TypeSub(TypeSubscription typeSubscription);

}
