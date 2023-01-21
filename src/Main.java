import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        spaces.add(new BoardSpace("Go", "Action Space"));
        spaces.add(new House("Mediterranean Avenue","House",60,"",false,"Brown",50,0, new int[]{2,4,10,30,90,160,250}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Baltic Avenue","House",60,"",false,"Brown",50,0, new int[]{4,8,20,60,180, 320, 450}, false));
        spaces.add(new BoardSpace("IncomeTax", "Action Space"));
        spaces.add(new Rail("Reading Railroad", "Rail",200,"", false));
        spaces.add(new House("Oriental Avenue", "House",100,"",false, "Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Vermont Avenue", "House",100,"",false,"Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new House("Connecticut Avenue", "House",120,"",false,"Light Blue",50,0,new int[]{8,16,40,100,300,450,600}, false));
        spaces.add(new BoardSpace("Jail","Action Space"));
        spaces.add(new House("St. Charles Place", "House",140,"",false,"Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new Utility("Electric Company", "Utility",150,"", false));
        spaces.add(new House("States Avenue", "House",140,"",false,"Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new House("Virginia Avenue", "House",160,"",false,"Purple",100,0,new int[]{12,24,60,180,500,700,900}, false));
        spaces.add(new Rail("Pennsylvania Railroad", "Rail",200,"",false));
        spaces.add(new House("St. James Place", "House",180,"",false,"Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Tennessee Avenue", "House",180,"",false,"Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new House("New York Avenue", "House",200,"",false,"Orange",100,0,new int[]{16,32,80,220,600,800,1000}, false));
        spaces.add(new BoardSpace("Free Parking","Action Space"));
        spaces.add(new House("Kentucky Avenue", "House",220,"",false,"Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Indiana Avenue", "House",220,"",false,"Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new House("Illinois Avenue", "House",240,"",false,"Red",150,0,new int[]{20,40,100,300,750,925,1100}, false));
        spaces.add(new Rail("B&O Railroad", "Rail",200,"",false));
        spaces.add(new House("Atlantic Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new House("Ventnor Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new Utility("Water Works", "Utility",150,"",false));
        spaces.add(new House("Marvin Gardens", "House",280,"",false,"Yellow",150,0,new int[]{24,48,120,360,850,1025,1200}, false));
        spaces.add(new BoardSpace("Go To Jail","Action Space"));
        spaces.add(new House("Pacific Avenue", "House",300,"",false,"Green",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new House("North Carolina Avenue", "House",300,"",false,"Geen",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Pennsylvania Ave", "House",320,"",false,"Green",200,0,new int[]{28,56,150,450,1000,1200,1400}, false));
        spaces.add(new Rail("Short Line", "Rail",200,"",false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Park Place", "House",350,"",false,"Dark Blue",200,0,new int[]{35,70,175,500,1100,1300,1500},false));
        spaces.add(new BoardSpace("Luxury Tax","Action Space"));
        spaces.add(new House("Boardwalk", "House",400,"",false,"Dark Blue",200,0,new int[]{50,100,200,600,1400,1700,2000},false));

        //Create Board Test
        Board board = new Board(spaces);

//
//        //Roll Dice Test
//        ArrayList<BoardSpace> player1Props = new ArrayList<>();
//        Player player1 = new Player(player1Props, 1500, 0,0,0,false);
//        System.out.println(player1.rollDice());
//        System.out.println(player1.rollDice());
//        System.out.println(player1.rollDice());
//        System.out.println(player1.rollDice());
//        System.out.println(player1.rollDice());
//
        //Move Test
        ArrayList<BoardSpace> player2Props = new ArrayList<>();
        Player player2 = new Player("player2",player2Props, 1500, 0,0,0,false);
//        System.out.println("Player 2 Started their turn on: " + player2.getCurrentSpace());
//        int roll = player2.rollDice();
//        System.out.println("Player 2 Rolled: " + roll);
//        player2.move(roll);
//        System.out.println("Player 2 Ended their turn on: " + player2.getCurrentSpace());
//        roll = player2.rollDice();
//        System.out.println("Player 2 Rolled: " + roll);
//        player2.move(roll);
//        System.out.println("Player 2 Ended their turn on: " + player2.getCurrentSpace());

        //Complete Circuit Test
//        player2.setCurrentSpace(0);
//        player2.move(45);
//        System.out.println(player2.getCurrentSpace());

//        //Buy Property Test
//        player2.setCurrentSpace(1);
//        player2.buyProperty(board);
//        System.out.println(player2.getOwnedProps());

//        //Too Poor to Buy Property Test
//        player2.setCurrentSpace(13);
//        player2.setPlayerMoney(0);
//        player2.buyProperty(board);
//        System.out.println(player2.getOwnedProps());

//        //Pay Rent Test
//        player2.payRent(100);
//        System.out.println(player2.getPlayerMoney());

//        //Mortgage Property Test
//        player2.mortgageProperty(0);
//
//        //UnMortgage Property test
//        player2.unMortgageProperty(0);
//
//        //Buy House Test
//        player2.setCurrentSpace(1);
//        player2.buyProperty(board);
//        player2.setCurrentSpace(3);
//        player2.buyProperty(board);
//        player2.buyHouse(0);
////
//        //Sell House Test
//        player2.sellHouse(0);

//        //Too Poor to Buy House Test
//        player2.setPlayerMoney(0);
//        player2.buyHouse(0);

    }

    public static List<Object> spaces = new ArrayList<>();
}