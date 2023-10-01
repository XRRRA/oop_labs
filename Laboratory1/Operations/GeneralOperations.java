package Laboratory1.Operations;

import Laboratory1.Faculty;
import Laboratory1.StudyField;

import java.util.List;
import java.util.Scanner;

public class GeneralOperations {
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    public static void generalOperations(Scanner input) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("General operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
            System.out.println("ss/<student email> - search student and show faculty");
            System.out.println("df- display faculties");
            System.out.println("df/<field> - display all faculties of a field");
            System.out.println();
            System.out.println("b - Back");
            System.out.println("q - Quit program");
            System.out.println();
            System.out.print("Your input: ");
            String choice = input.nextLine().trim();

            if (choice.startsWith("nf/")) {
                String[] parts = choice.split("/");
                if (parts.length == 4) {
                    String facultyName = parts[1];
                    String facultyAbbreviation = parts[2];
                    StudyField studyField = StudyField.valueOf(parts[3]);
                    Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                    Faculty.addFaculty(faculty);
                    System.out.println("New Faculty created:");
                } else {
                    System.out.println("Invalid input for creating a faculty. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            }
            //TODO Search the student by email and show the faculty he's from




            else if (choice.equals("df")){
                System.out.println("The available faculties:");
                for (Faculty faculty : faculties) {
                    System.out.println(" - " + faculty.getName());
                }
                System.out.println();
                System.out.println();
            } else if (choice.startsWith("df/")){
                String[] parts = choice.split("/");
                if (parts.length == 2) {
                    String field = parts[1];
                    if (StudyField.validation(field)) {
                        System.out.println("The faculties from the "+field+" field are:");
                        for (Faculty faculty: faculties){
                            if (faculty.getStudyField().toString().equals(field)){
                                System.out.println(" - " + faculty.getName());
                            }
                        }
                        System.out.println();
                        System.out.println();
                    } else {
                        System.out.println("There does not exist such a field. Please introduce a valid field. Do you want to try again? y/n");
                        System.out.print("Your input: ");
                        String decision = scan.nextLine();
                        decision = decision.toLowerCase();
                        if (decision.equals("n")) System.exit(0);
                    }
                } else {
                    System.out.println("Invalid input for displaying the faculties. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            }
            else if (choice.equals("b")) {
                break;
            } else if (choice.equals("q")) {
                System.out.println("Quitting the program");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Do you want to try again? y/n");
                System.out.print("Your input: ");
                String decision = scan.nextLine();
                decision = decision.toLowerCase();
                if (decision.equals("n")) System.exit(0);
            }
        }
    }
}
