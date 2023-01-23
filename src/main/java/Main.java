import jdk.jshell.execution.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        Boolean gameOver = false;
        Boolean selectingPlayerNum = true;
        int turnCounter = 0;
        int selectedPlayerNum = 0;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {

            //Accept user input for number of players

            while (selectingPlayerNum) {

                try {

                    //Get Input
                    System.out.print("Enter the number of players, between 2 and 4.");
                    selectedPlayerNum = scanner.nextInt();
                    if (selectedPlayerNum < 2 || selectedPlayerNum > 4) {
                        throw new IllegalArgumentException("Invalid input, number must be between 2 and 4");
                    }
                    System.out.println("You entered: " + selectedPlayerNum);

                    //Generate Players
                    for (int i = 1; i <= selectedPlayerNum; i++) {
                        players.add(new Player("Player " + i));
                        System.out.println(players.get(i-1).getName() + " created!");
                    }
                    //Exit Loop
                    selectingPlayerNum = false;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, not a number");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            //Increment Turn
            turnCounter++;
            if (turnCounter>selectedPlayerNum) {
                turnCounter-=selectedPlayerNum;
            }

            //Define Active Player
            Player activePlayer = players.get(turnCounter-1);
            String name = activePlayer.getName();
            System.out.println(name + "'s turn!");

            //Roll Dice
            Boolean doubles = false;
            int roll1 = activePlayer.rollDice();
            int roll2 = activePlayer.rollDice();
            if (roll1 == roll2) {
                doubles = true;
            }
            int totalRoll = roll1+roll2;
            System.out.println(name + " rolled a " + totalRoll + "!");

            //Move
            activePlayer.move(totalRoll);
            main.java.BoardSpace landedSpace = board.getSpaceDetails(activePlayer.getCurrentSpace());
            System.out.println(name + " landed on " + landedSpace.getName() + ".");


            //Check Space Type
            String type = landedSpace.getType();

            //Action Sequence
            if (type == "House" || type == "Rail" || type == "Utility") {

                PropertySpace prop = (PropertySpace) landedSpace;
                if(prop.getOwner() == "") {
                    //Buy Prop Choice
                    System.out.println("Would you like to purchase this property? \n 1: Yes \n 2: No");
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
                    try {
                        int purchaseChoice = scanner.nextInt();
                        if (purchaseChoice < 1 || purchaseChoice > 2) {
                            throw new IllegalArgumentException("Invalid input, please choose either 1 or 2.");
                        }
                        if (purchaseChoice == 1) {
                            activePlayer.buyProperty(board);
                        } else {
                            System.out.println("You've chosen not to purchase this property.");
                        }
                        gameOver = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, not a number");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }





        }
    }
}