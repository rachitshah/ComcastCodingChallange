package com.rachit;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class StringWrapperImpl implements StringWrapper {

    public String wrap(String inputString) {

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
                newTokens.add(StringUtils.rightPad(maxLengthString1.toString().trim(),20) + "(size=" +maxLengthString1.toString().trim().length() + ")");

                maxLengthString1 = new StringBuffer(word);
                maxLengthString2 = new StringBuffer(word);

            } else {
                maxLengthString1.append(" " +word);
            }
        }

        wrappedString.append(maxLengthString1.toString().trim());
        wrappedString.append(newline);
        newTokens.add(StringUtils.rightPad(maxLengthString1.toString().trim(),20) + "(size=" +maxLengthString1.toString().trim().length() + ")");

        System.out.println(newline + "---------DEBUG Message--------");
        newTokens.forEach(System.out::println);

        return wrappedString.toString();
    }

}
