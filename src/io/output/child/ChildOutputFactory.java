package io.output.child;

import child.Child;
import gift.Gift;
import io.output.gift.GiftOutputFactory;

import java.util.List;

public final class ChildOutputFactory {
    /**
     * Hidden constructor.
     */
    private ChildOutputFactory() { }

    /**
     * Creates a new ChildOutput based on a child, an assigned budget and a list of gifts.
     * @param child the child on which the child output is based
     * @param assignedBudget the assigned budget on which the child output is based
     * @param receivedGifts the list of gifts on which the child output is based
     * @return the created child output
     */
    public static ChildOutput createChildOutput(final Child child, final Double assignedBudget,
                                                final List<Gift> receivedGifts) {
        return new ChildOutput(
                child.getId(),
                child.getLastName(),
                child.getFirstName(),
                child.getCity(),
                child.getAge(),
                child.getGiftsPreference(),
                child.getAverageScore(),
                child.getNiceScores(),
                assignedBudget,
                receivedGifts.stream().map(GiftOutputFactory::createGiftOutput).toList()
        );

    }
}
