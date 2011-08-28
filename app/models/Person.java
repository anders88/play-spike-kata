package models;

import play.*;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class Person extends Model {
	public String name;
	
	public Person(String name) {
		this.name = name;
	}

	public static List<Person> search(String namePattern) {
		if ((namePattern == null) || namePattern.isEmpty()) {
			return new ArrayList<Person>();
		}
		return find("upper(name) like ?", "%" + namePattern.toUpperCase() +"%").fetch();
	}
}
