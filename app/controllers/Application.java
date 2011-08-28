package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void createPersonPage() {
    	render();
    }
    
    public static void createPerson(String fullName) {
    	new Person(fullName).save();
    	index();
    }
    
    public static void findPeople() {
    	search(null);
    }
    
    public static void search(String namePattern) {
    	List<Person> people = Person.search(namePattern);
    	render(people);
    }

}