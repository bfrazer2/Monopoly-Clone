import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RailTest extends Main {

    private ArrayList<main.java.BoardSpace> myList = new ArrayList<main.java.BoardSpace>();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);

    @BeforeEach
    void setUp(){

        myList.add(new main.java.BoardSpace("Go", "Action Space"));
        myList.add(new Rail("Reading Railroad", "Rail",200,"", false));


        System.setOut(printStream);
    }

    @Test
    void toStringTest() {
        main.java.BoardSpace space = myList.get(1);
        PropertySpace prop = (PropertySpace) space;
        Rail rail = (Rail) prop;
        assertEquals(rail.toString(), "Name: Reading Railroad\n" +
                "\n" +
                "Price: 200\n" +
                "\n" +
                "Rent with 1 Rail: $25\n" +
                "Rent with 2 Houses: $50\n" +
                "Rent with 3 Houses: $100\n" +
                "Rent with 4 Houses: $200");
    }
}