package gift;

import database.DatabaseTrackable;
import enums.Category;

public class Gift implements DatabaseTrackable {
    private final String productName;
    private final Double price;
    private final Category category;

    public Gift(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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

    /**
     * Gets the primary key, for use with the database.
     * @return the primary key
     */
    @Override
    public final String getKey() {
        return productName + price;
    }
}
