package io.output.gift;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import gift.Gift;

/**
 * Class created for JSON parsing.
 */
public class GiftOutput {
    @JsonProperty(Constants.PRODUCT_NAME)
    private String productName;

    @JsonProperty(Constants.PRICE)
    private Double price;

    @JsonProperty(Constants.CATEGORY)
    private Category category;

    public GiftOutput(final String productName, final Double price, final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public GiftOutput(final Gift gift) {
        this(
                gift.getProductName(),
                gift.getPrice(),
                gift.getCategory()
        );
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final void setPrice(final Double price) {
        this.price = price;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setCategory(final Category category) {
        this.category = category;
    }
}
