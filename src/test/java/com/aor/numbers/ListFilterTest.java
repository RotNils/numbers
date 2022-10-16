package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

class ListFiltererTest {

    @Test
    public void test() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        ListFilterer filterer = new ListFilterer(filter);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(2)).thenReturn(true);
        Mockito.when(filter.accept(3)).thenReturn(false);
        Mockito.when(filter.accept(4)).thenReturn(false);
        Mockito.when(filter.accept(5)).thenReturn(true);
        Mockito.when(filter.accept(6)).thenReturn(true);
        Assertions.assertEquals(Arrays.asList(1, 2, 5, 6), filterer.filter(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
