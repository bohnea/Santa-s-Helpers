package gift;

import database.DatabaseTrackable;
import enums.Category;
import io.input.gift.GiftInput;

public class Gift implements DatabaseTrackable {
    private final String productName;
    private final Double price;
    private final Category category;
    private int quantity;

    public Gift(final String productName, final Double price,
                final Category category, final int quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public Gift(final GiftInput giftInput) {
        this(
                giftInput.getProductName(),
                giftInput.getPrice(),
                giftInput.getCategory(),
                giftInput.getQuantity()
        );
    }

    public final String getProductName() {
        return productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final Category getCategory() {
        return category;
    }

    public final int getQuantity() {
        return quantity;
    }

    /**
     * Reduces the quantity of the gift by 1.
     */
    public final void reduceQuantity() {
        --quantity;
    }

    /**
     * Adds the given number to the gift's quantity.
     * @param quantityToAdd the added quantity
     */
    public final void addQuantity(final int quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    /**
     * Gets the primary key, for use with the database.
     * @return the primary key
     */
    @Override
    public final String getKey() {
        return productName + category + price;
    }
}
