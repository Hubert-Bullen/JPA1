import junit.framework.TestCase;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Hyuberuto on 26/05/15.
 */
public class EntityManagerFactoryTest extends TestCase {


    public void testOurLogic() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        BookRepositoryDao bookRepository = new BookRepositoryBean(em);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(5, books.size());

        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();
    }










}
