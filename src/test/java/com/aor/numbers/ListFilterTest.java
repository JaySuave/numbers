package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    private List<Integer> list;
    @BeforeEach
    private void helper(){
        list = Arrays.asList(-1,-2,3,4,-5);
    }
    @Test
    public void positiveFilter(){
        List<Integer> expected = Arrays.asList(3,4);
        PositiveFilter positive = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(positive);
        List<Integer> list1 = filterer.filter(list);
        Assertions.assertEquals(expected,list1);
    }
    @Test
    public void divisibleFilter(){
        List<Integer> expected = Arrays.asList(-2,4);
        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(2);
        ListFilterer filterer = new ListFilterer(divisibleByFilter);
        List<Integer> list1 = filterer.filter(list);
        Assertions.assertEquals(expected,list1);
    }
    @Test
    public void filtererTest(){
        List<Integer> expected = list;
        GenericListFilter stub = Mockito.mock(GenericListFilter.class);
        Mockito.when(stub.accept(Mockito.anyInt())).thenReturn(true);
        ListFilterer listFilterer = new ListFilterer(stub);
        Assertions.assertEquals(expected,listFilterer.filter(list));
    }
}
