package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private int divider;
    public DivisibleByFilter(int divider){
        this.divider = divider;
    }
    public boolean accept(int number){
        if(number % divider == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
