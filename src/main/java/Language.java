public enum Language {
    UKRAINIAN, ENGLISH, RUSSIAN, POLAND, CHINESE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
