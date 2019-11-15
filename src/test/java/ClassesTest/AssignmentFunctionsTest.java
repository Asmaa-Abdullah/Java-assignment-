package ClassesTest;
import Classes.AssignmentFunctions;
import Classes.Person;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AssignmentFunctionsTest {
    AssignmentFunctions assignmentFunctions = new AssignmentFunctions();
    String firstName = "Cecilia";
    String surName = "Sundberg";
    String gender = "female";
    private static String PATHTOFILE = "/Users/asmaaabdullah/Desktop/TestAssignmentJava/src/main/resources/names.json";


    Person person = new Person(firstName,surName,gender);
    List<Person> personArrayList = assignmentFunctions.getPersonArrayList();
    String fileName = "namesTest.json";

    /**
     * Test read json file and save it in ArrayList method
     */
    @Test
    public void readJsonFileTest(){
        ArrayList<Person> testResult = assignmentFunctions.readJsonFile(PATHTOFILE);
        System.out.println(testResult);
        assertTrue(testResult.get(2).getFirstName().equals(firstName));
    }

    /**
     * Test count the First Name occurrences method
     */
    @Test
    public void countFirstNameFrequenciesTest()
    {
        ArrayList<Person> testResult = assignmentFunctions.readJsonFile(PATHTOFILE);
        assignmentFunctions.countFirstNameFrequencies();
        System.out.println(testResult);
        Map<String, Long> firstNameMap = assignmentFunctions.getFirstNameMap();

        assertTrue(firstNameMap.get("Lucas") == 2  ) ;
        assertTrue(firstNameMap.get("Anna") == 1  ) ;

    }

    /**
     * Test count the surname occurrences method
     */
    @Test
    public void countLastNameFrequenciesTest()
    {
        ArrayList<Person> testResult = assignmentFunctions.readJsonFile(PATHTOFILE);
        assignmentFunctions.countSurNameFrequencies();
        System.out.println(testResult);
        Map<String, Long> lastNameMap = assignmentFunctions.getLastNameMap();

        assertTrue(lastNameMap.get("Blomqvist") == 2  ) ;
        assertTrue(lastNameMap.get("Sundberg") == 1  ) ;

    }
}
