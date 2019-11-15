package Classes;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class AssignmentFunctions {

    private Map<String, Long> firstNameMap;
    private Map<String, Long> surNameMap;
    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Person> personArrayList;

    /**
     * Get method for personArrayList
     * @return personArrayList
     */
    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    /**
     * Get method for firstNameMap
     * @return firstNameMap
     */
    public Map<String, Long> getFirstNameMap() {
        return firstNameMap;
    }

    /**
     * Get method for surNameMap
     * @return surNameMap
     */
    public Map<String, Long> getLastNameMap() {
        return surNameMap;
    }

    public AssignmentFunctions() {
        personArrayList = new ArrayList<>();
        firstNameMap = new HashMap<>();
        surNameMap = new HashMap<>();
    }

    /**
     * Read Json File and add it to personArrayList
     * @return
     */
    public ArrayList<Person> readJsonFile(String path) {

        //Creating a JSONParser object
        JSONParser jsonParser = new JSONParser();

        try (Reader reader = new FileReader(path)) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) jsonObject.get("names");
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject jsonObject1 = (JSONObject) iterator.next();
                String first_name = (String) jsonObject1.get("firstname");
                String last_name = (String) jsonObject1.get("surname");
                String gender = (String) jsonObject1.get("gender");

                //Forming URL

                System.out.println("First name: " + first_name);
                System.out.println("Last name: " + last_name);
                System.out.println("Gender: " + gender + "\n");

                personArrayList.add(new Person(first_name, last_name, gender));
            }

    } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return personArrayList;
    }

    public void createMaps()
    {
        countFirstNameFrequencies();
        countSurNameFrequencies();
    }

    /**
     * Count the first name frequencies
     */
    public void countFirstNameFrequencies()
    {
        firstNameMap = personArrayList.stream()
                .collect(Collectors.groupingBy(Person::getFirstName, Collectors.counting()));

    }

    /**
     * Count the surname frequencies
     */
    public void countSurNameFrequencies() {

        surNameMap = personArrayList.stream()
                .collect(Collectors.groupingBy(Person::getSurName, Collectors.counting()));

    }

    /**
     * to print map
     * @param map
     */
    public void writeOneMap(Map<String, Long> map)
    {
        map.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + "   " + entry.getValue());
        });
    }


    public void printLists() {
        System.out.println("Enter 1 For first name list \n");
        System.out.println("Enter 2 For last name  list \n ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:     // first list
                writeOneMap(firstNameMap);
                break;
            case 2: // last list
                writeOneMap(surNameMap);
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }

    /**
     * Sort according first name & according surname
     */
    public void sortOnly()
    {
        System.out.println("Enter 1 to sort according first name list \n");
        System.out.println("Enter 2 to sort according last name  list \n ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:     // first list
                sortFirstName().forEach(person -> System.out.println(person.toString()));
                break;
            case 2: // last list
                sortSurName().forEach(person -> System.out.println(person.toString()));
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }

    /**
     * Sort the first name in a list of type Person
     *
     * @return sortedFirstNameList
     */
    public List<Person> sortFirstName() {
        List<Person> sortedFirstNameList = personArrayList.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());
        return sortedFirstNameList;
    }

    /**
     * Sort the sure name in a list of type Person
     *
     * @return sortedSurNameList
     */
    public List<Person> sortSurName() {
        List<Person> sortedSurNameList = personArrayList.stream()
                .sorted(Comparator.comparing(Person::getSurName))
                .collect(Collectors.toList());
        return sortedSurNameList;
    }

    /**
     * Sort Ascending & Descending order for names
     */
    public void sortBy() {
        List<Person> list = sortFirstName();       // Temporary storing the sorted list a-z
        System.out.println("Enter 1 For Ascending Order \n");
        System.out.println("Enter 2 For Descending Order \n ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:     // Ascending
                list.stream().forEach(person -> System.out.println(person.toString()));
                break;
            case 2:     //Descending
                Collections.reverse(list);
                list.stream().forEach(person -> System.out.println(person.toString()));
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }

    /**
     * Filter on selection name
     */
    public void filterSelectionName() {
        System.out.print("Enter name : ");
        String selectName = scanner.nextLine().toLowerCase();
        for (Person nextPerson : personArrayList) {
            if (nextPerson.getFirstName().toLowerCase().equals(selectName) || nextPerson.getSurName().toLowerCase().equals(selectName))
            {
                System.out.println("\n" + nextPerson.toString() + "\n");
                return;
            }
        }
        System.out.println("\nThe Name Is Not Found");
    }

    /**
     * Filtering on even & odd number of occurrences
     * @param map
     * @param even
     */
    public void displayOccurencesOfMap (Map<String, Long> map, boolean even) {
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0 && even == true) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            } else if (entry.getValue() % 2 != 0 && even == false) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    /**
     * Print the sort order of the lists
     */
    public void evenOddList() {
        System.out.println("Enter 1 For Even numbers of occurrences for first name \n");
        System.out.println("Enter 2 For Odd numbers of occurrences for first name \n");
        System.out.println("Enter 3 For Even numbers of occurrences for last name \n");
        System.out.println("Enter 4 For Odd numbers of occurrences for last name \n");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:   // even and first
                displayOccurencesOfMap(firstNameMap, true);
                break;
            case 2:   // odd and first
                displayOccurencesOfMap(firstNameMap, false);
                break;
            case 3:   // even and last
                displayOccurencesOfMap(surNameMap, true);
                break;
            case 4:   // odd and last
                displayOccurencesOfMap(surNameMap, false);
                break;

            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }
}

