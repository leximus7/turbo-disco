package ru.lebedev.javalearn.codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class DirReductionTest {
    @Test
    public void testSimpleDirReduc() throws Exception {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

        assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }

    @Test
    public void testNorthSouth() throws Exception {
        assertArrayEquals("NORTH SOUTH", new String[]{}, DirReduction.dirReduc(new String[]{"NORTH", "SOUTH"}));
    }

    @Test
    public void testNorth() throws Exception {
        assertArrayEquals("NORTH", new String[]{"NORTH"}, DirReduction.dirReduc(new String[]{"NORTH"}));

    }
}
