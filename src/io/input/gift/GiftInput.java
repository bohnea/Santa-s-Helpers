package io.input.gift;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;

/**
 * Class created for JSON parsing.
 */
public class GiftInput {
    @JsonProperty(Constants.PRODUCT_NAME)
    private String productName;

    @JsonProperty(Constants.PRICE)
    private Double price;

    @JsonProperty(Constants.CATEGORY)
    private Category category;

    @JsonProperty(Constants.QUANTITY)
    private Integer quantity;

    public GiftInput() { }

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

    public final Integer getQuantity() {
        return quantity;
    }

    public final void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
