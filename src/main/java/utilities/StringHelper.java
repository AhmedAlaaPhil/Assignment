package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringHelper {





    // Function to remove white spaces from string
    public static String removeWhiteSpaces (String str){
        String result ;
        result = str.replaceAll("\\s", "");

        return result;
    }


    // Function to read json file and convert it to string
    public static String convertJsonToString (String fileName) throws IOException {

        String result;

        result = new String(Files.readAllBytes(Paths.get(fileName)));

        return result;
    }
}
