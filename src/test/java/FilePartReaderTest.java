import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;


public class FilePartReaderTest {

    ClassLoader classLoader = getClass().getClassLoader();


    @Test(expected = IllegalArgumentException.class)
    public void setup_Exception_toLineSmallerThanFromLine() {
        FilePartReader filePartReader= new FilePartReader("src/main/resources/test.txt",2,1);
        filePartReader.setup();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setup_Exception_fromLineSmallerThan1() {
        FilePartReader filePartReader= new FilePartReader("src/main/resources/test.txt",-1,1);
        filePartReader.setup();
    }

    @Test(expected = FileNotFoundException.class)
    public void filePathException(){
        FilePartReader filePartReader= new FilePartReader("src/main/resources/test2.txt",1,3);
        filePartReader.read();
    }

    @Test
    public void readFile() {
        FilePartReader filePartReader= new FilePartReader("src/main/resources/test.txt",-1,1);

        Assert.assertEquals(filePartReader.read(),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Etiam nec ala gravida neque, albinos ut euismod odio kajak .\n" +
                "Pellentesque auctor mauris kajak nec dolor zaraz ultrices consectetur.\n" +
                "Morbi pharetra ex auctor, suscipit odio et, placerat nunc.\n" +
                "Morbi vulputate nibh sed lobortis consequat. Etiam sed condimentum ante, vitae mollis turpis.\n" +
                "Donec metus tortor, imperdiet ut tristique eu, volutpat et ipsum.\n" +
                "Nam velit lectus, efficitur ac nisl et, malesuada laoreet dolor.\n" +
                "Quisque eget leo ultrices metus venenatis feugiat vitae at risus.\n" +
                "Nam vitae lacinia velit. Sed sem erat, congue a massa eu, lacinia mattis lectus.\n" +
                "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\n" +
                "Sed ac commodo ante.\n");
    }

    @Test
    public void readLines() {
        FilePartReader filePartReader= new FilePartReader("src/main/resources/test.txt",1,2);
        Assert.assertEquals(filePartReader.readLines(),"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n"+
                "Etiam nec ala gravida neque, albinos ut euismod odio kajak .\n");
    }

}