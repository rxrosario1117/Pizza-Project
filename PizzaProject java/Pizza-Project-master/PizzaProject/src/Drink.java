public class Drink {
    Boolean coke;
    Boolean dietCoke;
    Boolean mountainDew;
    Boolean sprite;
    String size;

//    drink constructor and getters and setters
    public Drink(Boolean coke, Boolean dietCoke, Boolean mountainDew, Boolean sprite, String size) {
        this.coke = coke;
        this.dietCoke = dietCoke;
        this.mountainDew = mountainDew;
        this.sprite = sprite;
        this.size = size;
    }

    public Boolean getCoke() {
        return coke;
    }

    public void setCoke(Boolean coke) {
        this.coke = coke;
    }

    public Boolean getDietCoke() {
        return dietCoke;
    }

    public void setDietCoke(Boolean dietCoke) {
        this.dietCoke = dietCoke;
    }

    public Boolean getMountainDew() {
        return mountainDew;
    }

    public void setMountainDew(Boolean mountainDew) {
        this.mountainDew = mountainDew;
    }

    public Boolean getSprite() {
        return sprite;
    }

    public void setSprite(Boolean sprite) {
        this.sprite = sprite;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
