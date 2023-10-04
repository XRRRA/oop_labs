package Laboratory1.Operations;

import java.util.Scanner;

public class GeneralOperations {
    public static void generalOperations(Scanner input) {
        String choice = "";
        while (!choice.equals("b")) {
            MenuText.printGeneralOpText();
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
