import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest extends Main {

    private Board testBoard;
    private Player player2;
    private Player player1;
    private ArrayList<main.java.BoardSpace> myList = new ArrayList<main.java.BoardSpace>();
    private ArrayList<main.java.BoardSpace> player1Props = new ArrayList<>();
    private ArrayList<main.java.BoardSpace> player2Props = new ArrayList<>();
    //Setting up for System.out.print Testing
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);
    private main.java.BoardSpace space;
    private PropertySpace propSpace;
    private House houseSpace;




    @BeforeEach
    void setUp(){

        myList.add(new main.java.BoardSpace("Go", "Action Space"));
        myList.add(new House("Mediterranean Avenue","House",60,"",false,"Brown",50,0, new int[]{2,4,10,30,90,160,250}, false));
        myList.add(new main.java.BoardSpace("Community Chest", "Action Space"));
        myList.add(new House("Baltic Avenue","House",60,"",false,"Brown",50,0, new int[]{4,8,20,60,180, 320, 450}, false));
        myList.add(new main.java.BoardSpace("IncomeTax", "Action Space"));
        myList.add(new Rail("Reading Railroad", "Rail",200,"", false));
        myList.add(new House("Oriental Avenue", "House",100,"",false, "Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        myList.add(new main.java.BoardSpace("Chance","Action Space"));
        myList.add(new House("Vermont Avenue", "House",100,"",false,"Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        myList.add(new House("Connecticut Avenue", "House",120,"",false,"Light Blue",50,0,new int[]{8,16,40,100,300,450,600}, false));
        myList.add(new main.java.BoardSpace("Jail","Action Space"));
        myList.add(new Utility("Electric Company", "Utility",150,"", false));
        myList.add(new main.java.BoardSpace("Free Parking","Action Space"));
        myList.add(new main.java.BoardSpace("Chance","Action Space"));
        myList.add(new Rail("B&O Railroad", "Rail",200,"",false));
        myList.add(new Utility("Water Works", "Utility",150,"",false));

        testBoard = new Board(myList);

        player2 = new Player("player2",player2Props, 1500, 0,0,0,false);

        space = testBoard.getSpaceDetails(1);
        propSpace = (PropertySpace) (space);
        houseSpace = (House) (propSpace);


        //Setting up for System.out.print testing
        System.setOut(printStream);

    }
    @Test
    void rollDice() {
        int roll1 = player2.rollDice();
        assertTrue(roll1<=12 && roll1>=2);
        int roll2 = player2.rollDice();
        assertNotEquals(roll1, roll2);
    }

    @Test
    void move() {
        int roll = player2.rollDice();
        player2.move(roll);
        int currSpace = player2.getCurrentSpace();
        assertEquals(roll,currSpace);

        //Complete Circuit Test
        player2.setCurrentSpace(0);
        player2.move(45);
        assertEquals(5, player2.getCurrentSpace());
    }

    @Test
    void buyProperty() {
        //Buy Property
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);

        //Test that name of newly owned prop == expected name of purchased space.
        List<main.java.BoardSpace> p2owned = player2.getOwnedProps();
        main.java.BoardSpace testSpace = p2owned.get(0);
        PropertySpace testProp = (PropertySpace) (testSpace);
        String result = testProp.getName();
        String expecting = "Mediterranean Avenue";
        assertEquals(expecting, result);

        assertEquals("player2", propSpace.getOwner());

        //Property already owned Test
        outContent.reset();
        player1 = new Player("player1", player1Props, 1500, 0, 0, 1, false);
        player1.buyProperty(testBoard);
        assertEquals("Can't buy this property, it's already owned by player2!", outContent.toString().trim());
    }

    @Test
    void insufficientFunds() {
        //Too Poor to Buy Property Test
        player2.setCurrentSpace(3);
        player2.setPlayerMoney(0);

        player2.buyProperty(testBoard);
        assertEquals("Insufficient funds to buy this property!", outContent.toString().trim());
    }

//    @Test
//    void payRent() {
//    }

    @Test
    void mortgageProperty() {
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        player2.mortgageProperty(0);
        assertEquals(1470, player2.getPlayerMoney());
        assertTrue(propSpace.isMortgaged());
    }
//
    @Test
    void unMortgageProperty() {
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        player2.mortgageProperty(0);
        player2.unMortgageProperty(0);
        assertEquals(1437, player2.getPlayerMoney());
        assertTrue(!propSpace.isMortgaged());
    }

    @Test
    void hasMonopoly() {
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        player2.setCurrentSpace(3);
        player2.buyProperty(testBoard);
        player2.buyHouse(0);
        assertTrue(player2.hasMonopoly("Brown"));

        player2.setCurrentSpace(6);
        player2.buyProperty(testBoard);
        assertTrue(!player2.hasMonopoly("Light Blue"));
    }

    @Test
    void buyHouse() {
        //Buy House Test
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        player2.setCurrentSpace(3);
        player2.buyProperty(testBoard);
        player2.buyHouse(0);
        assertEquals(1, houseSpace.getNumHouses());
        assertEquals(1330, player2.getPlayerMoney());

        //Too Poor to Buy House Test
        player2.setPlayerMoney(0);
        player2.buyHouse(0);
        assertEquals(1, houseSpace.getNumHouses());
    }

    @Test
    void sellHouse() {
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        houseSpace.setNumHouses(1);
        player2.sellHouse(0);
        assertEquals(0, houseSpace.getNumHouses());
        assertEquals(1465, player2.getPlayerMoney());
    }

    @Test
    void countUtilities() {
        player2.setCurrentSpace(11);
        player2.buyProperty(testBoard);
        assertEquals(1, player2.countUtilities());
        player2.setCurrentSpace(15);
        player2.buyProperty(testBoard);
        assertEquals(2, player2.countUtilities());
    }

    @Test
    void countRails() {
        player2.setCurrentSpace(5);
        player2.buyProperty(testBoard);
        assertEquals(1, player2.countRails());
        player2.setCurrentSpace(14);
        player2.buyProperty(testBoard);
        assertEquals(2, player2.countRails());
    }

    @Test
    void meetsBuildCondition() {
        player2.setCurrentSpace(1);
        player2.buyProperty(testBoard);
        player2.setCurrentSpace(3);
        player2.buyProperty(testBoard);
        List<House> validHousePurchases = player2.meetsBuildCondition("Brown");
        
        assertEquals(2, validHousePurchases.size());
    }
}