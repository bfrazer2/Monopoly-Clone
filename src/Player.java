import java.util.*;

public class Player {
    private String name;
    private ArrayList<BoardSpace> ownedProps;
    private int playerMoney;
    private int utilsOwned;
    private int railsOwned;
    private int currentSpace;
    private boolean inJail;

    public Player(String name, ArrayList<BoardSpace> ownedProps, int playerMoney, int utilsOwned, int railsOwned, int currentSpace, boolean inJail) {
        this.name = name;
        this.ownedProps = ownedProps;
        this.playerMoney = playerMoney;
        this.utilsOwned = utilsOwned;
        this.railsOwned = railsOwned;
        this.currentSpace = currentSpace;
        this.inJail = inJail;
    }

    public List<BoardSpace> getOwnedProps() {
        return ownedProps;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public int getCurrentSpace() {
        return currentSpace;
    }

    public void setOwnedProps(ArrayList<BoardSpace> ownedProps) {
        this.ownedProps = ownedProps;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public void setUtilsOwned(int utilsOwned) {
        this.utilsOwned = utilsOwned;
    }

    public void setRailsOwned(int railsOwned) {
        this.railsOwned = railsOwned;
    }

    public void setCurrentSpace(int currentSpace) {
        this.currentSpace = currentSpace;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int rollDice() {
        int min = 1;
        int max = 6;
        int roll1 = (int)(Math.random() * (max - min + 1)) + min;
        int roll2 = (int)(Math.random() * (max - min + 1)) + min;
        int roll = roll1+roll2;
        return roll;
    }

    public int move(int roll) {
        if ((this.currentSpace+roll)<=39) {
            return this.currentSpace += roll;
        }
        else{
            this.currentSpace = ((this.currentSpace+roll)-40);
            return this.currentSpace;
        }
    }

    public void buyProperty(Board board) {
        int mySpace = this.currentSpace;
        BoardSpace prop = (board.getSpaceDetails(mySpace));
        this.ownedProps.add(prop);
    }

    public void payRent(int rent) {
        this.playerMoney -= rent;
    }

    public void mortgageProperty(int playerProp) {
        PropertySpace propToMortgage = (PropertySpace) (this.ownedProps.get(playerProp));
        propToMortgage.setMortgaged();
        System.out.println(propToMortgage.isMortgaged());
        System.out.println("Player has " + this.playerMoney + " dollars before mortgage.");
        this.playerMoney += propToMortgage.getMortgageValue();
        System.out.println("Player has " + this.playerMoney + " dollars after mortgage.");
    }

    public void unMortgageProperty(int playerProp) {
        PropertySpace propToMortgage = (PropertySpace) (this.ownedProps.get(playerProp));
        propToMortgage.setUnMortgaged();
        System.out.println(propToMortgage.isMortgaged());
        System.out.println("Player has " + this.playerMoney + " dollars before re-buy.");
        this.playerMoney -= propToMortgage.getUnMortgageValue();
        System.out.println("Player has " + this.playerMoney + " dollars after re-buy.");
    }



}
