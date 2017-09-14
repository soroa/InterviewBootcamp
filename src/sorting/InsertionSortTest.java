package sorting;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    InsertionSort insertionSort = new InsertionSort();

    @Test
    public void testSort() {
        Integer[] arr = {1, 62, 54, 8};
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
        Integer[] expected = {1, 8, 54, 62};
        ArrayList<Integer> expectedL = new ArrayList<>(Arrays.asList(arr));
        ArrayList<Integer> sorted = insertionSort.sort(al); // or whatever your sort method call it like
        assertArrayEquals(expectedL.toArray(), al.toArray());
    }
}
