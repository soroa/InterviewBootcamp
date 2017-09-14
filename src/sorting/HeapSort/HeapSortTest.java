package sorting.HeapSort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    public void testSort() {
        Integer[] arr = {1, 62, 54, 8};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        Integer[] expected = {62, 54, 8, 1};
        ArrayList<Integer> expectedL = new ArrayList<>(Arrays.asList(expected));
        ArrayList<Integer> sorted = HeapSort.sort(al); // or whatever your sort method call it like
        assertArrayEquals(expectedL.toArray(), sorted.toArray());
    }

}