package com.rachit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringWrapperImplTest {

    StringWrapper stringWrapper;

    @Before
    public void setUp() throws Exception {
        stringWrapper = new StringWrapperImpl();
    }

    @Test
    public void processTest() {

        String input = "Four score and seven years ago our fathers brought forth upon this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal";

        String expectedOutput = "Four score\n" +
                "and seven\n" +
                "years ago our\n" +
                "fathers\n" +
                "brought\n" +                  //"brought forth" length is 13 hence it can be printed on same line
                "forth upon\n" +               //hence the expected Output is curated and used in assertion
                "this\n" +                     //these three lines should be shown as 2 lines "brought forth" and "upon this"
                "continent a\n" +
                "new nation,\n" +
                "conceived in\n" +
                "liberty and\n" +
                "dedicated to\n" +
                "the\n" +
                "proposition\n" +
                "that all men\n" +
                "are created\n" +
                "equal\n";

        expectedOutput = "Four score\n" +
                "and seven\n" +
                "years ago our\n" +
                "fathers\n" +
                "brought forth\n" +             //Curated Expected Output Lines (Line length 13)
                "upon this\n" +                 //Curated Expected Output Lines (Line length 9)
                "continent a\n" +
                "new nation,\n" +
                "conceived in\n" +
                "liberty and\n" +
                "dedicated to\n" +
                "the\n" +
                "proposition\n" +
                "that all men\n" +
                "are created\n" +
                "equal\n";

        String actualOutput = stringWrapper.wrap(input);

        assertEquals(expectedOutput, actualOutput);

    }

}
