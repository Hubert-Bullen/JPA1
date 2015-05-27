package be.vdab;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Hyuberuto on 26/05/15.
 */
public abstract class AbstractEntityManagerFactoryTest {
    private static EntityManagerFactory entityManagerFactory;
    protected Logger logger = LoggerFactory.getLogger(BookEntityManagerFactoryTest.class); /*Hiermee verbeteren we de log output!*/
    protected EntityManager em;

    @BeforeClass /*AfterClass en BeforeClass worden gemaakt voor alle tests in 1 keer.*/
    public static void initializeEntityManagerFactory(){ /*BeforeClass en AfterClass moeten static zijn. En dus ook bij de parameters!*/
        entityManagerFactory = Persistence.createEntityManagerFactory("Books-JPA");

    }

    @AfterClass
    public static void destroyEntityManagerFactory(){
        entityManagerFactory.close();

    }

    @Before /*After en Before doet het deze in alle tests*/
    public void initializeEntityManager(){
        em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

    }

    @After
    public void destroyEntityManager(){
        em.getTransaction().commit();
        em.close();

    }
}
