package be.vdab;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Hyuberuto on 26/05/15.
 */
public class BookRepositoryBean implements BookRepositoryDao {
    private EntityManager em;
    public BookRepositoryBean(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Book> findAllBooks() {
        return em.createQuery("select b from Book b",
                Book.class).getResultList();
    }
}