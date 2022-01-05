package gift;

import io.input.gift.GiftInput;

public class GiftFactory {
    public static Gift createGift(GiftInput giftInput) {
        return new Gift(
                giftInput.getProductName(),
                giftInput.getPrice(),
                giftInput.getCategory()
        );
    }
}
