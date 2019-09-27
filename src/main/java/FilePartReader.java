import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = "test";
        this.fromLine = -2;
        this.toLine = -1;
    }

    public FilePartReader(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public void setup() {

        if (toLine < fromLine) throw new IllegalArgumentException("To line is smaller than from line");

        if (fromLine < 1) throw new IllegalArgumentException("From Line is smaller than 1");

    }

    public String read() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getClass());
        } catch (IOException e) {
            System.out.println(e.getClass());
        }
        return stringBuilder.toString();
    }

    public String readLines() {
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String result;

        setup();

        stringList = Arrays.asList(read().split("\n"));

        if (fromLine - toLine == 0)
            result = stringList.get(fromLine - 1);
        else {
            for (int index = fromLine - 1; index <= toLine - 1; index++) {
                stringBuilder.append(stringList.get(index)).append("\n");
            }
            result = stringBuilder.toString();
        }


        return result;
    }
}
