public class Utility extends PropertySpace {
    public Utility(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
    }
    public String toString() {
        return "Name: " + super.getName() +
                "\n\n" + "Price: " + super.getPrice() +
                "\n\n" + "Rent with 1 Util Owned: 4*Dice Roll" +
                "\n" + "Rent with 2 Utils Owned: 10*Dice Roll"
                ;
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
