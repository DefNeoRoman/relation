package relation.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 3L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", length=200)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Author.class)
    @JoinTable(name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<>();
    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors.size() +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
