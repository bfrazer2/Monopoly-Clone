public class Utility extends PropertySpace {
    public Utility(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
    }

    public int calculateRent(Player player, int diceRoll) {
        int numUtilities = player.countUtilities();
        int rent;
        if (numUtilities == 1) {
            rent = 4 * diceRoll;
        } else {
            rent = 10 * diceRoll;
        }
        return rent;
    }
}
