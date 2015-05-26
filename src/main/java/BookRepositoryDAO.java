import java.util.List;

/**
 * Created by Hyuberuto on 26/05/15.
 */
public interface BookRepositoryDao {
    List<Book> findAllBooks();
}