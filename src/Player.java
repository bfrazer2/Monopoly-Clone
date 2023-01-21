import java.util.*;
import java.util.stream.Collectors;

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
        BoardSpace propToBuy = (board.getSpaceDetails(mySpace));
        String type = propToBuy.getType();
        if (type == "House" || type == "Rail" || type == "Utility") {
            PropertySpace prop = (PropertySpace) (propToBuy);
            if (prop.getOwner()=="") {
                if (this.playerMoney - prop.getPrice() >= 0) {
                    System.out.println("Player has " + this.playerMoney + " dollars before property purchase.");
                    this.playerMoney -= prop.getPrice();
                    System.out.println("Player has " + this.playerMoney + " dollars after property purchase.");
                    prop.setOwner(this.name);
                    this.ownedProps.add(prop);
                    System.out.println("" + prop.getName() + " is now owned by " + prop.getOwner() + ".");
                } else {
                    System.out.println("Insufficient funds to buy this property!");
                }
            } else {
                System.out.println("Can't buy this property, it's already owned by " + prop.getOwner());
            }
        }
    }

    public void payRent(int rent) {
        this.playerMoney -= rent;
    }

    public void mortgageProperty(int playerProp) {
        PropertySpace propToMortgage = (PropertySpace) (this.ownedProps.get(playerProp));
        propToMortgage.setMortgaged();
        System.out.println(propToMortgage.isMortgaged());
        System.out.println("Player has " + this.playerMoney + " dollars before mortgage.");
        this.playerMoney += ((propToMortgage.getPrice())/2);
        System.out.println("Player has " + this.playerMoney + " dollars after mortgage.");
    }

    public void unMortgageProperty(int playerProp) {
        PropertySpace propToMortgage = (PropertySpace) (this.ownedProps.get(playerProp));
        propToMortgage.setUnMortgaged();
        System.out.println(propToMortgage.isMortgaged());
        System.out.println("Player has " + this.playerMoney + " dollars before re-buy.");
        this.playerMoney -= (Math.round((propToMortgage.getPrice())*.55));
        System.out.println("Player has " + this.playerMoney + " dollars after re-buy.");
    }

    public void buyHouse(int playerProp) {
        PropertySpace propToBuildOn = (PropertySpace) (this.ownedProps.get(playerProp));
        String type = propToBuildOn.getType();
        if (type == "House") {

            House prop = (House) (propToBuildOn);
            String color = prop.getColor();

            if (this.hasMonopoly(color)) {
                if (this.playerMoney - prop.getHouseCost() >= 0) {
                    System.out.println("Player has " + this.playerMoney + " dollars before house purchase.");
                    this.playerMoney -= prop.getHouseCost();
                    System.out.println("Player has " + this.playerMoney + " dollars after house purchase.");
                    int currentHouses = prop.getNumHouses();
                    System.out.println("Property has " + prop.getNumHouses() + " houses before purchase.");
                    int newHousesNum = currentHouses + 1;
                    prop.setNumHouses(newHousesNum);
                    System.out.println("Property has " + prop.getNumHouses() + " houses after purchase.");
                } else {
                    System.out.println("Insufficient funds to buy house for this property!");
                }
            } else {
                System.out.println("Cannot buy house because player doesn't have monopoly!");
            }
        }
    }

    public void sellHouse(int playerProp) {
        PropertySpace propToBuildOn = (PropertySpace) (this.ownedProps.get(playerProp));
        String type = propToBuildOn.getType();
        if(type == "House") {
            House prop = (House) (propToBuildOn);
            if (prop.getNumHouses() > 0) {
                System.out.println("Player has " + this.playerMoney + " dollars before house sale.");
                this.playerMoney += ((prop.getHouseCost())/2);
                System.out.println("Player has " + this.playerMoney + " dollars after house sale.");
                int currentHouses = prop.getNumHouses();
                System.out.println("Property has " + prop.getNumHouses() + " houses before sale.");
                int newHousesNum = currentHouses - 1;
                prop.setNumHouses(newHousesNum);
                System.out.println("Property has " + prop.getNumHouses() + " houses after sale.");
            } else {
                System.out.println("No houses to sell on this property!");
            }
        }
    }

    public int countUtilities() {
        int utilCount = 0;
        for (BoardSpace property : ownedProps) {
            if (property instanceof Utility) {
                utilCount ++;
            }
        }
        return utilCount;
    }

    public int countRails() {
        int railCount = 0;
        for (BoardSpace property : ownedProps) {
            if (property instanceof Rail) {
                railCount ++;
            }
        }
        return railCount;
    }

    public boolean hasMonopoly(String color) {
        List<House> ownedHouses = new ArrayList<>();
        for (BoardSpace property : ownedProps) {
            if (property instanceof House) {
                House house = (House) property;
                ownedHouses.add(house);
            }
        }
        Map<String, Long> colorCount = ownedHouses.stream()
                .collect(Collectors.groupingBy(House::getColor, Collectors.counting()));
        if ((color == "Dark Blue" && colorCount.get("Dark Blue") == 2) || (color == "Brown" && colorCount.get("Brown") == 2) || colorCount.get(color) == 3) {
            return true;
        } else return false;
    }



}
