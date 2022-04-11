package food;

public class Drink {
    String drinkType;
    String size;
    private float price = 0;
    private float smallPrice = 1.00f;
    private float mediumPrice = 1.50f;
    private float largePrice = 2.00f;

    //    Sets the drink type, size, and the price
    public Drink(String drinkType, String size){
        if(drinkType.equalsIgnoreCase("coke")){
            this.drinkType = drinkType;
        }
        else if(drinkType.equalsIgnoreCase("diet coke")){
            this.drinkType = drinkType;
        }
        else if(drinkType.equalsIgnoreCase("mountain dew")){
            this.drinkType = drinkType;
        }
        else if(drinkType.equalsIgnoreCase("sprite")){
            this.drinkType = drinkType;
        }

        if(size.equalsIgnoreCase("small")){
            this.size = size;
            price = smallPrice;

        }
        else if(size.equalsIgnoreCase("medium")){
            this.size = size;
            price = mediumPrice;
        }
        else if(size.equalsIgnoreCase("large")){
            this.size = size;
            price = largePrice;
        }
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(float smallPrice) {
        this.smallPrice = smallPrice;
    }

    public float getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(float mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public float getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(float largePrice) {
        this.largePrice = largePrice;
    }
}
