package Laboratory1.Operations;

import Laboratory1.Faculty;
import Laboratory1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacultyOperations {
    private static final List<Student> students = Student.getStudentsList();
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    public static void facultyOperations(Scanner input) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Faculty operations");
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - enroll a new student");
            System.out.println("gs/<email> - graduate student");
            System.out.println("ds/<faculty abbreviation> - display only the enrolled students");
            System.out.println("dg/<faculty abbreviation> - display only the graduated students");
            System.out.println("bf/<faculty abbreviation>/<email> - check if student belongs to faculty");
            System.out.println();
            System.out.println("b - Back");
            System.out.println("q - Quit program");
            System.out.println();
            System.out.print("Your input: ");
            String choice = input.nextLine().trim();
            String[] parts = choice.split("/");
            if (choice.startsWith("ns/")) {
                if (parts.length == 8) {
                    String facultyAbbreviation = parts[1];
                    String studentFirstName = parts[2];
                    String studentLastName = parts[3];
                    String email = parts[4];
                    int birthDay = Integer.parseInt(parts[5]);
                    int birthMonth = Integer.parseInt(parts[6]);
                    int birthYear = Integer.parseInt(parts[7]);
                    Faculty faculty = Faculty.findFacultyByAbbreviation(faculties, facultyAbbreviation);
                    if (faculty != null) {
                        Student student = new Student(studentFirstName, studentLastName, email, birthDay, birthMonth, birthYear, facultyAbbreviation);
                        Student.addStudent(student);
                        student.linkWithFaculty(faculty);
                        faculty.addStudent(student);
                        System.out.println("New student enrolled.");
                        System.out.println();
                        System.out.println();
                    } else {
                        System.out.println("Faculty not found for abbreviation: " + facultyAbbreviation + ". Do you want to try again? y/n");
                        System.out.print("Your input: ");
                        String decision = scan.nextLine();
                        decision = decision.toLowerCase();
                        if (decision.equals("n")) System.exit(0);
                    }
                } else {
                    System.out.println("Invalid input for enrolling a student. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            }
            else if (choice.startsWith("gs/")) {
                if (parts.length == 2) {
                    String email = parts[1];
                    for (Student student : students) {
                        if (student.getEmail().equals(email)) {
                            student.graduate();
                            System.out.println("Student with email " + email + " has graduated.");
                            return;
                        }
                    }
                    System.out.println("Student with email " + email + " not found.");
                    System.out.println();
                    System.out.println();
                    } else {
                        System.out.println("Invalid input for graduating a student. Please follow the format. Do you want to try again? y/n");
                        System.out.print("Your input: ");
                        String decision = scan.nextLine();
                        decision = decision.toLowerCase();
                        if (decision.equals("n")) System.exit(0);
                    }
                } else if (choice.startsWith("ds/")) {
                if (parts.length == 2) {
                    String facultyAbbreviation = parts[1];
                    System.out.println("Enrolled students for faculty " + facultyAbbreviation + ":");
                    for (Student student : students) {
                        if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && !student.isGraduated()) {
                            System.out.println(" - " + student.getEmail());
                        }
                    }
                    System.out.println();
                    System.out.println();
                } else {
                    System.out.println("Invalid input for displaying the students. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            } else if (choice.startsWith("dg/")) {
                if (parts.length == 2) {
                    String facultyAbbreviation = choice.substring(3);
                    System.out.println("Graduated students for faculty " + facultyAbbreviation + ":");
                    for (Student student : students) {
                        if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && student.isGraduated()) {
                            System.out.println(" - " + student.getEmail());
                        }
                    }
                } else {
                    System.out.println("Invalid input for displaying the graduates. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            } else if (choice.startsWith("bf/")) {
                if (parts.length == 3) {
                    String facultyAbbreviation = parts[1];
                    String email = parts[2];
                    for (Student student : students) {
                        if (student.getEmail().equals(email) && student.getFacultyAbbreviation().equals(facultyAbbreviation)) {
                            System.out.println("Student with email " + email + " belongs to faculty " + facultyAbbreviation);
                            return;
                        }
                    }
                    System.out.println("Student with email " + email + " does not belong to faculty " + facultyAbbreviation);
                } else {
                    System.out.println("Invalid input for checking the belonging to the faculty. Please follow the format. Do you want to try again? y/n");
                    System.out.print("Your input: ");
                    String decision = scan.nextLine();
                    decision = decision.toLowerCase();
                    if (decision.equals("n")) System.exit(0);
                }
            } else if (choice.equals("b")) {
                break;
            } else if (choice.equals("q")) {
                System.out.println("Quitting the program");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Do you want to try again? y/n");
                System.out.print("Your input: ");
                String decision = scan.nextLine();
                decision = decision.toLowerCase();
                if (decision.equals("n")) System.exit(0);
            }
        }
    }
}
