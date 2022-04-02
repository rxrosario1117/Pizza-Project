public class Side {

    Boolean wings;
    Boolean breadsticks;
    Boolean garlicKnots;
    Boolean bonelessWings;

//    side constructor and getters and setters
    public Side(Boolean wings, Boolean breadsticks, Boolean garlicKnots, Boolean bonelessWings) {
        this.wings = wings;
        this.breadsticks = breadsticks;
        this.garlicKnots = garlicKnots;
        this.bonelessWings = bonelessWings;
    }

    public Boolean getWings() {
        return wings;
    }

    public void setWings(Boolean wings) {
        this.wings = wings;
    }

    public Boolean getBreadsticks() {
        return breadsticks;
    }

    public void setBreadsticks(Boolean breadsticks) {
        this.breadsticks = breadsticks;
    }

    public Boolean getGarlicKnots() {
        return garlicKnots;
    }

    public void setGarlicKnots(Boolean garlicKnots) {
        this.garlicKnots = garlicKnots;
    }

    public Boolean getBonelessWings() {
        return bonelessWings;
    }

    public void setBonelessWings(Boolean bonelessWings) {
        this.bonelessWings = bonelessWings;
    }
}
