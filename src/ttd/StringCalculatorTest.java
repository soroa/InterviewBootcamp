package ttd;


import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    void whenMoreThanTwoNumbersThrowExcpeption() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("1,2,3");
        });
    }
    @Test
    void whenStringEmpytReturnZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void whenOneNumberIsPassedReturnSameValue() {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    void whenTwoNumbersAreUsedNoExceptionIsThrown() {
        assertEquals(5, StringCalculator.add("2,3"));
    }

    @Test
    void whenArbitraryNumbersOfNumberNoExceptionThrown() {
        assertEquals(2 + 5 + 3 + 4 + 5 + 654 + 7, StringCalculator.add("2,5,3,4,5,654,7"));
    }

    @Test
    void whenNewLinesAreUsedAsSeparatorResultIsSumOfNumbers() {
        assertEquals(2 + 5 + 3 + 4 + 5 + 654 + 7, StringCalculator.add("2,5,3\n4,5\n654,7"));
    }

    @Test
    void whenDifferentLimitersArePassedInThePrefixTheSumIsReturned(){
        assertEquals(3, StringCalculator.add("//;\\n1;2"));
    }

    @Test
    void negativeNumbersThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->{
            StringCalculator.add("-2,-4,3");
        });
    }

    @Test
    void whenNumberBiggerThan1000ItIsIgnored(){
        assertEquals(2, StringCalculator.add("1001,2"));
    }
}
