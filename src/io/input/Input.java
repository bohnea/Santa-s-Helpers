package io.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.input.update.AnnualUpdateInput;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class Input {
    @JsonProperty(Constants.NUMBER_OF_YEARS)
    private Integer numberOfYears;

    @JsonProperty(Constants.SANTA_BUDGET)
    private Double santaBudget;

    @JsonProperty(Constants.INITIAL_DATA)
    private InitialDataInput initialDataInput;

    @JsonProperty(Constants.ANNUAL_CHANGES)
    private List<AnnualUpdateInput> annualUpdates;

    public Input() { }

    public final Integer getNumberOfYears() {
        return numberOfYears;
    }

    public final void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public final Double getSantaBudget() {
        return santaBudget;
    }

    public final void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public final InitialDataInput getInitialDataInput() {
        return initialDataInput;
    }

    public final void setInitialDataInput(final InitialDataInput initialDataInput) {
        this.initialDataInput = initialDataInput;
    }

    public final List<AnnualUpdateInput> getAnnualUpdates() {
        return annualUpdates;
    }

    public final void setAnnualUpdates(final List<AnnualUpdateInput> annualUpdates) {
        this.annualUpdates = annualUpdates;
    }
}
