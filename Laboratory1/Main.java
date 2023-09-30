package Laboratory1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while(true){
            // Menu
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println("g - General operations");
            System.out.println("f - Faculty operations");
            System.out.println("s - Student operations");
            System.out.println();
            System.out.println("q - Quit program");
            System.out.println();
            // Take input
            System.out.print("Your input: ");
            String choice = input.nextLine();
            // Automatically lower the input so it would not create confusion
            choice = choice.toLowerCase();
            // Creating corresponding functions for each input
            if (choice.equals("g")) {
                GeneralOperations.generalOperations(input);
            } else if (choice.equals("q")) {
                System.exit(0);
            } else {
                System.out.println();
                System.out.println("There does not exist such command. Do you want to try again? y/n");
                System.out.print("Your input: ");
                String decision = input.nextLine();
                decision = decision.toLowerCase();
                if (decision.equals("n")) System.exit(0);
            }
        }
    }
}
