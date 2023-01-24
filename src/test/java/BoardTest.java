import main.java.BoardSpace;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest extends Main {

    private Board testBoard;
    private ArrayList<main.java.BoardSpace> myList = new ArrayList<BoardSpace>();
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
    void viewBoard() {
        testBoard.viewBoard();
        assertEquals("1: Go\n2: Mediterranean Avenue\n  Owner: Player 1", outContent.toString().trim());
    }
    @Test
    void getSpaceDetails() {
        main.java.BoardSpace testSpace1 = testBoard.getSpaceDetails(0);
        assertEquals("Go", testSpace1.getName());
        main.java.BoardSpace testSpace2 = testBoard.getSpaceDetails(1);
        assertEquals("Mediterranean Avenue", testSpace2.getName());
    }
}