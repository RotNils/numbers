package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private int div;

    public DivisibleByFilter(int div) {
        this.div = div;
    }

    @Override
    public boolean accept(Integer a) {
        return a % div == 0;
    }
}
