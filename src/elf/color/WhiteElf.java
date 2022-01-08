package elf.color;

import child.Child;
import elf.Elf;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class WhiteElf extends Elf {
    @Override
    public double applyBudgetModifier(final Double budget) {
        return budget;
    }

    @Override
    public List<Gift> applyExtraGifts(final Child child) {
        return new ArrayList<>();
    }
}
