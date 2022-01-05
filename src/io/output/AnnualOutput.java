package io.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.output.child.ChildOutput;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class AnnualOutput {
    @JsonProperty(Constants.CHILDREN)
    private @Getter @Setter List<ChildOutput> children;

    public AnnualOutput() { }

    public AnnualOutput(final List<ChildOutput> children) {
        this.children = children;
    }
}
