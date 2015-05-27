package be.vdab;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Hyuberuto on 27/05/15.
 */
public class PassengerRepositoryBean implements PassengerRepositoryDao {
    private EntityManager em;
    public PassengerRepositoryBean(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Passenger> findAllPassengers() {
        return em.createQuery("select p from Passenger p",
                Passenger.class).getResultList();
    }

}
