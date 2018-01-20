package ru.edisoft;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementsRemoverTest {

    private List<Integer> inARowSequence = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 2, 2, 3, 3, 3, 4, 5));
    private List<Integer> randomSequence = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 3, 4, 3, 3, 2, 4, 3));

    @Test
    public void testRemoveRepeatedInARow3OrMoreTimes() throws Exception {
        List<Integer> result = ElementsRemover.removeRepeatedInARowSequence(inARowSequence, 3);
        Assert.assertEquals(Arrays.asList(1, 4, 5), result);
    }

    @Test
    public void testRepeatedRandom3OrMoreTimes() throws Exception {
        List<Integer> result = ElementsRemover.removeRepeatedRandomSequence(randomSequence, 3);
        Assert.assertEquals(Arrays.asList(1, 4, 4), result);
    }

}