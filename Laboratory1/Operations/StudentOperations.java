package Laboratory1.Operations;

import Laboratory1.Student;

import java.util.List;
import java.util.Scanner;

public class StudentOperations {
    private static final List<Student> students = Student.getStudentsList();
    public static void studentOperations(Scanner input){
        List<String> batchEnrollData = FileManager.loadBatchEnrollData();
        List<String> batchGraduateData = FileManager.loadBatchGraduateData();
        Scanner scan = new Scanner(System.in);
        label:
        while (true){
            System.out.println("Student operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("be - batch enroll students (add the students' information in the enroll.txt file)");
            System.out.println("bg - batch graduate students (add the graduates' information in the graduate.txt file)");
            System.out.println();
            System.out.println("b - Back");
            System.out.println("q - Quit program");
            System.out.println();
            System.out.print("Your input: ");
            String choice = input.nextLine().trim();
            choice = choice.toLowerCase();
            switch (choice) {
                case "be":
                    for (String studentInfo : batchEnrollData) {
                        String[] bEnrollParts = studentInfo.split("/");
                        if (bEnrollParts.length == 8) {
                            FileManager.saveData(studentInfo);
                            String facultyAbbreviation = bEnrollParts[1];
                            String studentFirstName = bEnrollParts[2];
                            String studentLastName = bEnrollParts[3];
                            String email = bEnrollParts[4];
                            int birthDay = Integer.parseInt(bEnrollParts[5]);
                            int birthMonth = Integer.parseInt(bEnrollParts[6]);
                            int birthYear = Integer.parseInt(bEnrollParts[7]);
                            Student student = new Student(studentFirstName, studentLastName, email, birthDay, birthMonth, birthYear, facultyAbbreviation);
                            students.add(student);
                        }
                    }
                    break;
                case "bg":
                    for (String graduateInfo : batchGraduateData) {
                        String[] bGraduateParts = graduateInfo.split("/");
                        if (bGraduateParts.length == 2) {
                            FileManager.saveData(graduateInfo);
                            String email = bGraduateParts[1];
                            for (Student student : students) {
                                if (student.getEmail().equals(email)) {
                                    student.graduate();
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case "b":
                    break label;
                case "q":
                    System.out.println("Quitting the program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                    break;
            }
        }

    }
}
