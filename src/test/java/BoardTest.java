import main.java.BoardSpace;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest extends Main {

    Board testBoard;
    ArrayList<main.java.BoardSpace> myList = new ArrayList<BoardSpace>();

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
    }

    @Test
    void getSpaceDetails() {
        main.java.BoardSpace testSpace = testBoard.getSpaceDetails(1);
        String result = testSpace.getName();
        String expecting = "Mediterranean Avenue";
        assertEquals(expecting,result);
    }
}