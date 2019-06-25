package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class MyFileReader {

    private String pathString;

    public MyFileReader(String pathString) {
            this.pathString = pathString;
    }

    public String getText(){
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(pathString))) {
            stream.forEach(a -> sb.append(a + " "));
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
