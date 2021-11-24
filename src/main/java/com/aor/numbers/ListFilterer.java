package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filter;
    public ListFilterer(GenericListFilter filter){
        this.filter = filter;
    }
    public List<Integer> filter(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        for(int element:list){
            if(filter.accept(element)){
                list1.add(element);
            }
        }
        return list1;
    }
}
