package com.solvd.course.hm.project.it.utils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UniqueWordsCounter {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\admin\\solvd_test_auto_mvn\\src\\main\\java\\com\\solvd\\course\\hm\\project\\it\\utils\\input.txt";
        String outputFile = "C:\\Users\\admin\\solvd_test_auto_mvn\\src\\main\\java\\com\\solvd\\course\\hm\\project\\it\\utils\\output.txt";

        List<String> lines;
        try {
            lines = FileUtils.readLines(new File(inputFile), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Set<String> uniqueWords = new HashSet<>();
        for (String line : lines) {
            String[] words = StringUtils.split(line);
            if (words != null) {
                uniqueWords.addAll(Arrays.asList(words));
            }
        }

        try {
            FileUtils.writeLines(new File(outputFile), uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of unique words: " + uniqueWords.size());
    }
}