public class App {

    public static void main(String[] args) {

        //FilePartReader filePartReader = new FilePartReader();
        FilePartReader filePartReader = new FilePartReader("src/main/resources/test.txt",1,1);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        System.out.println(filePartReader.readLines());
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println("Substring "+fileWordAnalyzer.getWordsContainingSubstring(""));
        System.out.println("Palindromes "+fileWordAnalyzer.getStringsWhichPalindromes());
    }
}
