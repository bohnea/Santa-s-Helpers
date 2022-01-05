package gift;

import database.DatabaseTrackable;
import enums.Category;
import lombok.Getter;

public class Gift implements DatabaseTrackable {
    private final @Getter String productName;
    private final @Getter Double price;
    private final @Getter Category category;

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
