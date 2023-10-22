package Laboratory1;

import Laboratory1.Operations.*;

import java.util.Scanner;

public class Menu {
    public static void accessMenu(){
        DataLoad.loadData();
        Scanner input = new Scanner(System.in);

        String choice = "" ;

        while(!choice.equals("q")) {
            MenuText.printMenuText();
            choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "g":
                    GeneralOperations.generalOperations(input);
                    break;
                case "f":
                    FacultyOperations.facultyOperations(input);
                    break;
                case "s":
                    StudentOperations.studentOperations(input);
                    break;
                case "q":
                    System.out.println("Quiting the program");
                    input.close();
                    break;
                default:
                    System.out.println("Invalid choice. Do you want to try again? y/n");
                    String decision = input.nextLine().trim().toLowerCase();
                    if (!decision.equals("y")) {
                        System.out.println("Quiting the program");
                        choice = "q";
                        input.close();
                    }
            }
        }
    }
}
