import main.java.BoardSpace;

import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private ArrayList<main.java.BoardSpace> ownedProps;
    private int playerMoney;
    private int utilsOwned;
    private int railsOwned;
    private int currentSpace;
    private boolean inJail;


    public Player(String name) {
        this(name, new ArrayList<>(), 1500, 0, 0, 0, false);
    }

    public Player(String name, ArrayList<main.java.BoardSpace> ownedProps, int playerMoney, int utilsOwned, int railsOwned, int currentSpace, boolean inJail) {
        this.name = name;
        this.ownedProps = ownedProps;
        this.playerMoney = playerMoney;
        this.utilsOwned = utilsOwned;
        this.railsOwned = railsOwned;
        this.currentSpace = currentSpace;
        this.inJail = inJail;
    }

    public String getName() {
        return name;
    }

    public List<main.java.BoardSpace> getOwnedProps() {
        return ownedProps;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public int getCurrentSpace() {
        return currentSpace;
    }

    public void setOwnedProps(ArrayList<main.java.BoardSpace> ownedProps) {
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
        int roll = (int)(Math.random() * (max - min + 1)) + min;
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
        main.java.BoardSpace propToBuy = (board.getSpaceDetails(mySpace));
        String type = propToBuy.getType();
        if (type == "House" || type == "Rail" || type == "Utility") {
            PropertySpace prop = (PropertySpace) (propToBuy);
            if (prop.getOwner()=="") {
                if (this.playerMoney - prop.getPrice() >= 0) {
                    System.out.println(this.name + " has " + this.playerMoney + " dollars before property purchase.");
                    this.playerMoney -= prop.getPrice();
                    System.out.println(this.name + " has " + this.playerMoney + " dollars after property purchase.");
                    prop.setOwner(this.name);
                    this.ownedProps.add(prop);
                    System.out.println("" + prop.getName() + " is now owned by " + prop.getOwner() + ".");
                } else {
                    System.out.println("Insufficient funds to buy this property!");
                }
            } else {
                System.out.println("Can't buy this property, it's already owned by " + prop.getOwner() + "!");
            }
        }
    }

    public boolean payRent(int rent) {
        if (this.playerMoney < rent) {
            return false;
        } else {
            this.playerMoney -= rent;
            System.out.println("You paid $" + rent + " in rent. You now have $ " + this.playerMoney + " remaining.");
            return true;
        }
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
        for (main.java.BoardSpace property : ownedProps) {
            if (property instanceof Utility) {
                utilCount ++;
            }
        }
        return utilCount;
    }

    public int countRails() {
        int railCount = 0;
        for (main.java.BoardSpace property : ownedProps) {
            if (property instanceof Rail) {
                railCount ++;
            }
        }
        return railCount;
    }

    public boolean hasMonopoly(String color) {
        List<House> ownedHouses = new ArrayList<>();
        for (main.java.BoardSpace property : ownedProps) {
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

    public List<House> meetsBuildCondition(String color) {
        List<House> ownedHouses = new ArrayList<>();
        List<House> validBuildHouses = new ArrayList<>();

        for (main.java.BoardSpace property : ownedProps) {
            if (property instanceof House) {
                House house = (House) property;
                ownedHouses.add(house);
            }
        }

        // filter the list of houses to include only those with the specified color
        List<House> filteredHouses = ownedHouses.stream()
                .filter(h -> h.getColor().equals(color))
                .collect(Collectors.toList());

        // extract the numHouses values from the filtered list of houses
        List<Integer> filteredNumHouses = filteredHouses.stream()
                .map(House::getNumHouses)
                .collect(Collectors.toList());

        int count = -1;
        for (int i : filteredNumHouses) {
            count ++;
            int selfCount = 0;
            for (int x : filteredNumHouses) {
                if (i == x && selfCount==0) {
                    selfCount +=1;
                } else {
                    if (i + 1 - x <= 1 && !validBuildHouses.contains(filteredHouses.get(count))) {
                        validBuildHouses.add(filteredHouses.get(count));
                    }
                }
            }
        }
        return validBuildHouses;
    }
    public boolean resolveBroke (int rent) {
        //GG Check
        int totalAssets = this.playerMoney;
        for (BoardSpace space : ownedProps) {
            PropertySpace prop = (PropertySpace) space;
            totalAssets += (prop.getPrice()/2);
            if (prop.getType() == "House") {
                House house = (House) prop;
                if (house.getNumHouses()>0) {
                    totalAssets += (house.getNumHouses() * (house.getHouseCost()/2));
                }
            }
        }
        if (totalAssets < rent) {
            return false;
        }

        Boolean stillBroke = true;
        Boolean mortgagingProperties = false;
        Boolean sellingHouses = false;

        System.out.println("You don't have enough money to cover your rent!");
        System.out.println("You must mortgage properties or sell houses to cover your rent.");
        System.out.println("You have the following properties which can be mortgaged for the displayed value:\n");

        for (main.java.BoardSpace space : this.ownedProps) {
            PropertySpace prop = (PropertySpace) space;
            if (!prop.isMortgaged()) {
                int mortgageValue = (prop.getPrice()) / 2;
                System.out.println(prop.getName() + ": $" + mortgageValue);
            }
            if (prop.getType() == "House") {
                House house = (House) prop;
                int houseValue = house.getHouseCost() / 2;
                System.out.println("This property also has " + house.getNumHouses() + " houses, which can be sold for " + houseValue);
            }
        }
        while (stillBroke) {

            List<String> options = new ArrayList<>();
            options.add("1. Mortgage Properties");
            options.add("2. Sell Houses");
            OptionHandler mortgageOrSellQuery = new OptionHandler("What would you like to do now?", options);
            int mortgageOrSell = mortgageOrSellQuery.handleOptions();
            options.clear();

            if (mortgageOrSell == 1) {
                mortgagingProperties = true;

                while (mortgagingProperties) {
                    int propCount = 0;
                    for (main.java.BoardSpace space : this.ownedProps) {
                        PropertySpace prop = (PropertySpace) space;
                        List<Integer> mortgageablePropsIndex = new ArrayList<>();

                        if (!prop.isMortgaged()) {
                            mortgageablePropsIndex.add(this.ownedProps.indexOf(prop));
                            int mortgageValue = (prop.getPrice()) / 2;
                            options.add(propCount + ". " + prop.getName() + ": $" + mortgageValue);
                        }

                        OptionHandler whatToMortgageQuery = new OptionHandler("Which property would you like to mortgage?", options);
                        int whatToMortgage = whatToMortgageQuery.handleOptions();
                        options.clear();

                        this.mortgageProperty(whatToMortgage);

                        //Check for stillBroke
                        if (this.playerMoney < rent) {
                            options.add("1. Mortgage more properties.");
                            options.add("2. Switch to selling houses.");
                            OptionHandler moreMortgageQuery = new OptionHandler("You still don't have enough to cover rent. Would you like to mortgage more properties, or switch to selling houses?", options);
                            mortgageOrSell = moreMortgageQuery.handleOptions();
                            options.clear();

                            if (mortgageOrSell == 1) {
                                continue;
                            } else {
                                mortgagingProperties = false;
                            }
                        } else {
                            System.out.println("You covered rent! Phew!");
                            stillBroke=false;
                            mortgagingProperties=false;
                        }
                    }
                }
            } else if (mortgageOrSell == 2) {
                sellingHouses = true;

                for (main.java.BoardSpace space : this.ownedProps) {
                    PropertySpace prop = (PropertySpace) space;
                    List<Integer> sellableHousesIndex = new ArrayList<>();
                    int propCount = 0;
                    if (prop.getType() == "House") {
                        House house = (House) prop;
                        if (house.getNumHouses() > 0) {
                            sellableHousesIndex.add(this.ownedProps.indexOf(prop));
                            int sellValue = (house.getHouseCost()) / 2;
                            options.add(propCount + ". " + prop.getName() + ": $" + sellValue);
                        }

                        OptionHandler whatToSellQuery = new OptionHandler("Which property would you like to sell a house from?", options);
                        int whatToSell = whatToSellQuery.handleOptions();
                        options.clear();

                        this.sellHouse(whatToSell);
                    }
                }
                if (playerMoney < rent) {
                    System.out.println("You still don't have enough to cover rent!");
                } else {
                    System.out.println("You covered rent! Phew!");
                    sellingHouses=false;
                    stillBroke=false;
                }
            }
        }
        return true;
    }
}
