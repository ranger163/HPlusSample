package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    /**
     * this method reads HTML template as a string, replaces placeholders
     * with the values and return the entire page as a string
     *
     * @param filePath
     * @throws IOException
     * @retuen
     **/
    public static String getHtmlString(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = "";
        StringBuilder buffer = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        return buffer.toString();
    }
}
