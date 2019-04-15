package com.rachit;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public String process(String inputString) {

        List<String> tokens = Collections.list(new StringTokenizer(inputString, " ")).stream().map(token -> (String) token).collect(Collectors.toList());
        List<String> newTokens = new ArrayList<>();

        StringBuffer maxLengthString1= new StringBuffer();
        StringBuffer maxLengthString2= new StringBuffer();
        Integer maxSize=13;

        StringBuilder wrappedString = new StringBuilder();

        String newline = System.getProperty("line.separator");

        for(String word : tokens) {

            maxLengthString2.append(" " + word);

            if(maxLengthString2.toString().trim().length()>maxSize) {
                wrappedString.append(maxLengthString1.toString().trim());
                wrappedString.append(newline);
                newTokens.add(maxLengthString1.toString().trim() + "(size=" +maxLengthString1.toString().trim().length() + ")");

                maxLengthString1 = new StringBuffer(word);
                maxLengthString2 = new StringBuffer(word);

            } else {
                maxLengthString1.append(" " +word);
            }
        }

        wrappedString.append(maxLengthString1.toString().trim());
        wrappedString.append(newline);
        newTokens.add(maxLengthString1.toString().trim());

        System.out.println("---------------- DEBUG Message ----------------");
        newTokens.forEach(System.out::println);

        return wrappedString.toString();
    }

    public static void main(String[] argv) {
        String newline = System.getProperty("line.separator");
        String inputString = "Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal";
        Main main = new Main();
        String wrappedString = main.process(inputString);
        System.out.println("---------------Actual Output-------------------");
        System.out.println(wrappedString);
    }

}
