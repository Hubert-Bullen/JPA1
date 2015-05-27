package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Hyuberuto on 26/05/15.
 */
public class RunnerBook {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RealDolmenPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();


        BookRepositoryDao bookRepository = new BookRepositoryBean(em);
        List<Book> books = bookRepository.findAllBooks();
        for (Book b : books){
            System.out.println(b);
        }






        em.getTransaction().commit();
        em.close();
        entityManagerFactory.close();

    }

}
