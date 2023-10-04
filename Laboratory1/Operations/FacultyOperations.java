package Laboratory1.Operations;

import java.util.Scanner;

public class FacultyOperations {
    public static void facultyOperations(Scanner input) {
        String choice = "";

        while (!choice.equals("b")) {
            MenuText.printFacultyOpText();
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            switch (parts[0]) {
                case "ns":
                    Commands.enrollStudent(parts);
                    break;
                case "gs":
                    Commands.graduateStudent(parts);
                    break;
                case "ds":
                    Commands.displayEnrolledStudents(parts);
                    break;
                case "dg":
                    Commands.displayGraduatedStudents(parts);
                    break;
                case "bf":
                    Commands.checkBelongingToFaculty(parts);
                    break;
                case "b":
                    break;
                default:
                    System.out.println("Invalid choice. Do you want to try again? y/n");
                    String decision = input.nextLine().trim().toLowerCase();
                    if (!decision.equals("y")) {
                        System.out.println("Going back");
                        choice = "b";
                    }
                    break;
            }
        }
    }
}
