package enums;

import child.Child;
import com.fasterxml.jackson.annotation.JsonProperty;
import database.managers.search.SearchManager;

import java.util.List;

public enum Cities {
    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @JsonProperty("Cluj-Napoca")
    CLUJ("Cluj-Napoca"),

    @JsonProperty("Iasi")
    IASI("Iasi"),

    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @JsonProperty("Braila")
    BRAILA("Braila"),

    @JsonProperty("Oradea")
    ORADEA("Oradea");

    private String value;

    public String getValue() {
        return value;
    }

    public Double getAverageRating() {
        // Get the children from the current city
        List<Child> children = SearchManager.getChildrenByCity(this);

        // If the list is null, return 0
        if (children.isEmpty()) {
            return 0.0d;
        }

        // Get the sum of the average scores of each child
        double sum = 0.0d;
        for (Child child: children) {
            sum += child.getAverageScore();
        }

        // Return the average score
        return sum / children.size();
    }

    Cities(final String value) {
        this.value = value;
    }
}
