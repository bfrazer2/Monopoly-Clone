public class PropertySpace extends BoardSpace {

    private int price;
    private String owner;

    public PropertySpace() {

    }

<<<<<<< Updated upstream
    public PropertySpace(String name, String type, int price, int mortgageValue, int unMortgageValue, String owner) {
=======
    public PropertySpace(String name, String type, int price, String owner, boolean mortgaged) {
>>>>>>> Stashed changes
        super(name, type);
        this.price = price;
        this.owner = owner;
    }
<<<<<<< Updated upstream
}
=======

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged() {
        this.mortgaged = true;
    }

    public void setUnMortgaged() {
        this.mortgaged = false;
    }

    public int getPrice() {
        return price;
    }
}
>>>>>>> Stashed changes
