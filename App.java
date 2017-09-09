import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        App app = new App();
        ArrayList<FileData> filesList = app.getFilesList(args);
        app.displayResult(filesList);
    }

    public ArrayList<FileData> getFilesList(String[] args) {
        ArrayList<FileData> filesList = new ArrayList<>();

        if (args.length > 0) {
            for (int index = 0; index < args.length; index++) {
                String filename = args[index];
                FileData fileData = createFileData(filename);
                filesList.add(fileData);
            }

        } else {
            System.out.println("No file! If you need help - read about wc command line");
        }

        return filesList;
    }

    public FileData createFileData(String filename) {
        FileManager manager = new FileManager();
        manager.loadDataFromFile(filename);
        Integer lines = manager.countLines();
        Integer words = manager.countWords();
        Long bytes = manager.countBytes(filename);

        FileData fileData = new FileData(lines, words, bytes, filename);

        return fileData;
    }

    public void displayResult(ArrayList<FileData> filesList) {
        Integer totalLines = 0;
        Integer totalWords = 0;
        Long totalBytes = 0L;

        for (FileData fileData : filesList) {
            System.out.println(fileData);

            totalLines += fileData.getLines();
            totalWords += fileData.getWords();
            totalBytes += fileData.getBytes();
        }

        System.out.println(String.format("%d %d %d total", totalLines, totalWords, totalBytes));
    }
}