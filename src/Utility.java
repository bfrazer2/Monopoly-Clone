public class Utility extends PropertySpace {
<<<<<<< Updated upstream

    public Utility(String name, String type, int price, int mortgageValue, int unMortgageValue, String owner) {
        super(name, type, price, mortgageValue, unMortgageValue, owner);
=======
    public Utility(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type, price, owner, mortgaged);
>>>>>>> Stashed changes
    }

//    private int calculateRent() {
//        //Need to get #owned from owner
//    }
}
