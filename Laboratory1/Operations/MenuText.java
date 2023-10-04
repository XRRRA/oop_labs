package Laboratory1.Operations;

public class MenuText {
    public static void printMenuText(){
        System.out.println("Welcome to TUM's student management system!");
        System.out.println("What do you want to do?");
        System.out.println("g - General operations");
        System.out.println("f - Faculty operations");
        System.out.println("s - Student operations");
        System.out.println();
        System.out.println("q - Quit program");
        System.out.println();
        System.out.print("Your input: ");
    }
    public static void printStudentOpText(){
        System.out.println("Student operations");
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("be - batch enroll students (add the students' information in the enroll.txt file)");
        System.out.println("bg - batch graduate students (add the graduates' information in the graduate.txt file)");
        System.out.println();
        System.out.println("b - Back");
        System.out.println();
        System.out.print("Your input: ");
    }

    public static void printGeneralOpText(){
        System.out.println("General operations");
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
        System.out.println("ss/<student email> - search student and show faculty");
        System.out.println("df- display faculties");
        System.out.println("df/<field> - display all faculties of a field");
        System.out.println();
        System.out.println("b - Back");
        System.out.println();
        System.out.print("Your input: ");
    }

    public static void printFacultyOpText(){
        System.out.println("Faculty operations");
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - enroll a new student");
        System.out.println("gs/<email> - graduate student");
        System.out.println("ds/<faculty abbreviation> - display only the enrolled students");
        System.out.println("dg/<faculty abbreviation> - display only the graduated students");
        System.out.println("bf/<faculty abbreviation>/<email> - check if a student belongs to faculty");
        System.out.println();
        System.out.println("b - Back");
        System.out.println();
        System.out.print("Your input: ");
    }
}
