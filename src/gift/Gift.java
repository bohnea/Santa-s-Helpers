package gift;

import database.DatabaseTrackable;
import enums.Category;

public class Gift implements DatabaseTrackable {
    private String productName;
    private Double price;
    private Category category;

    public Gift(String productName, Double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getKey() {
        return productName + price;
    }
}
