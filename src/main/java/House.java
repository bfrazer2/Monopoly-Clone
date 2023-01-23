import java.util.Arrays;

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

    @Override
    public String toString() {
        return "Name: " + super.getName() +
                "\n" + this.getColor() +
                "\n\n" + "Price: " + super.getPrice() +
                "\n\n" + "Rent with 0 Houses: $" + this.rent[0] +
                "\n" + "Rent with 1 House: $" + this.rent[1] +
                "\n" + "Rent with 2 Houses: $" + this.rent[2] +
                "\n" + "Rent with 3 Houses: $" + this.rent[3] +
                "\n" + "Rent with 4 Houses: $" + this.rent[4] +
                "\n" + "Rent with Hotel: $" + this.rent[5]
                ;
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

    public int calculateRent() {
            int rentToPay = rent[this.numHouses];
            return rentToPay;
    }



}
