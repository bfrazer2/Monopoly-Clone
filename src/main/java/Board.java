import java.util.*;

public class Board extends Main{

    public Board(List spaces) {
        this.spaces = spaces;
    }

    public void viewBoard() {
        int i = 0;
        for (Object space : spaces) {
            i++;
            main.java.BoardSpace mySpace = (main.java.BoardSpace)(space);
            System.out.println("" + i + ": " + mySpace.getName());
        }
    }

    public main.java.BoardSpace getSpaceDetails(int spaceNum){
        main.java.BoardSpace mySpace = (main.java.BoardSpace)(this.spaces.get(spaceNum));
        return mySpace;

    }
}
