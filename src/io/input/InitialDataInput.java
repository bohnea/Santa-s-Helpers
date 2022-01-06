package io.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.input.child.ChildInput;
import io.input.gift.GiftInput;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class InitialDataInput {
    @JsonProperty(Constants.CHILDREN)
    private List<ChildInput> childInput;

    @JsonProperty(Constants.SANTA_GIFTS_LIST)
    private List<GiftInput> giftInput;

    public InitialDataInput() { }

    public final List<ChildInput> getChildInput() {
        return childInput;
    }

    public final void setChildInput(final List<ChildInput> childInput) {
        this.childInput = childInput;
    }

    public final List<GiftInput> getGiftInput() {
        return giftInput;
    }

    public final void setGiftInput(final List<GiftInput> giftInput) {
        this.giftInput = giftInput;
    }
}
