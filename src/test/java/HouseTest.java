import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest extends Main {

    private Board testBoard;
    private ArrayList<main.java.BoardSpace> myList = new ArrayList<main.java.BoardSpace>();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);

    @BeforeEach
    void setUp(){

        myList.add(new main.java.BoardSpace("Go", "Action Space"));
        myList.add(new House("Mediterranean Avenue","House",60,"Player 1",false,"Brown",50,0, new int[]{2,4,10,30,90,160,250}, false));

        testBoard = new Board(myList);

        System.setOut(printStream);
    }

    @Test
    void toStringTest() {
        main.java.BoardSpace space = myList.get(1);
        PropertySpace prop = (PropertySpace) space;
        House house = (House) prop;
        assertEquals(house.toString(), "Name: Mediterranean Avenue\nBrown\n\nPrice: 60\n\nRent with 0 Houses: $2\nRent with 1 House: $4\nRent with 2 Houses: $10\nRent with 3 Houses: $30\nRent with 4 Houses: $90\nRent with Hotel: $160");
    }
}