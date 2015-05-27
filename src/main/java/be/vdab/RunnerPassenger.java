package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Hyuberuto on 27/05/15.
 */
public class RunnerPassenger {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books-JPA");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();


        PassengerRepositoryDao passRepository = new PassengerRepositoryBean(em);
        List<Passenger> passengers = passRepository.findAllPassengers();
        for (Passenger passenger : passengers){
            System.out.println(passenger);
        }
        /*Passenger p = em.find(Passenger.class,1);
        System.out.println(p);
*/





        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

    }
}
