public class Rail extends PropertySpace {
    public Rail(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
    }
    public int calculateRent(Player player) {
        int numRails = player.countRails();
        int rent = numRails*25;
        return rent;
    }
}
