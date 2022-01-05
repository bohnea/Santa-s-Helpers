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

    @Override
    public String getKey() {
        return productName + price;
    }
}
