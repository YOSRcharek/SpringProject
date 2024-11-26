package tn.esprit.charekyosr4twin5.Services;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.charekyosr4twin5.entities.Skieur;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

public interface ISkierService {
 Skieur addSkier(Skieur skier);
 Skieur updateSkier(Skieur skieur);
 Skieur retriveSkier(Long numSkier);
 List<Skieur> retriveAll();
 void remouveSkier(Long numSkier);
 Skieur getByFLname(String firstName,String lastName );

 Skieur getByDate(LocalDate date);
 Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
 List<Skieur> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription);

 void listeSkieurAbonnesTerminerNotif()
         ;
}
