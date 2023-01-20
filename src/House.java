public class House extends PropertySpace {

    private String color;
    private int houseCost;
    private int numHouses;
    private int[] rent;
    private boolean hasHotel;

    public House(String name, String type, int price, int mortgageValue, int unMortgageValue, String owner, boolean mortgaged, String color, int houseCost, int numHouses, int[] rent, boolean hasHotel) {
        super(name, type, price, mortgageValue, unMortgageValue, owner, mortgaged);
        this.color = color;
        this.houseCost = houseCost;
        this.numHouses = numHouses;
        this.rent = rent;
        this.hasHotel = hasHotel;
    }

    public String getColor() {
        return color;
    }

    private int calculateRent() {
        int rentToPay = rent[numHouses];
        return rentToPay;
    }



}
