public class Utility extends PropertySpace {
    public Utility(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
    }

    private int calculateRent(Player player, int diceRoll) {
        int numUtilities = player.countUtilities();
        int rent = numUtilities*diceRoll;
        return rent;
    }
}
