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
        System.out.println(this.getName() + " now has $" + this.playerMoney + ".");
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
                    this.playerMoney -= prop.getPrice();
                    System.out.println(this.name + " has " + this.playerMoney + " dollars remaining.");
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
    public boolean resolveBroke (int rent, Scanner scanner) {
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

        System.out.println("You don't have enough money to cover your dues!");
        System.out.println("You must mortgage properties or sell houses to cover your dues.");
        System.out.println("You have the following properties which can be mortgaged for the displayed value:\n");

        for (main.java.BoardSpace space : this.ownedProps) {
            PropertySpace prop = (PropertySpace) space;
            if (!prop.isMortgaged()) {
                int mortgageValue = (prop.getPrice()) / 2;
                System.out.println(prop.getName() + ": $" + mortgageValue);
            }
            if (prop.getType() == "House") {
                House house = (House) prop;
                if (house.getNumHouses()>0) {
                    int houseValue = house.getHouseCost() / 2;
                    System.out.println("This property also has " + house.getNumHouses() + " houses, which can be sold for " + houseValue);
                }
            }
        }
        while (stillBroke) {

            //Set up Option Handler
            List<String> options = new ArrayList<>();
            options.add("1. Mortgage Property");
            options.add("2. Sell House");
            OptionHandler mortgageOrSellQuery = new OptionHandler("What would you like to do now?", options);
            int mortgageOrSell = mortgageOrSellQuery.handleOptions(scanner);
            options.clear();

            if (mortgageOrSell == 1) {

                //Allow player to choose which property to mortgage, then execute that mortgage.
                int whatToMortgage = this.chooseProperty("Mortgage Property", scanner);
                this.mortgageProperty(whatToMortgage);

                //Check for stillBroke
                if (this.playerMoney > rent) {
                    System.out.println("You covered rent! Phew!");
                    stillBroke=false;
                }


            } else if (mortgageOrSell == 2) {

                //Allow player to choose which house to sell, then execute that sale.
                int whatToSell = this.chooseProperty("Sell House", scanner);
                this.sellHouse(whatToSell);

                if (playerMoney < rent) {
                    System.out.println("You still don't have enough to cover rent!");
                } else {
                    System.out.println("You covered rent! Phew!");
                    stillBroke=false;
                }
            }
        }
        return true;
    }

    public int resolveBankruptcy(Player owedPlayer, Scanner scanner) {
        //Setup for OptionHandler
        List<String> options = new ArrayList<>();

        //Houses will be sold by default and houseAssets (representing the total sale value of those houses) will be added to the owedPlayers balance
        int houseAssets = 0;

        for (BoardSpace space : this.ownedProps) {
            if (space.getType() == "House") {
                House house = (House) space;
                if (house.getNumHouses()>0) {
                    houseAssets += (house.getNumHouses() * (house.getHouseCost()/2));
                }
            }
        }

        //The player will now have the choice to unMortgage or pay interest on newly owned mortgaged properties-they must choose one or the other.

        int totalUnMortgageCost = 0;
        int totalInterestCost = 0;
        int remainingBalance = 0;

        for (BoardSpace space : this.ownedProps) {

            //Checks minimum cost of newly acquired properties
            int costToPayRemainingInterest = 0;
            for (BoardSpace remainingSpace : ownedProps) {
                PropertySpace remainingProp = (PropertySpace) remainingSpace;
                costToPayRemainingInterest += (remainingProp.getPrice() * .05);
            }
            remainingBalance = owedPlayer.playerMoney + this.playerMoney + houseAssets - totalInterestCost - totalUnMortgageCost;

            //If the player is bankrupted by bankrupting another player, the method immediately returns the funds the player needs to raise to stay in the game.
            if (costToPayRemainingInterest > remainingBalance) {
                return (-1)*(costToPayRemainingInterest);
            }

            //Knowing the player is not bankrupted by this transfer, all properties will be transferred to the new owner
            owedPlayer.ownedProps.add(space);
            PropertySpace prop = (PropertySpace) space;
            prop.setOwner(owedPlayer.getName());

            if (prop.isMortgaged()) {

                //For each new mortgaged property, if the player cannot afford to unMortgage it fully, they are forced to pay the interest and accept the mortgaged property.
                if (costToPayRemainingInterest > (remainingBalance-((prop.getPrice())*.55))) {
                    totalInterestCost += (prop.getPrice() * .05);
                    System.out.println("You now own " + prop.getName() + " but cannot afford to unmortgage it at this time.");
                }
                //However, if they can afford to unMortgage it  fully they are given the choice to do so or not.
                else {
                    options.add("1. Unmortgage this property. Costs: $" + ((prop.getPrice()) * .55));
                    options.add("2. Only pay interest. Property stays mortgaged, and interest will need to be paid again to unmortgage in the future. Costs: $" + ((prop.getPrice()) * .05));
                    System.out.println("\n You have $" + remainingBalance + " remaining.");
                    OptionHandler unmortgageQuery = new OptionHandler("You now control " + prop.getName() + "which is mortgaged, what would you like to do with it?", options);
                    int unmortgageChoice = unmortgageQuery.handleOptions(scanner);
                    options.clear();

                    //If they choose to unmortage it,the property's isMortgaged bool is set to false & the total cost of the player's unmortgages so far this turn is tallied.
                    if (unmortgageChoice == 1) {
                        prop.setUnMortgaged();
                        totalUnMortgageCost += (prop.getPrice() * .55);
                    }
                    //If they don't, the cost of interest is tallied & the property remains mortgaged.
                    else {
                        totalInterestCost += (prop.getPrice() * .05);
                    }
                }
            }
        }
        //The program returns the net effect on the owed players $
        return houseAssets+this.playerMoney-totalUnMortgageCost-totalInterestCost;
    }

    public void removePlayer() {
        for (main.java.BoardSpace foreclosedSpace  : this.getOwnedProps()) {
            PropertySpace foreclosedProp = (PropertySpace) foreclosedSpace;
            foreclosedProp.setUnMortgaged();
            foreclosedProp.setOwner("");
            if (foreclosedProp.getType() == "House") {
                House foreclosedHouse = (House) foreclosedProp;
                foreclosedHouse.setNumHouses(0);
            }
            System.out.println(this.getName() + " has been eliminated!");
        }
    }

    public boolean isInJail() {
        return inJail;
    }

    public int chooseProperty(String action, Scanner scanner) {
        List<Integer> ownedPropsIndex = new ArrayList<>();
        List<String> options = new ArrayList<>();
        int ownedPropsIndexCounter = -1;
        int optionsCounter = 0;
        int selectedProp = -1;

        if (action == "Mortgage Property") {
            for (BoardSpace space : this.ownedProps) {
                ownedPropsIndexCounter++;
                PropertySpace prop = (PropertySpace) space;
                if (!prop.isMortgaged()) {
                    optionsCounter++;
                    options.add(optionsCounter + ". " + prop.getName() + "\n    Mortgage Value: $" + (prop.getPrice()/2));
                    ownedPropsIndex.add(ownedPropsIndexCounter);
                }
            }
            optionsCounter++;
            options.add(optionsCounter + ". Back");
            OptionHandler selectedPropQuery = new OptionHandler("What property would you like to mortgage?", options);
            selectedProp = selectedPropQuery.handleOptions(scanner);
            options.clear();
        }

        else if (action == "Unmortgage Property") {
            for (BoardSpace space : this.ownedProps) {
                ownedPropsIndexCounter++;
                PropertySpace prop = (PropertySpace) space;
                if (prop.isMortgaged()) {
                    optionsCounter++;
                    options.add(optionsCounter + ". " + prop.getName() + "\n    Unmortgage Cost: $" + (prop.getPrice()*.55));
                    ownedPropsIndex.add(ownedPropsIndexCounter);
                }
            }
            optionsCounter++;
            options.add(optionsCounter + ". Back");
            OptionHandler selectedPropQuery = new OptionHandler("What property would you like to unmortgage?", options);
            selectedProp = selectedPropQuery.handleOptions(scanner);
            options.clear();
        }

        else if (action == "Buy House") {
            List<String> checkedColors = new ArrayList<>();
            for (BoardSpace space : this.ownedProps) {
                ownedPropsIndexCounter++;
                PropertySpace prop = (PropertySpace) space;
                if (prop.getType() == "House") {
                    House house = (House) prop;
                    if (checkedColors.contains(house.getColor())) {
                        List<House> validHouseLocations = this.meetsBuildCondition(house.getColor());
                        for (House validBuild : validHouseLocations) {
                            optionsCounter++;
                            options.add(optionsCounter + ". " + validBuild.getName() + "\n  House Cost: $" + validBuild.getHouseCost());
                            ownedPropsIndex.add(ownedPropsIndexCounter);
                        }
                    }
                }
            }
            optionsCounter++;
            options.add(optionsCounter + ". Back");
            OptionHandler selectedPropQuery = new OptionHandler("On which property would you like to build a house?", options);
            selectedProp = selectedPropQuery.handleOptions(scanner);
            options.clear();
        }

        if (action == "Sell House") {
            for (BoardSpace space : this.ownedProps) {
                ownedPropsIndexCounter++;
                PropertySpace prop = (PropertySpace) space;
                if (prop.getType() == "House") {
                    House house = (House) prop;
                    if (house.getNumHouses() > 0) {
                        optionsCounter++;
                        options.add(optionsCounter + ". " + prop.getName() + "\n    House Value: $" + (house.getHouseCost()/2));
                        ownedPropsIndex.add(ownedPropsIndexCounter);
                    }
                }
            }
            optionsCounter++;
            options.add(optionsCounter + ". Back");
            OptionHandler selectedPropQuery = new OptionHandler("From which property would you like to sell a house?", options);
            selectedProp = selectedPropQuery.handleOptions(scanner);
            options.clear();


        }
        if (selectedProp == optionsCounter) {
            return -1;
        } else {
            return ownedPropsIndex.get(selectedProp-1);
        }
    }
}
