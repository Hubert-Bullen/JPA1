package be.vdab;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hyuberuto on 27/05/15.
 */
public class PassengerEntityManagerFactoryTest extends AbstractEntityManagerFactoryTest{

    @Test
    public void testAmountOfPassengers() {
        PassengerRepositoryDao passRepository = new PassengerRepositoryBean(em);
        List<Passenger> passengers = passRepository.findAllPassengers();
        assertEquals(4, passengers.size());
    }

    @Test
    public void testNameOfFirstPassenger(){
        PassengerRepositoryDao passRepository = new PassengerRepositoryBean(em);
        List<Passenger> passengers = passRepository.findAllPassengers();
        assertEquals("James", passengers.get(0).getFirstName());
        assertEquals("Potter", passengers.get(0).getLastName());
    }

    @Test
    public void testCreatePassenger(){
        Passenger newP = new Passenger();
        em.persist(newP);
        assertNotNull(newP.getId());
    }

    @Test
    public void testDetachPassenger (){
        Passenger newP = new Passenger();
        em.persist(newP);
        em.detach(newP);
        assertFalse(em.contains(newP));
    }

    @Test
    public void testUpdatePassenger() {
        String firstName = "John";
        Passenger newP = new Passenger();
        em.persist(newP);
        newP.setFirstName(firstName);
        assertEquals("John", em.find(Passenger.class, newP.getId()).getFirstName());
    }

    @Test
    public void testRemovePassenger(){
        em.remove(em.find(Passenger.class, 1));
        em.flush();
        assertNull(em.find(Passenger.class, 1));

    }

    @Test
    public void testAmountOfFrequentFlyers(){
        PassengerRepositoryDao passRepository = new PassengerRepositoryBean(em);
        List<Passenger> passengers = passRepository.findAllPassengers();
        int amount = 0;
        for (Passenger p : passengers){
            if (p.getPtype() == Passengertype.FREQUENT_FLYER){
                amount += 1;
            }
        }
        assertEquals(1,amount);

    }

    @Test
    public void testAmountEligibleForPromo(){
        PassengerRepositoryDao passRepository = new PassengerRepositoryBean(em);
        List<Passenger> passengers = passRepository.findAllPassengers();
        List<Passenger> eligiblepass = new ArrayList<>();
        for (Passenger p : passengers){
            if (p.getFreqFlyerMiles() >= 325){
                eligiblepass.add(p) ;
            }
        }
        assertEquals(2,eligiblepass.size());

    }




}
