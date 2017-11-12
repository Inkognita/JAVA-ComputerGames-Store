public enum Genre {
    ACTION, ACTION_ADVENTURE, ADVENTURE, ROLE_PLAYING,
    SIMULATION, STRATEGY, SPORTS;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
