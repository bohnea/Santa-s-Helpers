package io.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.input.update.AnnualUpdateInput;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Input {
    @JsonProperty(Constants.NUMBER_OF_YEARS)
    private @Getter @Setter Integer numberOfYears;

    @JsonProperty(Constants.SANTA_BUDGET)
    private @Getter @Setter Double santaBudget;

    @JsonProperty(Constants.INITIAL_DATA)
    private @Getter @Setter InitialDataInput initialDataInput;

    @JsonProperty(Constants.ANNUAL_CHANGES)
    private @Getter @Setter List<AnnualUpdateInput> annualUpdates;

    public Input() { }
}
