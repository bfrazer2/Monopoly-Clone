import java.io.IOException;
import java.util.*;

public class Main {
    public static List<Object> spaces = new ArrayList<>();
    public static List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        spaces.add(new main.java.BoardSpace("Go", "Action Space"));
        spaces.add(new House("Mediterranean Avenue","House",60,"",false,"Brown",50,0, new int[]{2,10,30,90,160,250}, false));
        spaces.add(new main.java.BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Baltic Avenue","House",60,"",false,"Brown",50,0, new int[]{4,20,60,180, 320, 450}, false));
        spaces.add(new main.java.BoardSpace("IncomeTax", "Action Space"));
        spaces.add(new Rail("Reading Railroad", "Rail",200,"", false));
        spaces.add(new House("Oriental Avenue", "House",100,"",false, "Light Blue",50,0,new int[]{6,30,90,270,400,550}, false));
        spaces.add(new main.java.BoardSpace("Chance","Action Space"));
        spaces.add(new House("Vermont Avenue", "House",100,"",false,"Light Blue",50,0,new int[]{6,30,90,270,400,550}, false));
        spaces.add(new House("Connecticut Avenue", "House",120,"",false,"Light Blue",50,0,new int[]{8,40,100,300,450,600}, false));
        spaces.add(new main.java.BoardSpace("Jail","Action Space"));
        spaces.add(new House("St. Charles Place", "House",140,"",false,"Purple",100,0,new int[]{10,50,150,450,625,750}, false));
        spaces.add(new Utility("Electric Company", "Utility",150,"", false));
        spaces.add(new House("States Avenue", "House",140,"",false,"Purple",100,0,new int[]{10,50,150,450,625,750}, false));
        spaces.add(new House("Virginia Avenue", "House",160,"",false,"Purple",100,0,new int[]{12,60,180,500,700,900}, false));
        spaces.add(new Rail("Pennsylvania Railroad", "Rail",200,"",false));
        spaces.add(new House("St. James Place", "House",180,"",false,"Orange",100,0,new int[]{14,70,200,550,750,950}, false));
        spaces.add(new main.java.BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Tennessee Avenue", "House",180,"",false,"Orange",100,0,new int[]{14,70,200,550,750,950}, false));
        spaces.add(new House("New York Avenue", "House",200,"",false,"Orange",100,0,new int[]{16,80,220,600,800,1000}, false));
        spaces.add(new main.java.BoardSpace("Free Parking","Action Space"));
        spaces.add(new House("Kentucky Avenue", "House",220,"",false,"Red",150,0,new int[]{18,90,250,700,875,1050}, false));
        spaces.add(new main.java.BoardSpace("Chance","Action Space"));
        spaces.add(new House("Indiana Avenue", "House",220,"",false,"Red",150,0,new int[]{18,90,250,700,875,1050}, false));
        spaces.add(new House("Illinois Avenue", "House",240,"",false,"Red",150,0,new int[]{20,100,300,750,925,1100}, false));
        spaces.add(new Rail("B&O Railroad", "Rail",200,"",false));
        spaces.add(new House("Atlantic Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,110,330,800,975,1150}, false));
        spaces.add(new House("Ventnor Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,110,330,800,975,1150}, false));
        spaces.add(new Utility("Water Works", "Utility",150,"",false));
        spaces.add(new House("Marvin Gardens", "House",280,"",false,"Yellow",150,0,new int[]{24,120,360,850,1025,1200}, false));
        spaces.add(new main.java.BoardSpace("Go To Jail","Action Space"));
        spaces.add(new House("Pacific Avenue", "House",300,"",false,"Green",200,0,new int[]{26,130,390,900,1100,1275}, false));
        spaces.add(new House("North Carolina Avenue", "House",300,"",false,"Geen",200,0,new int[]{26,130,390,900,1100,1275}, false));
        spaces.add(new main.java.BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Pennsylvania Ave", "House",320,"",false,"Green",200,0,new int[]{28,150,450,1000,1200,1400}, false));
        spaces.add(new Rail("Short Line", "Rail",200,"",false));
        spaces.add(new main.java.BoardSpace("Chance","Action Space"));
        spaces.add(new House("Park Place", "House",350,"",false,"Dark Blue",200,0,new int[]{35,175,500,1100,1300,1500},false));
        spaces.add(new main.java.BoardSpace("Luxury Tax","Action Space"));
        spaces.add(new House("Boardwalk", "House",400,"",false,"Dark Blue",200,0,new int[]{50,200,600,1400,1700,2000},false));

        //Create GameBoard
        Board board = new Board(spaces);

        //Set Game-flow Conditions
        Player activePlayer;
        Boolean gameOver = false;
        Boolean selectingPlayerNum = true;
        Boolean takingTurn;
        int turnCounter = 0;
        int playerNum = 0;

        //Setup for OptionsHandler
        List<String> options = new ArrayList<>();

        while(!gameOver) {

            //Accept user input for number of players
            while (selectingPlayerNum) {

                options.add("1. Two Players");
                options.add("2. Three Players");
                options.add("3. Four Players");
                OptionHandler playerNumQuery = new OptionHandler("How many players will play this game?", options);
                playerNum = playerNumQuery.handleOptions();
                options.clear();

                //Generate Players
                for (int i = 1; i <= playerNum+1; i++) {
                    players.add(new Player("Player " + i));
                    System.out.println(players.get(i-1).getName() + " created!");
                }
                //Exit Loop
                selectingPlayerNum = false;
            }

            //Increment Turn
            turnCounter++;
            if (turnCounter>players.size()) {
                turnCounter-=players.size();
            }

            //Define Active Player
            activePlayer = players.get(turnCounter-1);
            String name = activePlayer.getName();
            System.out.println("\n" + name + "'s turn!");

            //Roll Dice
            Boolean doubles = false;
            int roll1 = activePlayer.rollDice();
            int roll2 = activePlayer.rollDice();
            if (roll1 == roll2) {
                doubles = true;
            }
            int totalRoll = roll1+roll2;
            System.out.println("\n" + name + " rolled a " + totalRoll + "!");

            //Move
            activePlayer.move(totalRoll);
            main.java.BoardSpace landedSpace = board.getSpaceDetails(activePlayer.getCurrentSpace());
            System.out.println("\n" + name + " landed on " + landedSpace.getName() + ".\n");


            //Check Space Type
            String type = landedSpace.getType();

            //Action if lands on property
            if (type == "House" || type == "Rail" || type == "Utility") {

                PropertySpace prop = (PropertySpace) landedSpace;

                //Check to see if the landed space is already owned
                //If not, show the player the space details and give them the option to purchase it
                if(prop.getOwner() == "") {
                    //Buy Prop Choice
                    if(type == "House") {
                        House houseProp = (House) prop;
                        System.out.println(houseProp.toString());
                    } else if (type == "Rail") {
                        Rail railProp = (Rail) prop;
                        System.out.println(railProp.toString());
                    } else {
                        Utility utilityProp = (Utility) prop;
                        System.out.println(utilityProp.toString());
                    }

                    //Give the player the option to buy the property-if they can't afford to do so and choose yes anyway, the buyProperty method will handle it.
                    OptionHandler playerNumQuery = new OptionHandler("\nWould you like to purchase this property?", options);
                    options.add("1. Yes");
                    options.add("2. No");
                    int yesOrNo = playerNumQuery.handleOptions();
                    options.clear();
                        if (yesOrNo == 1) {
                            activePlayer.buyProperty(board);
                        } else {
                            System.out.println("You've chosen not to purchase this property.");
                        }
                }

                //If the property they've landed on is owned by another player, they have to pay rent!
                else {
                    System.out.println("Bad luck! You've landed on a property owned by " + prop.getOwner());

                    //Gets the total rent cost
                    int rent = prop.calculateRent(landedSpace,totalRoll);
                    //Subtracts funds from rent-paying player if they can afford it, returns false if they cannot afford it.
                    boolean paid = activePlayer.payRent(rent);

                    if (!paid) {
                        //If they failed to afford rent, the player will need to mortgage properties and/or sell houses to cover it. resolveBroke will handle that.
                        //Returns false if they still cannot afford rent (and thus lose the game), and returns true if they succeeded in staying afloat.
                        boolean isNotDefeated = activePlayer.resolveBroke(rent);

                        PropertySpace landedPropSpace = (PropertySpace) landedSpace;
                        Player landedSpaceOwner = landedPropSpace.getOwnerObject();

                        if (isNotDefeated) {
                            //The player owed rent receives it here as cash if the active player wasn't eliminated.
                            int newBalance = landedSpaceOwner.getPlayerMoney() + rent;
                            landedSpaceOwner.setPlayerMoney(newBalance);

                            //The player paying now needs to pay their rent. We don't assign this to a boolean because the logical result is true & we won't be using it.
                            activePlayer.payRent(rent);
                        } else {
                            System.out.println(name + "has been eliminated!");
                            //If the active player was eliminated, we check for game over condition.
                            if (players.size() == 2) {
                                gameOver = true;
                                System.out.println("\n" + landedSpaceOwner.getName() + " won! Congratulations!!");
                                break;
                            }
                            //If the game isn't over, we run assetsRetrieved, which handles the owed player receiving all the losing player's assets.
                            int assetsRetrieved = activePlayer.resolveBankruptcy(landedSpaceOwner);

                            //Receiving the defeated player's assets can net negative money-if the owed player can't pay that in cash, they'll need to mortgage or sell.
                            //Here we run resolveBroke again to handle that.
                            if (assetsRetrieved+landedSpaceOwner.getPlayerMoney() < 0) {
                                isNotDefeated = landedSpaceOwner.resolveBroke(assetsRetrieved);
                                if (isNotDefeated) {
                                    //If the owed player can now absorb the active players assets, we run the method which facilitates that.
                                    assetsRetrieved = activePlayer.resolveBankruptcy(landedSpaceOwner);
                                } else {
                                    //If the owed player is eliminated, both player's assets are set to neutral. removePlayer will handle that
                                    activePlayer.removePlayer();
                                    landedSpaceOwner.removePlayer();

                                    //We now check for a game over condition.
                                    if (players.size() == 1) {
                                        gameOver = true;
                                        System.out.println("\n" + players.get(0).getName() + " won! Congratulations!!");
                                        break;
                                    }

                                }
                            }
                            int newBalance = landedSpaceOwner.getPlayerMoney() + assetsRetrieved;
                            landedSpaceOwner.setPlayerMoney(newBalance);
                            players.remove(turnCounter-1);
                        }
                    }
                }
            } else {
                System.out.println("This is an " + type + ". Functionality will be added here in future commits.");
            }
            
            takingTurn = true;
            while(takingTurn) {
                options.add("1. View Balance");
                options.add("2. View Board");
                options.add("3. Buy House");
                options.add("4. Sell House");
                options.add("5. Mortgage Property");
                options.add("6. UnMortgage Property");
                options.add("7. Pass Turn");
                OptionHandler whatToDoQuery = new OptionHandler("How many players will play this game?", options);
                int whatToDo = whatToDoQuery.handleOptions();
                options.clear();

                if (whatToDo == 1) {
                    System.out.println(activePlayer.getPlayerMoney());
                } else if (whatToDo == 2) {
                    board.viewBoard();
                } else if (whatToDo == 3) {
                    int propChoice = activePlayer.chooseProperty("Buy House");
                    if (propChoice != -1) {
                        activePlayer.buyHouse(propChoice);
                    }
                } else if (whatToDo == 4) {
                    int propChoice = activePlayer.chooseProperty("Sell House");
                    if (propChoice != -1) {
                        activePlayer.sellHouse(propChoice);
                    }
                } else if (whatToDo == 5) {
                    int propChoice = activePlayer.chooseProperty("Mortgage Property");
                    if (propChoice != -1) {
                        activePlayer.mortgageProperty(propChoice);
                    }
                } else if (whatToDo == 6) {
                    int propChoice = activePlayer.chooseProperty("Mortgage Property");
                    if (propChoice != -1) {
                        activePlayer.unMortgageProperty(propChoice);
                    }
                } else {
                    takingTurn = false;
                }
            }
        }
    }
}