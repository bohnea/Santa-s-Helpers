package io.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Output {
    @JsonProperty(Constants.ANNUAL_CHILDREN)
    private @Getter @Setter List<AnnualOutput> annualChildrenOutput;

    public Output() { }

    public Output(final List<AnnualOutput> annualChildrenOutput) {
        this.annualChildrenOutput = annualChildrenOutput;
    }
}
