import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSpec {
    private String name = "";
    private String description = "";
    private Integer ageRestrictions = 0;
    private List<Genre> genres = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();

    public GameSpec(String name, String description, Integer ageRestrictions, Genre[] genres, Language[] languages) {
        if (name != null) {
            this.name = name;
        }
        if (description != null) {
            this.description = description;
        }
        if (ageRestrictions != null) {
            this.ageRestrictions = ageRestrictions;
        }
        if (genres != null) {
            this.genres = Arrays.asList(genres);
        }
        if (languages != null) {
            this.languages = Arrays.asList(languages);
        }
    }

    public boolean matches(GameSpec spec) {
        if (spec.getName() != null && !name.toLowerCase().contains(spec.getName().toLowerCase())) {
            return false;
        }
        if (spec.getDescription() != null &&
                !description.toLowerCase().contains(spec.getDescription().toLowerCase())) {
            return false;
        }
        if (spec.getAgeRestrictions() != null && spec.getAgeRestrictions() < ageRestrictions) {
            return false;
        }
        if (spec.getGenres() != null && !spec.getGenres().isEmpty()) {
            for (Genre genre : spec.getGenres()) {
                if (!genres.contains(genre)) {
                    return false;
                }
            }
        }
        if (spec.getLanguages() != null && !spec.getLanguages().isEmpty()) {
            for (Language language : spec.getLanguages()) {
                if (!languages.contains(language)) {
                    return false;
                }
            }

        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAgeRestrictions() {
        return ageRestrictions;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<Language> getLanguages() {
        return languages;
    }
}
