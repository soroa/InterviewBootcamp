package kth_element_unsorted_array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;


class KthSmallestTest {
    private Solution mSolution = new Solution();
    public void setup(){

    }

    @Test
    public void emptyArrayShouldThrowException() {
        ArrayList a = new ArrayList();
        assertThrows(IllegalArgumentException.class, () -> {
            mSolution.kthsmallest(a, 4);
        });
    }

    @Test
    public void testIndexGreaterThanSize(){
        ArrayList<Integer> a = new ArrayList();
        a.add(4);
        a.add(3);
        assertThrows(IllegalArgumentException.class, () -> {
            mSolution.kthsmallest(a, a.size()+3);
        });
    }

    @Test
    void whenRegularInput(){
        ArrayList<Integer> a = new ArrayList();
        a.add(4);
        a.add(3);
        a.add(43);
        a.add(34);
        a.add(22);
        Assertions.assertEquals(mSolution.kthsmallest(a, 1), 3);
        Assertions.assertEquals(mSolution.kthsmallest(a, 2), 4);
        Assertions.assertEquals(mSolution.kthsmallest(a, 3), 22);
        Assertions.assertEquals(mSolution.kthsmallest(a, 4), 34);
        Assertions.assertEquals(mSolution.kthsmallest(a, 5), 43);

    }







}