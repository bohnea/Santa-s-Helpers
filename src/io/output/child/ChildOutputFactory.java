package io.output.child;

import child.Child;
import gift.Gift;
import io.output.gift.GiftOutputFactory;

import java.util.List;

public final class ChildOutputFactory {
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
