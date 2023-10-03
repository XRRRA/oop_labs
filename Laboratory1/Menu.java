package Laboratory1;

import Laboratory1.Operations.FacultyOperations;
import Laboratory1.Operations.FileManager;
import Laboratory1.Operations.GeneralOperations;
import Laboratory1.Operations.StudentOperations;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final List<Student> students = Student.getStudentsList();
    public static void topMenu(){
        List<String> facultiesData = FileManager.loadFacultyData();
        List<String> studentData = FileManager.loadStudentData();
        List<String> graduatesData = FileManager.loadGraduateData();

        for (String facultyInfo : facultiesData) {
            String[] parts = facultyInfo.split("/");
            if (parts.length == 4) {
                String facultyName = parts[1];
                String facultyAbbreviation = parts[2];
                StudyField studyField = StudyField.valueOf(parts[3]);
                Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                Faculty.addFaculty(faculty);
            }
        }

        for (String studentInfo : studentData) {
            String[] parts = studentInfo.split("/");
            if (parts.length == 8) {
                String facultyAbbreviation = parts[1];
                String studentFirstName = parts[2];
                String studentLastName = parts[3];
                String email = parts[4];
                int birthDay = Integer.parseInt(parts[5]);
                int birthMonth = Integer.parseInt(parts[6]);
                int birthYear = Integer.parseInt(parts[7]);
                Student student = new Student(studentFirstName, studentLastName, email, birthDay, birthMonth, birthYear, facultyAbbreviation);
                students.add(student);
            }
        }

        for (String graduateInfo : graduatesData) {
            String[] parts = graduateInfo.split("/");
            if (parts.length == 2) {
                String email = parts[1];
                for (Student student : students) {
                    if (student.getEmail().equals(email)) {
                        student.graduate();
                        break;
                    }
                }
            }
        }

        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println("g - General operations");
            System.out.println("f - Faculty operations");
            System.out.println("s - Student operations");
            System.out.println();
            System.out.println("q - Quit program");
            System.out.println();
            System.out.print("Your input: ");
            String choice = input.nextLine();
            choice = choice.toLowerCase();
            if (choice.equals("g")) {
                GeneralOperations.generalOperations(input);
            } else if (choice.equals("f")) {
                FacultyOperations.facultyOperations(input);
            } else if (choice.equals("s")){
                StudentOperations.studentOperations(input);
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
