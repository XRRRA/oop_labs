package Laboratory2;

import Laboratory2.classes.*;
public class Main {
    public static void main(String[] args) {
        DocumentChangeDetector detector = new DocumentChangeDetector();

        TextDocument textFile = new TextDocument("test.txt", 100, 500, 3000);
        ImageDocument imageFile = new ImageDocument("image.png", 1024, 860);
        CodeDocument programFile = new CodeDocument("python_script.py", 500, 3, 10);

        detector.addDocument(textFile);
        detector.addDocument(imageFile);
        detector.addDocument(programFile);

        detector.commit();

        detector.status();
        detector.info("test.txt");
        detector.info("image.png");
        detector.info("python_script.py");
    }
}
