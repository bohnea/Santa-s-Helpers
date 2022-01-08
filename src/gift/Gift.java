package gift;

import database.DatabaseTrackable;
import enums.Category;

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

    public final String getProductName() {
        return productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final Category getCategory() {
        return category;
    }

    public int getQuantity() {
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
     * @param quantity the added quantity
     */
    public final void addQuantity(final int quantity) {
        this.quantity += quantity;
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
