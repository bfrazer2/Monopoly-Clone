public class PropertySpace extends BoardSpace {

    private int price;
    private int mortgageValue;
    private int unMortgageValue;
    private String owner;
    private boolean mortgaged;

    public PropertySpace() {

    }

    public PropertySpace(String name, String type, int price, int mortgageValue, int unMortgageValue, String owner, boolean mortgaged) {
        super(name, type);
        this.price = price;
        this.mortgageValue = mortgageValue;
        this.unMortgageValue = unMortgageValue;
        this.owner = owner;
        this.mortgaged = mortgaged;
    }

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

    public int getMortgageValue() {
        return mortgageValue;
    }

    public int getUnMortgageValue() {
        return unMortgageValue;
    }
}