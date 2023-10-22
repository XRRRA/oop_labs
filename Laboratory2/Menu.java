package Laboratory2;

import Laboratory2.classes.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void accessMenu() throws IOException {
        DocumentChangeDetector document = new DocumentChangeDetector();

        Scanner input = new Scanner(System.in);

        String choice = "" ;
        System.out.println();
        System.out.println();
        System.out.println("Welcome to the Document Change Detector system:");
        document.displayLastSnapshotTime();

        while(!choice.equals("q")) {
            System.out.println();
            System.out.println();
            System.out.println("commit - update snapshot time");
            System.out.println("info<filename> - find information about the 'filename'");
            System.out.println("status - display all the changes in the files");
            System.out.println();
            System.out.println("q - to quit the program");
            System.out.println();
            choice = input.nextLine().toLowerCase();
            switch (choice) {
                case "commit":
                    document.commit();
                    break;
                case "info":
                    break;
                case "status":
                    document.status("Laboratory2/files");
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
