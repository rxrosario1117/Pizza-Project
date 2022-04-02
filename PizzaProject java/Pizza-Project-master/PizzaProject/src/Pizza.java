
import java.util.List;

public class Pizza {

    String size;
    int quantity;
    List<String> toppings;
    SpecialtyPizzas specialtyPizzas;

//    pizza constructor and getters and setters
    public Pizza(String size, int quantity, List<String> toppings) {
        this.size = size;
        this.quantity = quantity;
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public SpecialtyPizzas getSpecialtyPizzas() {
        return specialtyPizzas;
    }

    public void setSpecialtyPizzas(SpecialtyPizzas specialtyPizzas) {
        this.specialtyPizzas = specialtyPizzas;
    }

//    nested class for Specialty Pizzas w/ constructor, getters, and setters
    public static class SpecialtyPizzas{
        // pizza types
        Boolean sausage;
        Boolean pepperoni;
        Boolean Cheese;
        Boolean Marinara;
        Boolean Supreme;
        Boolean Veggie;
        String size;

        public SpecialtyPizzas(Boolean sausage, Boolean pepperoni, Boolean cheese, Boolean marinara, Boolean supreme, Boolean veggie, String size) {
            this.sausage = sausage;
            this.pepperoni = pepperoni;
            Cheese = cheese;
            Marinara = marinara;
            Supreme = supreme;
            Veggie = veggie;
            this.size = size;
        }

        public Boolean getSausage() {
            return sausage;
        }

        public void setSausage(Boolean sausage) {
            this.sausage = sausage;
        }

        public Boolean getPepperoni() {
            return pepperoni;
        }

        public void setPepperoni(Boolean pepperoni) {
            this.pepperoni = pepperoni;
        }

        public Boolean getCheese() {
            return Cheese;
        }

        public void setCheese(Boolean cheese) {
            Cheese = cheese;
        }

        public Boolean getMarinara() {
            return Marinara;
        }

        public void setMarinara(Boolean marinara) {
            Marinara = marinara;
        }

        public Boolean getSupreme() {
            return Supreme;
        }

        public void setSupreme(Boolean supreme) {
            Supreme = supreme;
        }

        public Boolean getVeggie() {
            return Veggie;
        }

        public void setVeggie(Boolean veggie) {
            Veggie = veggie;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }
    }

//    nested class for Build Your Own w/ constructor, getters, and setters
    public static class BuildYourOwn {
        String crust;
        char sauce;
        char cheese;
        List<String> toppings;

        public BuildYourOwn(String crust, char sauce, char cheese, List<String> toppings) {
            this.crust = crust;
            this.sauce = sauce;
            this.cheese = cheese;
            this.toppings = toppings;
        }

        public String getCrust() {
            return crust;
        }

        public void setCrust(String crust) {
            this.crust = crust;
        }

        public char getSauce() {
            return sauce;
        }

        public void setSauce(char sauce) {
            this.sauce = sauce;
        }

        public char getCheese() {
            return cheese;
        }

        public void setCheese(char cheese) {
            this.cheese = cheese;
        }

        public List<String> getToppings() {
            return toppings;
        }

        public void setToppings(List<String> toppings) {
            this.toppings = toppings;
        }
    }
}
