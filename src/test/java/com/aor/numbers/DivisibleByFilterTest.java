package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DivisibleByFilterTest {

    @Test
    void divBy2() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        List<Integer> div = Arrays.asList(0,2,66,88,1000);

        for (int i : div)
            Assertions.assertTrue(filter.accept(i));
    }

    @Test
    void divBy2_false() {
        DivisibleByFilter filter = new DivisibleByFilter(2);
        List<Integer> div = Arrays.asList(7,3,67,89,1001);

        for (int i : div)
            Assertions.assertFalse(filter.accept(i));
    }
}
