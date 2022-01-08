package elf.color;

import child.Child;
import elf.Elf;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public final class PinkElf extends Elf {
    /**
     * Increases the given budget by 30%.
     * @param budget the budget to modify
     * @return the modified budget
     */
    @Override
    public double applyBudgetModifier(final Double budget) {
        // Constant variables
        final double oneHundred = 100.0d;
        final double percentage = 30.0d;

        // Return the new budget
        return budget + budget * percentage / oneHundred;
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
