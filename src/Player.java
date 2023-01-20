import java.util.*;

public class Player {

    private List<PropertySpace> ownedProps;
    private int playerMoney;
    private int utilsOwned;
    private int railsOwned;
    private boolean inJail;

    public Player(List<PropertySpace> ownedProps, int playerMoney, int utilsOwned, int railsOwned, boolean inJail) {
        this.ownedProps = ownedProps;
        this.playerMoney = playerMoney;
        this.utilsOwned = utilsOwned;
        this.railsOwned = railsOwned;
        this.inJail = inJail;
    }

    public List<PropertySpace> getOwnedProps() {
        return ownedProps;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setOwnedProps(List<PropertySpace> ownedProps) {
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
}
