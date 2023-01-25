import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PropertySpaceTest extends Main {
    private Board testBoard;
    private Player player1;
    private Player player2;
    private ArrayList<main.java.BoardSpace> myList = new ArrayList<main.java.BoardSpace>();
    private ArrayList<main.java.BoardSpace> player1Props = new ArrayList<>();
    private ArrayList<main.java.BoardSpace> player2Props = new ArrayList<>();
    //Setting up for System.out.print Testing
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);
    private main.java.BoardSpace space;

    @BeforeEach
    void setUp() {
        myList.add(new main.java.BoardSpace("Go", "Action Space"));
        myList.add(new House("Mediterranean Avenue","House",60,"player1",false,"Brown",50,0, new int[]{2,10,30,90,160,250}, false));
        myList.add(new main.java.BoardSpace("Community Chest", "Action Space"));
        myList.add(new House("Baltic Avenue","House",60,"player1",false,"Brown",50,1, new int[]{4,20,60,180, 320, 450}, false));
        myList.add(new main.java.BoardSpace("IncomeTax", "Action Space"));
        myList.add(new Rail("Reading Railroad", "Rail",200,"", false));
        myList.add(new House("Oriental Avenue", "House",100,"",false, "Light Blue",50,0,new int[]{6,30,90,270,400,550}, false));
        myList.add(new main.java.BoardSpace("Chance","Action Space"));
        myList.add(new House("Vermont Avenue", "House",100,"",false,"Light Blue",50,0,new int[]{6,30,90,270,400,550}, false));
        myList.add(new House("Connecticut Avenue", "House",120,"",false,"Light Blue",50,0,new int[]{8,40,100,300,450,600}, false));
        myList.add(new main.java.BoardSpace("Jail","Action Space"));
        myList.add(new Utility("Electric Company", "Utility",150,"", false));
        myList.add(new main.java.BoardSpace("Free Parking","Action Space"));
        myList.add(new main.java.BoardSpace("Chance","Action Space"));
        myList.add(new Rail("B&O Railroad", "Rail",200,"",false));
        myList.add(new Utility("Water Works", "Utility",150,"",false));

        testBoard = new Board(myList);

        player1 = new Player("player1", player1Props, 1500, 0, 0, 1, false);
        player2 = new Player("player2",player2Props, 1500, 0,0,0,false);
        players.add(player1);
        players.add(player2);

    }
    @Test
    void calculateRent() {
        //Works for House
        space = testBoard.getSpaceDetails(1);
        PropertySpace propSpace1 = (PropertySpace) (space);
        int result = propSpace1.calculateRent(space,3);
        assertEquals(2, result);

        //Works for House with houses
        space = testBoard.getSpaceDetails(3);
        PropertySpace propSpace2 = (PropertySpace) space;
        result = propSpace2.calculateRent(space, 3);
        assertEquals(20, result);

        //Works for 1 Rail
        player1.setCurrentSpace(5);
        player1.buyProperty(testBoard);
        space = testBoard.getSpaceDetails(5);
        PropertySpace propSpace3 = (PropertySpace) space;
        result = propSpace3.calculateRent(space,3);
        assertEquals(25,result);

        //Works for multiple Rails
        space = testBoard.getSpaceDetails(14);
        PropertySpace propSpace4 = (PropertySpace) space;
        player1.setCurrentSpace(14);
        player1.buyProperty(testBoard);
        result = propSpace4.calculateRent(space,3);
        assertEquals(50,result);

        //Works for Utility
        player1.setCurrentSpace(11);
        player1.buyProperty(testBoard);
        space = testBoard.getSpaceDetails(11);
        PropertySpace propSpace5 = (PropertySpace) space;
        result = propSpace5.calculateRent(space,3);
        assertEquals(12,result);

        //Works for multiple Utilities
        space = testBoard.getSpaceDetails(15);
        PropertySpace propSpace6 = (PropertySpace) space;
        player1.setCurrentSpace(15);
        player1.buyProperty(testBoard);
        result = propSpace6.calculateRent(space,3);
        assertEquals(30,result);

        //Can get property owner
        Player res = propSpace6.getOwnerObject();
        assertEquals(player1,res);

        //Can create with empty constructor
        main.java.BoardSpace space = new main.java.BoardSpace();
        assertNotNull(space);
    }
}