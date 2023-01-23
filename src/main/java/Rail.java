public class Rail extends PropertySpace {
    public Rail(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() +
                "\n\n" + "Price: " + super.getPrice() +
                "\n\n" + "Rent with 1 Rail: $25" +
                "\n" + "Rent with 2 Houses: $50" +
                "\n" + "Rent with 3 Houses: $100" +
                "\n" + "Rent with 4 Houses: $200"
                ;
    }
    public int calculateRent(Player player) {
        int numRails = player.countRails();
        int[] rentList = new int[] {25,50,100,200};
        int rent = rentList[numRails-1];
        return rent;
    }
}
