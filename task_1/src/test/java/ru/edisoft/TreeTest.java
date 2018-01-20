package ru.edisoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTest {

    @Test
    public void testTreeHeight() throws Exception {

        Tree tree = new Tree(new int[]{53, 30, 72, 14, 39, 61, 84, 9, 23, 34, 47, 79});
        assertEquals(4, tree.height());

    }

}
