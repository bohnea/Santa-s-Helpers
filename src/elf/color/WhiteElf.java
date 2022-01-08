package elf.color;

import child.Child;
import elf.Elf;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public final class WhiteElf extends Elf {
    /**
     * Leaves the given budget unmodified.
     * @param budget the budget to modify
     * @return the same given budget
     */
    @Override
    public double applyBudgetModifier(final Double budget) {
        return budget;
    }

    /**
     * Doesn't return any gifts.
     * @param child the child
     * @return an empty list
     */
    @Override
    public List<Gift> applyExtraGifts(final Child child) {
        return new ArrayList<>();
    }
}
