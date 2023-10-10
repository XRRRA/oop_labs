package Laboratory1.Operations;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String DATA_FOLDER = "Laboratory1/Files/";

    private static final String STUDENT_FILE = DATA_FOLDER + "savedStudents.txt";
    private static final String FACULTY_FILE = DATA_FOLDER + "savedFaculties.txt";
    private static final String GRADUATE_FILE = DATA_FOLDER + "savedGraduates.txt";
    private static final String ACTION_FILE = DATA_FOLDER + "actions.txt";
    private static final String BATCH_ENROLL_FILE = DATA_FOLDER + "enroll.txt";

    public static void saveData(String command) {
        String dataToSave = command + "\n";
        if (command.length() > 1) {
            saveDataToFile(dataToSave, ACTION_FILE);
        }
        if (command.startsWith("ns/")) {
            saveDataToFile(dataToSave, STUDENT_FILE);
        } else if (command.startsWith("nf/")) {
            saveDataToFile(dataToSave, FACULTY_FILE);
        } else if (command.startsWith("gs/")) {
            saveDataToFile(dataToSave, GRADUATE_FILE);
        } else if (command.startsWith("be/")) {
            saveDataToFile(dataToSave, BATCH_ENROLL_FILE);
        } else if (command.startsWith("bg/")) {
            saveDataToFile(dataToSave, GRADUATE_FILE);
        }
    }

    private static List<String> loadData(String fileName) {
        List<String> data = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            data.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<String> loadStudentData() {
        return loadData(STUDENT_FILE);
    }

    public static List<String> loadFacultyData() {
        return loadData(FACULTY_FILE);
    }

    public static List<String> loadGraduateData() {
        return loadData(GRADUATE_FILE);
    }

    public static List<String> loadBatchEnrollData() {
        return loadData(BATCH_ENROLL_FILE);
    }

    private static void saveDataToFile(String data, String fileName) {
        try {
            Files.createDirectories(Paths.get(DATA_FOLDER));
            Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
