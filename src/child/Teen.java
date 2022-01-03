package child;

import enums.Category;
import enums.Cities;

import java.util.List;

public class Teen extends Child {
    public Teen(final int id, final String lastName, final String firstName, final int age,
                final Cities city, final List<Double> niceScores,
                final List<Category> giftsPreference) {
        super(id, lastName, firstName, age, city, niceScores, giftsPreference);
    }

    @Override
    public Double getAverageScore() {
        return null;
    }
}
