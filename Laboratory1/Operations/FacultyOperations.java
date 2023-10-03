package Laboratory1.Operations;

import java.util.Scanner;

public class FacultyOperations {
    public static void facultyOperations(Scanner input) {
        String choice = "";

        while (!choice.equals("b")) {
            System.out.println("Faculty operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - enroll a new student");
            System.out.println("gs/<email> - graduate student");
            System.out.println("ds/<faculty abbreviation> - display only the enrolled students");
            System.out.println("dg/<faculty abbreviation> - display only the graduated students");
            System.out.println("bf/<faculty abbreviation>/<email> - check if a student belongs to faculty");
            System.out.println();
            System.out.println("b - Back");
            System.out.println();
            System.out.print("Your input: ");
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
