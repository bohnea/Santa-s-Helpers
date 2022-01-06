package io.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import io.output.child.ChildOutput;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class AnnualOutput {
    @JsonProperty(Constants.CHILDREN)
    private List<ChildOutput> children;

    public AnnualOutput(final List<ChildOutput> children) {
        this.children = children;
    }

    public final List<ChildOutput> getChildren() {
        return children;
    }

    public final void setChildren(final List<ChildOutput> children) {
        this.children = children;
    }
}
