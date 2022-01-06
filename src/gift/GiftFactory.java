package gift;

import io.input.gift.GiftInput;

public final class GiftFactory {
    /**
     * Hidden constructor.
     */
    private GiftFactory() { }

    /**
     * Creates a new Gift based on the given GiftInput.
     * @param giftInput the gift input to turn into a gift
     * @return the created gift
     */
    public static Gift createGift(final GiftInput giftInput) {
        return new Gift(
                giftInput.getProductName(),
                giftInput.getPrice(),
                giftInput.getCategory()
        );
    }
}
