package tn.esprit.charekyosr4twin5.Services;


import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.Repositories.ISkieurRepository;
import tn.esprit.charekyosr4twin5.entities.Skieur;
@Service
public class SkierServicesimpl {
    private ISkieurRepository skieurRepository;
    public Skieur addSkier(Skieur skieur){
        return skieurRepository.save(skieur);
    }
}
