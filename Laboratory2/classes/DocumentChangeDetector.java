package Laboratory2.classes;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;

public class DocumentChangeDetector {
    private final ArrayList<Document> documents = new ArrayList<>();
    private long lastSnapshotTime = loadLastSnapshotTime(); // Load the last snapshot time from a file
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void displayLastSnapshotTime() {
        System.out.println("Last saved snapshot time: " + dateFormat.format(lastSnapshotTime));
    }

    public void commit() {
        lastSnapshotTime = System.currentTimeMillis();
        saveLastSnapshotTime(lastSnapshotTime); // Save the new snapshot time to a file
        System.out.println("Snapshot time updated to: " + dateFormat.format(lastSnapshotTime));
    }

    public void status(String rootFolderPath) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Path rootPath = Paths.get(rootFolderPath);
        Files.walkFileTree(rootPath, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String relativePath = rootPath.relativize(file).toString();
                long lastModifiedTime = attrs.lastModifiedTime().toMillis();
                if (lastModifiedTime > lastSnapshotTime) {
                    System.out.println(relativePath + " - Changed (on " + dateFormat.format(new Date(lastModifiedTime)) + ")");
                } else {System.out.println(relativePath + " - No Change");}
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private long loadLastSnapshotTime() {
        try {
            File file = new File("Laboratory2/last_snapshot_time.txt");
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                return Long.parseLong(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0; // Default to 0 if the snapshot time file is not found
    }

    private void saveLastSnapshotTime(long lastSnapshotTime) {
        try {
            File file = new File("Laboratory2/last_snapshot_time.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(Long.toString(lastSnapshotTime));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void removeDocument(Document document) {
        documents.remove(document);
    }

}
