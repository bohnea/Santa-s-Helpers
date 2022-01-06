package io.output.gift;

import gift.Gift;

public final class GiftOutputFactory {
    /**
     * Hidden constructor.
     */
    private GiftOutputFactory() { }

    /**
     * Creates a new GiftOutput based on a gift.
     * @param gift the gift on which the gift output is based
     * @return the created gift output
     */
    public static GiftOutput createGiftOutput(final Gift gift) {
        return new GiftOutput(
                gift.getProductName(),
                gift.getPrice(),
                gift.getCategory()
        );
    }
}
