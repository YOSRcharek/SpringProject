package tn.esprit.charekyosr4twin5.Services;

import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.util.List;

public interface ISkierService {
 Skieur addSkier(Skieur skier);
 Skieur updateSkier(Skieur skieur);
 Skieur retriveSkier(Long numSkier);
 List<Skieur> retriveAll();
 void remouveSkier(Long numSkier);
}
