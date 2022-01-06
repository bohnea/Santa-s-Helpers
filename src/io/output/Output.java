package io.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class Output {
    @JsonProperty(Constants.ANNUAL_CHILDREN)
    private List<AnnualOutput> annualChildrenOutput;

    public Output(final List<AnnualOutput> annualChildrenOutput) {
        this.annualChildrenOutput = annualChildrenOutput;
    }

    public final List<AnnualOutput> getAnnualChildrenOutput() {
        return annualChildrenOutput;
    }

    public final void setAnnualChildrenOutput(final List<AnnualOutput> annualChildrenOutput) {
        this.annualChildrenOutput = annualChildrenOutput;
    }
}
