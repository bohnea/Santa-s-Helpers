package io.output.gift;

import gift.Gift;

import java.util.List;

public final class GiftOutputFactory {
    public static GiftOutput createGiftOutput(final Gift gift) {
        return new GiftOutput(
                gift.getProductName(),
                gift.getPrice(),
                gift.getCategory()
        );
    }
}
