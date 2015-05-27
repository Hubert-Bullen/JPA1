package be.vdab;

import org.junit.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hyuberuto on 26/05/15.
 */

public class BookEntityManagerFactoryTest extends AbstractEntityManagerFactoryTest /*extends TestCase*/ { /*Niet van toepassing niet meer met deze versie van Junit! Assert moet gewoon static geimport worden.*/

    @Test
    public void testAmountOfBooks() {
        logger.debug("Saying hello from the logging infrastructure."); /*Omdat in de logback be.vdab op DEBUG staat word alles van be.vdab als DEBUG afgeprint.*/

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();*/
        /*Zijn niet meer nodig want nu worden ze voor elke test gemaakt en na elke test afgesloten door wat in de superklasse staat.*/

        BookRepositoryDao bookRepository = new BookRepositoryBean(em);
        List<Book> books = bookRepository.findAllBooks();
        assertEquals(5, books.size());

        /*em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();*/
    }

    @Test
    public void testBookTitles() {

        be.vdab.BookRepositoryDao bookRepository = new be.vdab.BookRepositoryBean(em);
        List<be.vdab.Book> books = bookRepository.findAllBooks();
        assertEquals("Shogun", books.get(2).getTitle());
        assertEquals("Coraline", books.get(3).getTitle());
        assertEquals("Norwegian Wood", books.get(4).getTitle());

    }

    @Test
    public void testBookAuthors() {

        be.vdab.BookRepositoryDao bookRepository = new be.vdab.BookRepositoryBean(em);
        List<be.vdab.Book> books = bookRepository.findAllBooks();
        assertEquals("James Clavell", books.get(2).getAuthor());
        assertEquals("Neil Gaiman", books.get(3).getAuthor());
        assertEquals("Haruki Murakami", books.get(4).getAuthor());

    }


}
