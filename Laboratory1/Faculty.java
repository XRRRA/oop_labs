package Laboratory1;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
