package Laboratory1.Operations;

import java.util.Scanner;

public class GeneralOperations {
    public static void generalOperations(Scanner input) {
        String choice = "";
        while (!choice.equals("b")) {
            System.out.println("General operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
            System.out.println("ss/<student email> - search student and show faculty");
            System.out.println("df- display faculties");
            System.out.println("df/<field> - display all faculties of a field");
            System.out.println();
            System.out.println("b - Back");
            System.out.println();
            System.out.print("Your input: ");
            choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            if (choice.startsWith("nf/")){
                Commands.createFaculty(parts);
            } else if (choice.startsWith("ss/")) {
                Commands.searchStudent(parts);
            } else if (choice.equals("df")) {
                Commands.displayAllFaculties();
            } else if (choice.startsWith("df/")) {
                Commands.displayFieldFaculties(parts);
            } else if (choice.equals("b")){
                break;
            } else {
                System.out.println("Invalid choice. Do you want to try again? y/n");
                String decision = input.nextLine().trim().toLowerCase();
                if (!decision.equals("y")) {
                    System.out.println("Going back");
                    choice = "b";
                }
            }
        }
    }
}
