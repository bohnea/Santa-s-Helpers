package elf.color;

import child.Child;
import elf.Elf;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class BlackElf extends Elf {
    @Override
    public double applyBudgetModifier(final Double budget) {
        return budget - budget * 30.0d / 100.0d;
    }

    @Override
    public List<Gift> applyExtraGifts(final Child child) {
        return new ArrayList<>();
    }
}
