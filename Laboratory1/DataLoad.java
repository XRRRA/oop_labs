package Laboratory1;

import Laboratory1.Operations.FileManager;

import java.util.List;

public class DataLoad {
    private static final List<Student> students = Student.getStudentsList();
    public static void loadData(){
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

    }
}
