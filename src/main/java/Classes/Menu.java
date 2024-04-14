package Classes;

import java.util.Scanner;

public class Menu {

    static final Scanner scanner = new Scanner(System.in);
    private static int selection = 0;
    public AssignmentFunctions assignmentFunctions = new AssignmentFunctions();

    private static String PATHTOFILE = "C:/Java-assignment/src/main/resources/names.json";

    public void readTheJsonFile(){
        assignmentFunctions.readJsonFile(PATHTOFILE);
        assignmentFunctions.createMaps();
    }

    public void printWelcomeText() {
        System.out.println("*********************************************************");
        System.out.println("\n**       Welcome to the test assignment Java       **\n");
        System.out.println("*********************************************************");
    }

    public void printMainMenuCommands() {
        readTheJsonFile();

        do {
            System.out.println("\n1 - Statistics of the most frequently occurring names ");
            System.out.println("\n2 - Writes two separate lists with all first and last names sorted ");
            System.out.println("\n3 - Select the sort order of the lists");
            System.out.println("\n4 - Filter the selection of names");
            System.out.println("\n5 - Display names with odd or even number of occurrences.");
            System.out.println("\n6 - Exit");
            System.out.println("\nSelect from menu");
            System.out.println("-----------------------------\n");

            selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    assignmentFunctions.printLists();
                    break;
                case 2:
                    assignmentFunctions.sortOnly();
                    break;
                case 3:
                    assignmentFunctions.sortBy();
                    break;
                case 4:
                    assignmentFunctions.filterSelectionName();
                    break;
                case 5:
                    assignmentFunctions.evenOddList();
                    break;
                case 6:
                    System.out.println("\n ********  Thanks for using the application!  ******** ");
                    System.exit(0);
                    break;
                default:
                    assignmentFunctions.invalidSelection();
            }
        } while (selection != 6);
    }
}
