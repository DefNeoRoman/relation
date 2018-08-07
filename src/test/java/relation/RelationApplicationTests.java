package relation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import relation.entity.Author;
import relation.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationApplicationTests {

	@Autowired
	TestDAO dao;

	@Test
	public void contextLoads() {
		dao.contextLoads();
		dao.changeName();
	}


}
