package tn.esprit.charekyosr4twin5.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.charekyosr4twin5.entities.Subscription;
import tn.esprit.charekyosr4twin5.Repositories.ISubscriptionRepository;
import tn.esprit.charekyosr4twin5.entities.TypeSubscription;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Slf4j
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements ISubscriptionService {

    private final ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void removeSubscription(Long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);
    }

    @Override
    public Subscription retrieveSubscription(Long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }
    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return new HashSet<>(subscriptionRepository.findByTypeSubOrderByStartDate(type));
    }

    @Override
    @Scheduled(cron = "*/60 * * * * *")
    public void getStartedDate() {
      for(Subscription subscription :subscriptionRepository.getByStartDate()){
          log.info(subscription.toString());
      }
    }


}
