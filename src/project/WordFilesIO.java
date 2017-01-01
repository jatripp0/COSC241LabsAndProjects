package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * A class to handle file input
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class WordFilesIO {
    
    /**
     * Attempts to create a list of Strings by reading in a text file.
     * @return a list of strings containing the lines from the text file.
     * @throws IOException if the given path does not locate the input file.
     */
    public static List<String> readFile(String fpath) throws IOException{
        
        return Files.readAllLines(Paths.get(fpath).toAbsolutePath());
    }
}
