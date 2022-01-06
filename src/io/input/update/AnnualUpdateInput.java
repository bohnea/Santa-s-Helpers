package io.input.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.input.gift.GiftInput;
import io.input.child.ChildInput;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class AnnualUpdateInput {
    @JsonProperty(Constants.NEW_SANTA_BUDGET)
    private Double newSantaBudget;

    @JsonProperty(Constants.NEW_GIFTS)
    private List<GiftInput> newGifts;

    @JsonProperty(Constants.NEW_CHILDREN)
    private List<ChildInput> newChildren;

    @JsonProperty(Constants.CHILDREN_UPDATES)
    private List<ChildUpdateInput> childrenUpdates;

    public AnnualUpdateInput() { }

    public final Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public final void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public final List<GiftInput> getNewGifts() {
        return newGifts;
    }

    public final void setNewGifts(final List<GiftInput> newGifts) {
        this.newGifts = newGifts;
    }

    public final List<ChildInput> getNewChildren() {
        return newChildren;
    }

    public final void setNewChildren(final List<ChildInput> newChildren) {
        this.newChildren = newChildren;
    }

    public final List<ChildUpdateInput> getChildrenUpdates() {
        return childrenUpdates;
    }

    public final void setChildrenUpdates(final List<ChildUpdateInput> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
