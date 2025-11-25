import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return languages.size() == 0;
    }

    public void addLanguage(String language) {
        if (!containsLanguage(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        languages.remove(language);
    }

    public String firstLanguage() {
        if (languages.isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty — no index available");
        } else {
            return languages.get(0);
        }
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.stream().anyMatch(lang -> lang.equals(language));
    }

    public boolean isExciting() {
        return containsLanguage("Java") || containsLanguage("Kotlin");
    }
}
