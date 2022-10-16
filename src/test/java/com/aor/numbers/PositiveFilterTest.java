package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PositiveFilterTest {

    @Test
    public void test(){
        PositiveFilter filter = new PositiveFilter();
        List<Integer> positives = Arrays.asList(1,65,654,6542,Integer.MAX_VALUE);
        for (int i : positives){
            Assertions.assertTrue(filter.accept(i));
        }
    }
}
