package com.julia;

import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

public class SortedNumbersListTest {

     SortedNumbersList list;
     int[] array;


    @Before
    public void init() {
        array = new int[]{19, 8, -6, 34};
        list = new SortedNumbersList(array);
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testGet_allElements() {
        assertEquals(-6, list.get(0));
        assertEquals(8, list.get(1));
        assertEquals(19, list.get(2));
        assertEquals(34, list.get(3));
    }

    @Test
    public void testContains_true() {
        assertTrue(list.contains(-6));
        assertTrue(list.contains(8));
        assertTrue(list.contains(19));
        assertTrue(list.contains(34));
    }

    @Test
    public void testContains_false() {
        assertFalse(list.contains(-5));
        assertFalse(list.contains(9));
        assertFalse(list.contains(25));
    }

    @Test
    public void testUnion() {
        SortedNumbersList list = new SortedNumbersList(new int[]{1,1,2,3,4,5});
        SortedNumbersList list2 = new SortedNumbersList(new int[]{-11,1,5,4,9,12});
        SortedNumbersList unionResult = list.union(list2);

        SortedNumbersList expected = new SortedNumbersList(new int[]{-11, 1, 2, 3, 4, 5, 9, 12});  //ожидаемый
        assertEquals(unionResult.size(), expected.size());
        for (int i = 0; i < unionResult.size(); i++) {
            assertEquals(unionResult.get(i), expected.get(i));
        }
    }
}


