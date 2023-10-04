package Laboratory1.Operations;

import Laboratory1.Faculty;
import Laboratory1.Student;
import Laboratory1.StudyField;

import java.util.List;

public class Commands {
    private static final List<Student> students = Student.getStudentsList();
    private static final List<Faculty> faculties = Faculty.getFacultyList();
    private static final List<String> batchEnrollData = FileManager.loadBatchEnrollData();
    private static final List<String> batchGraduateData = FileManager.loadBatchGraduateData();
    public static void enrollStudent(String[] parts) {
        if (parts.length == 8) {
            FileManager.saveData(parts[0] + "/" + parts[1] + "/" + parts[2] + "/" + parts[3] + "/" + parts[4] + "/" + parts[5] + "/" + parts[6] + "/" + parts[7]);
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
            } else {
                System.out.println("Faculty not found for abbreviation: '" + facultyAbbreviation + "'. Please try again");
            }
        } else {
            System.out.println("Invalid input for enrolling a student. Please follow the format and try again.");
        }
        System.out.println();
        System.out.println();
    }

    public static void graduateStudent(String[] parts) {
        if (parts.length == 2) {
            FileManager.saveData(parts[0] + "/" + parts[1]);
            String email = parts[1];
            for (Student student : students) {
                if (student.getEmail().equals(email)) {
                    student.graduate();
                    System.out.println("Student with email " + email + " has graduated.");
                    System.out.println();
                    System.out.println();
                    return;
                }
            }
            System.out.println("Student with email " + email + " not found.");
        } else {
            System.out.println("Invalid input for graduating a student. Please follow the format and try again");
        }
        System.out.println();
        System.out.println();
    }

    public static void displayEnrolledStudents(String[] parts) {
        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];
            System.out.println("Enrolled students for faculty " + facultyAbbreviation + ":");
            for (Student student : students) {
                if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && !student.isGraduated()) {
                    System.out.println(" - " + student.getEmail());
                }
            }
        } else {
            System.out.println("Invalid input for displaying the students. Please follow the format and try again.");
        }
        System.out.println();
        System.out.println();
    }

    public static void displayGraduatedStudents(String[] parts) {
        if (parts.length == 2) {
            String facultyAbbreviation = parts[1];
            System.out.println("Graduated students for faculty " + facultyAbbreviation + ":");
            for (Student student : students) {
                if (student.getFacultyAbbreviation().equals(facultyAbbreviation) && student.isGraduated()) {
                    System.out.println(" - " + student.getEmail());
                }
            }
        } else {
            System.out.println("Invalid input for displaying the graduates. Please follow the format and try again");
        }
        System.out.println();
        System.out.println();
    }

    public static void checkBelongingToFaculty(String[] parts) {
        if (parts.length == 3) {
            String facultyAbbreviation = parts[1];
            String email = parts[2];
            for (Student student : students) {
                if (student.getEmail().equals(email) && student.getFacultyAbbreviation().equals(facultyAbbreviation)) {
                    System.out.println("Student with email " + email + " belongs to faculty " + facultyAbbreviation);
                    System.out.println();
                    System.out.println();
                    return;
                }
            }
            System.out.println("Student with email " + email + " does not belong to faculty " + facultyAbbreviation);
        } else {
            System.out.println("Invalid input for checking the belonging to the faculty. Please follow the format.");
        }
        System.out.println();
        System.out.println();
    }

    public static void createFaculty(String[] parts) {
            if (parts.length == 4) {
                FileManager.saveData(parts[0] + "/" + parts[1] + "/" + parts[2] + "/" + parts[3]);
                String facultyName = parts[1];
                String facultyAbbreviation = parts[2];
                StudyField studyField = StudyField.valueOf(parts[3]);
                Faculty faculty = new Faculty(facultyName, facultyAbbreviation, studyField);
                Faculty.addFaculty(faculty);
                System.out.println("New Faculty created.");
            } else {
                System.out.println("Invalid input for creating a faculty. Please follow the format and try again");
            }
            System.out.println();
            System.out.println();
    }

    public static void searchStudent(String[] parts) {
        if (parts.length == 2) {
            String email = parts[1];
            boolean studentFound = false;
            for (Student student : students) {
                if (student.getEmail().equals(email)) {
                    System.out.println("Student found:");
                    System.out.println(student.getFirstName() + " " + student.getLastName());
                    System.out.println("Belongs to faculty: " + student.getFacultyAbbreviation());
                    studentFound = true;
                    break;
                }
            }
            if (!studentFound) {
                System.out.println("Student with email " + email + " not found.");
            }
        } else {
            System.out.println("Invalid input for searching a student. Please follow the format and try again");
        }
        System.out.println();
        System.out.println();
    }

    public static void displayAllFaculties(){
        System.out.println("The available faculties:");
        for (Faculty faculty : faculties) {
            System.out.println(" - " + faculty.getName());
        }
        System.out.println();
        System.out.println();
    }

    public static void displayFieldFaculties(String[] parts) {
        if (parts.length == 2) {
            String field = parts[1];
            if (StudyField.validation(field)) {
                System.out.println("The faculties from the "+field+" field are:");
                for (Faculty faculty: faculties){
                    if (faculty.getStudyField().toString().equals(field)){
                        System.out.println(" - " + faculty.getName());
                    }
                }
            } else {
                System.out.println("There does not exist such a field. Please introduce a valid field and try again");
            }
        } else {
            System.out.println("Invalid input for displaying the faculties. Please follow the format and try again");
        }
        System.out.println();
        System.out.println();
    }

    public static void batchEnroll(){
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
    }

    public static void batchGraduate(){
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
    }
}
