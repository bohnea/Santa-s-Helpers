package io;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class InitialDataInput {
    @JsonProperty(Constants.CHILDREN)
    private @Getter @Setter List<ChildInput> childInput;

    @JsonProperty(Constants.SANTA_GIFTS_LIST)
    private @Getter @Setter List<GiftInput> giftInput;

    public InitialDataInput() { }
}