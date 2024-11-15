package tn.esprit.charekyosr4twin5.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.Repositories.ISkieurRepository;
import tn.esprit.charekyosr4twin5.entities.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Service
public class SkierServicesimpl implements ISkierService {
 @Autowired
    private ISkieurRepository skieurRepository;
    @Autowired
    private IRegistrationService RegistrationRepository;
    @Autowired
    private ISubscriptionService SubscriptionRepository;
    @Autowired
    private ICourseService CourseRepository;

 @Override
 public Skieur addSkier(Skieur skieur){

     return skieurRepository.save(skieur);
 }

    @Override
    public Skieur updateSkier(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur retriveSkier(Long numSkier) {
        return skieurRepository.findById(numSkier).orElse(null);
    }

    @Override
    public List<Skieur> retriveAll() {
        return (List<Skieur>) skieurRepository.findAll();


    }

    @Override
    public void remouveSkier(Long numSkier) {
        skieurRepository.deleteById(numSkier);
    }

    @Override
    public Skieur getByFLname(String firstName, String lastName) {
        return skieurRepository.findFirstByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public Skieur getByDate(LocalDate date) {
        return skieurRepository.findFirstByBirthDate(date);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        Subscription subscription = new Subscription();
        skieur.setSubscription(subscription);
        SubscriptionRepository.addSubscription(subscription);
        Course course = CourseRepository.retrieveCourse(numCourse);
        Registration registration = new Registration();
        registration.setCourse(course);
        registration.setSkieur(skieur);
        if (skieur.getRegistrations() == null) {
            skieur.setRegistrations(new HashSet<>());
        }
        skieur.getRegistrations().add(registration);
        RegistrationRepository.addRegistration(registration);
        return skieurRepository.save(skieur);
    }

    @Override
   public List<Skieur> retrieveSkiersBySubscriptionType(TypeSubscription typeSubscription) {
        return skieurRepository.findBySubscription_TypeSub(typeSubscription);
    }
}
