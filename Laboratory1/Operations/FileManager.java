package Laboratory1;

import java.io.*;

public class FileManager {
    private static final String STUDENT_FILE = "savedStudents.txt";
    private static final String FACULTY_FILE = "savedFaculties.txt";
    private static final String GRADUATE_FILE = "savedGraduates.txt";

    public static void saveData(String command) {
        String[] parts = command.split("/");
        String dataToSave = parts[1] + "\n";

        if (command.startsWith("ns/")) {
            saveDataToFile(dataToSave, STUDENT_FILE);
        } else if (command.startsWith("nf/")) {
            saveDataToFile(dataToSave, FACULTY_FILE);
        } else if (command.startsWith("gs/")) {
            saveDataToFile(dataToSave, GRADUATE_FILE);
        }
    }

    private static void saveDataToFile(String data, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
