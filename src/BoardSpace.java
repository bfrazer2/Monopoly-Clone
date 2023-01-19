public class BoardSpace {

    public String name;
    public String type;
    public String owner;
    public int price;
    private int houseCost;
    public int mortgageValue;
    private int numHouses;
    public int[] rent;
    public boolean hasHotel;

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
