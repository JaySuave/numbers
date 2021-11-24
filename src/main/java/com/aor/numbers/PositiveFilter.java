package com.aor.numbers;

import java.util.List;

public class PositiveFilter implements GenericListFilter {
    public boolean accept(int number){
        if(number > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
