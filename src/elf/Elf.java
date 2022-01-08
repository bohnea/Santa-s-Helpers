package elf;

import child.Child;
import gift.Gift;

import java.util.List;

public abstract class Elf {
    public abstract double applyBudgetModifier(final Double budget);
    public abstract List<Gift> applyExtraGifts(final Child child);
}
