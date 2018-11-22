package br.com.flmwg.provadeliver.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(JUnit4.class)
public class SubsetTest {

    @Test
    public void shouldReturn_subsetMaxSum() {
        Integer[] set = new Integer[] {2,-4,6,8,-10,100,-6,5};
        ArrayList<Integer> setTest = new ArrayList<>(Arrays.asList(set));
        Subset subset = new Subset(setTest);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("2", "-4", "**6", "8", "-10", "100**", "-6", "5"));

        Assert.assertEquals(expected, subset.subsetMaxSum());
    }

    @Test
    public void shouldReturn_subsetNullOrEmpty() {
        Integer[] set = new Integer[] {0};
        ArrayList<Integer> setTest = new ArrayList<>(Arrays.asList(set));
        Subset subset = new Subset(setTest);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Conjunto NULO ou VAZIO"));

        Assert.assertEquals(expected, subset.subsetMaxSum());
    }
}