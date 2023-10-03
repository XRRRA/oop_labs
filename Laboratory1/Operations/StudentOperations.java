package Laboratory1.Operations;

import java.util.Scanner;

public class StudentOperations {
    public static void studentOperations(Scanner input){
        String choice = "";
        while (!choice.equals("b")){
            System.out.println("Student operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("be - batch enroll students (add the students' information in the enroll.txt file)");
            System.out.println("bg - batch graduate students (add the graduates' information in the graduate.txt file)");
            System.out.println();
            System.out.println("b - Back");
            System.out.println();
            System.out.print("Your input: ");
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
