public class FileData {

    private Integer lines;
    private Integer words;
    private Long bytes;
    private String filename;

    public FileData(Integer lines, Integer words, Long bytes, String filename) {
        this.lines = lines;
        this.words = words;
        this.bytes = bytes;
        this.filename = filename;
    }

    public Integer getLines() {
        return lines;
    }

    public Integer getWords() {
        return words;
    }

    public Long getBytes() {
        return bytes;
    }

    public String toString() {
        return String.format("%d %d %d %s", lines, words, bytes, filename);
    }
}