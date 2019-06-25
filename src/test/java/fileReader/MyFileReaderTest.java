package fileReader;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MyFileReaderTest {

    @Test
    public void myFileReaderTest(){
        String path = "sample.txt";
        String result = "Editors, who receive no royalties or expenses and who are only very rarely commissioned by the Society. line 2 line 3 ";
        MyFileReader fileReader = new MyFileReader(path);
        assertEquals(result, fileReader.getText());
    }
}
