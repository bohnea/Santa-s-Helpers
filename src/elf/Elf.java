package elf;

import child.Child;
import gift.Gift;

import java.util.List;

public abstract class Elf {
    /**
     * Applies a modifier onto the given budget.
     * @param budget the budget to modify
     * @return the modified budget
     */
    public abstract double applyBudgetModifier(Double budget);

    /**
     * Returns a list of gifts based on the given child.
     * @param child the child
     * @return an extra gift list based on the child
     */
    public abstract List<Gift> applyExtraGifts(Child child);
}
