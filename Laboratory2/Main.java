package Laboratory2;

import Laboratory2.commands.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nextCommand = "";

        FolderMonitor fileMonitor = new FolderMonitor();
        fileMonitor.startFileMonitoring();

        while (!Objects.equals(nextCommand, "q")) {
            System.out.println();
            System.out.println();
            System.out.println("commit - update snapshot time");
            System.out.println("info <filename>  - find information about the 'filename'");
            System.out.println("status - display all the changes in the file folder");
            System.out.println();
            System.out.println("q - to quit the program");
            System.out.println();
            nextCommand = scanner.nextLine();
            ArrayList<String> parsedCommand = parseCommand(nextCommand);
            Command command;

            switch (parsedCommand.get(0)) {
                case "commit":
                    command = new CommitCommand();
                    command.invoke();
                    break;
                case "info":
                    if (parsedCommand.size() == 2) {
                        command = new InfoCommand(parsedCommand.get(1));
                        command.invoke();
                    } else {
                        System.out.println("Incorrect number of parameters");
                    }
                    break;
                case "status":
                    command = new StatusCommand();
                    command.invoke();
                    break;
                case "q":
                    System.exit(0);

                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }

        System.out.println("Exit");
        scanner.close();
    }

    public static ArrayList<String> parseCommand(String input) {
        String[] str = input.split(" ");

        return new ArrayList<>(Arrays.asList(str));
    }
}