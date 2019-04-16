package com.rachit;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] argv) {

        String newline = System.getProperty("line.separator");

        StringWrapper stringWrapper = new StringWrapperImpl();

        String inputString;

        if (argv.length == 0) {
            inputString = "Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal";
        } else {
            //Passing the input as command line argument
            //Example: the brown fox jumps over the lazy dog
            inputString = String.join(" ", argv);
        }

        String wrappedString = stringWrapper.wrap(inputString);

        System.out.println(newline + "-----------OUTPUT-------------");
        System.out.println(wrappedString);
    }

}
