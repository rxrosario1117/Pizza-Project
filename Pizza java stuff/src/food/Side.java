package food;

import management.Menu;

public class Side {
    String sideSelection;
    private float price = 0;
    private float wings = 1.00f;
//    private float breadSticks = 1.50f;
//    private float garlicKnots = 2.00f;
//    private float bonelessWings = 2.50f;

    //    Sets the side type and the price
    public Side(String sideSelection){
        if(sideSelection.equalsIgnoreCase("wings")){
            this.sideSelection = sideSelection;
            price = Menu.getWings();
        }
        else if(sideSelection.equalsIgnoreCase("breadSticks")){
            this.sideSelection = sideSelection;
            price = Menu.getBreadSticks();
        }
        else if(sideSelection.equalsIgnoreCase("garlicKnots")){
            this.sideSelection = sideSelection;
            price = Menu.getGarlicKnots();
        }
        else if(sideSelection.equalsIgnoreCase("bonelessWings")){
            this.sideSelection = sideSelection;
            price = Menu.getBonelessWings();
        }
    }

    public String getSideSelection() {
        return sideSelection;
    }

    public void setSideSelection(String sideSelection) {
        this.sideSelection = sideSelection;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWings() {
        return wings;
    }

    public void setWings(float wings) {
        this.wings = wings;
    }

//    public float getBreadSticks() {
//        return breadSticks;
//    }
//
//    public void setBreadSticks(float breadSticks) {
//        this.breadSticks = breadSticks;
//    }
//
//    public float getGarlicKnots() {
//        return garlicKnots;
//    }
//
//    public void setGarlicKnots(float garlicKnots) {
//        this.garlicKnots = garlicKnots;
//    }
//
//    public float getBonelessWings() {
//        return bonelessWings;
//    }
//
//    public void setBonelessWings(float bonelessWings) {
//        this.bonelessWings = bonelessWings;
//    }
}
