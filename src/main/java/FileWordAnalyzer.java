import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically() {
        List<String> resultList = new ArrayList<>();
        resultList = Arrays.asList(filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "").split(" "));
        resultList.sort(String::compareToIgnoreCase);
        return resultList;
    }

    public List getWordsContainingSubstring(String subString) {
        List<String> wordsList;
        List<String> resultList = new ArrayList<>();

        wordsList = Arrays.asList(filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "").split(" "));

        for(String word : wordsList ){
            if(word.contains(subString))
                resultList.add(word);
        }

    return resultList;
    }

    public List getStringsWhichPalindromes () {
        List<String> resultList = new ArrayList<>();
        List<String> wordsList;
        wordsList = Arrays.asList(filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "").split(" "));

        for(String word : wordsList ){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(word).reverse();
            if(word.equals(stringBuilder.toString()))
                resultList.add(word);
        }
        return resultList;
    }
}
