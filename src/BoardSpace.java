public class BoardSpace {

    private String name;
    private String type;
    private String owner;
    private int price;
    private int houseCost;
    private int mortgageValue;
    private int numHouses;
    private int[] rent;
    private boolean hasHotel;

    public BoardSpace(String name, String type, String owner, int price, int houseCost, int mortgageValue, int numHouses, int[] rent, boolean hasHotel) {
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.price = price;
        this.houseCost = houseCost;
        this.mortgageValue = mortgageValue;
        this.numHouses = numHouses;
        this.rent = rent;
        this.hasHotel = hasHotel;
    }

    private int calculateRent() {
        int rentToPay = rent[numHouses];
        return rentToPay;
    }



}
