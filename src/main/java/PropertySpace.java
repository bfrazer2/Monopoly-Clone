public class PropertySpace extends main.java.BoardSpace {

    private int price;
    private String owner;
    private boolean mortgaged;

    public PropertySpace() {

    }

    public PropertySpace(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type);
        this.price = price;
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
}