package relation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import relation.entity.Author;
import relation.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class TestDAO {
    @PersistenceContext
    private EntityManager em;

    public void contextLoads() {
        Book book1 = new Book("book1");
        Book war = new Book("War");
        Author creator = new Author("creator");
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(war);
        creator.setBooks(bookSet);
        em.persist(creator);


    }

    public void changeName(){
        Author author = em.find(Author.class, 1L);
        author.setName("klklk");
        em.persist(author);
    }
}
