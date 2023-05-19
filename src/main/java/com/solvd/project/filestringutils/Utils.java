package com.solvd.project.filestringutils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static void main(String[] args) throws IOException {
        String linesFromFile = FileUtils.readFileToString(new File("src/main/resources/test.txt"), StandardCharsets.UTF_8);
        String[] words = StringUtils.split(linesFromFile);
        Map<String,Integer> result = new HashMap<>();
        for(String word: words) {
            if(result.containsKey(word)) {
                result.replace(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        for(String word: result.keySet()) {
            FileUtils.writeStringToFile(new File("src/main/resources/output.txt"),
                    word + " : " + result.get(word) + "\n", StandardCharsets.UTF_8, true);
        }
    }
}
