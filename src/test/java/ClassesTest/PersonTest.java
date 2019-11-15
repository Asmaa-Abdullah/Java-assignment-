package ClassesTest;

import Classes.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Person Class (Setter & Getter Methods)
 */
public class PersonTest {

    String firstName = "Peter";
    String surName = "Jonsson";
    String gender = "male";

    Person person = new Person (firstName,surName,gender);
    @Test
    public void getFirstName() {
        assertEquals(firstName, person.getFirstName());
        assertEquals("Peter", person.getFirstName());
    }
    @Test
    public void setFirstName() {
        String newfirstName = "Anna";
        person.setFirstName(newfirstName);
        assertEquals(newfirstName, person.getFirstName());
    }

    @Test
    public void getSurName() {
        assertEquals(surName, person.getSurName());
        assertEquals("Jonsson", person.getSurName());
    }
    @Test
    public void setSurNameName() {
        String newsurName = "Peter";
        person.setSurName(newsurName);
        assertEquals(newsurName, person.getSurName());
    }

    @Test
    public void getGender (){
        assertEquals(gender, person.getGender());
        assertEquals("male", person.getGender());
    }
    @Test
    public void setGender() {
        String newGender = "female";
        person.setGender(newGender);
        assertEquals(newGender, person.getGender());
    }
}
