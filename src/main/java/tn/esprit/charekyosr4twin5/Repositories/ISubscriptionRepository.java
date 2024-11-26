package tn.esprit.charekyosr4twin5.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.util.List;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    List<Subscription> findByTypeSubOrderByStartDate(TypeSubscription type);
    @Query("SELECT s FROM Subscription s ORDER BY s.startDate ASC")
    List<Subscription> getByStartDate();

}
