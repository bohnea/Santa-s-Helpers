package elf.color;

import child.Child;
import database.managers.search.SearchManager;
import elf.Elf;
import enums.Category;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public final class YellowElf extends Elf {
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
     * Returns a single gift, the cheapest of the given child's preferred category,
     * only if the gift is in stock (has a quantity greater than 0).
     * @param child the child
     * @return a list with the cheapest preferred gift, if in stock, otherwise an empty list
     */
    @Override
    public List<Gift> applyExtraGifts(final Child child) {
        // Get the child's preferred category
        Category preferredCategory = child.getGiftsPreference().get(0);
        if (preferredCategory == null) {
            return new ArrayList<>();
        }

        // Get the cheapest gift of that category
        Gift cheapestGift = SearchManager.getCheapestGiftOfCategory(preferredCategory, false);
        if (cheapestGift == null) {
            return new ArrayList<>();
        }

        // Check if the quantity of the gift is 0
        if (cheapestGift.getQuantity() == 0) {
            return new ArrayList<>();
        }

        // Reduce the gifts quantity and return the gift
        cheapestGift.reduceQuantity();
        return List.of(cheapestGift);
    }
}
