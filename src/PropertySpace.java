public class PropertySpace extends BoardSpace {

    private int price;
    private int mortgageValue;
    private int unMortgageValue;
    private String owner;

    public PropertySpace() {

    }

    public PropertySpace(String name, String type, int price, int mortgageValue, int unMortgageValue, String owner) {
        super(name, type);
        this.price = price;
        this.mortgageValue = mortgageValue;
        this.unMortgageValue = unMortgageValue;
        this.owner = owner;
    }
}
