public class House extends PropertySpace {

    private String color;
    private int houseCost;
    private int numHouses;
    private int[] rent;
    private boolean hasHotel;

    public House(String name, String type, int price, String owner, boolean mortgaged, String color, int houseCost, int numHouses, int[] rent, boolean hasHotel) {
        super(name, type, price, owner, mortgaged);
        this.color = color;
        this.houseCost = houseCost;
        this.numHouses = numHouses;
        this.rent = rent;
        this.hasHotel = hasHotel;
    }

    public String getColor() {
        return color;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }

    public int getHouseCost() {
        return houseCost;
    }

    private int calculateRent() {
        int rentToPay = rent[numHouses];
        return rentToPay;
    }



}
