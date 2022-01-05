package io;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import lombok.Getter;
import lombok.Setter;

public class GiftInput {
    @JsonProperty(Constants.PRODUCT_NAME)
    private @Getter @Setter String productName;

    @JsonProperty(Constants.PRICE)
    private @Getter @Setter Double price;

    @JsonProperty(Constants.CATEGORY)
    private @Getter @Setter Category category;

    public GiftInput() { }
}
