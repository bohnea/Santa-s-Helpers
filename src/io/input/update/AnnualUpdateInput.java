package io.input.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.input.gift.GiftInput;
import io.input.child.ChildInput;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AnnualUpdateInput {
    @JsonProperty(Constants.NEW_SANTA_BUDGET)
    private @Getter @Setter Double newSantaBudget;

    @JsonProperty(Constants.NEW_GIFTS)
    private @Getter @Setter List<GiftInput> newGifts;

    @JsonProperty(Constants.NEW_CHILDREN)
    private @Getter @Setter List<ChildInput> newChildren;

    @JsonProperty(Constants.CHILDREN_UPDATES)
    private @Getter @Setter List<ChildUpdateInput> childrenUpdates;

    public AnnualUpdateInput() { }
}
