package Laboratory1.Operations;

import java.util.Scanner;

public class StudentOperations {
    public static void studentOperations(Scanner input){
        String choice = "";
        while (!choice.equals("b")){
            MenuText.printStudentOpText();
            choice = input.nextLine().trim();
            switch (choice) {
                case "be":
                    Commands.batchEnroll();
                    break;
                case "bg":
                    Commands.batchGraduate();
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
