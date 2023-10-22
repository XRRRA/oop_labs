package Laboratory2.classes;

import java.util.ArrayList;

public class DocumentChangeDetector {
    private final ArrayList<Document> documents = new ArrayList<>();
    private long lastSnapshotTime = 0;

    public void commit() {
        lastSnapshotTime = System.currentTimeMillis();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }

    public void status() {
        System.out.println("Created Snapshot at: " + lastSnapshotTime);
        for (Document document : documents) {
            if (document.hasChanged(lastSnapshotTime)) {
                System.out.println(document.getName() + " - Changed");
            } else {
                System.out.println(document.getName() + " No Change");
            }
        }
    }

    public void info(String filename) {
        for (Document document : documents) {
            if (document.getName().equals(filename)) {
                document.printInfo();
                return;
            }
        }
        System.out.println("File not found: " + filename);
    }
}
