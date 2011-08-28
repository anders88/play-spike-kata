import org.junit.*;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;

import play.db.jpa.GenericModel.JPAQuery;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteDatabase();
	}

	@Test
	public void should_create_a_person() throws Exception {
		new Person("Darth").save();
		
		assertEquals(1, Person.findAll().size());
	}
	
	@Test
	public void should_find_person_by_part_of_name() throws Exception {
		new Person("Luke Skywalker").save();
		new Person("Anakin Skywalker").save();
		new Person("Jar-Jar Binks").save();
		
		List<Person> skywalkers = Person.search("sky");
		
		assertEquals(2, skywalkers.size());
	}

}
