import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest extends Main {

    private ArrayList<main.java.BoardSpace> myList = new ArrayList<main.java.BoardSpace>();
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(outContent);

    @BeforeEach
    void setUp(){

        myList.add(new main.java.BoardSpace("Go", "Action Space"));
        myList.add(new Utility("Water Works", "Utility",150,"",false));

        System.setOut(printStream);
    }

    @Test
    void toStringTest() {
        main.java.BoardSpace space = myList.get(1);
        PropertySpace prop = (PropertySpace) space;
        Utility utility = (Utility) prop;
        assertEquals(utility.toString(), "Name: Water Works\n" +
                "\n" +
                "Price: 150\n" +
                "\n" +
                "Rent with 1 Util Owned: 4*Dice Roll\n" +
                "Rent with 2 Utils Owned: 10*Dice Roll");
    }
}