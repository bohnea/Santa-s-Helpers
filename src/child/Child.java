package child;

import database.DatabaseTrackable;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public abstract class Child implements DatabaseTrackable {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private ArrayList<Double> niceScores;
    private ArrayList<Category> giftsPreference;

    public Child(final int id, final String lastName, final String firstName, final int age,
                 final Cities city, final List<Double> niceScores,
                 final List<Category> giftsPreference) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScores = new ArrayList<>(niceScores);
        this.giftsPreference = new ArrayList<>(giftsPreference);
    }

    public abstract Double getAverageScore();

    @Override
    public final String getKey() {
        return String.valueOf(id);
    }
}
