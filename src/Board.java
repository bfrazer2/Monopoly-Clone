import java.util.*;

public class Board extends Main{

    public Board(List spaces) {
        this.spaces = spaces;
    }

    public void viewBoard() {
        int i = 0;
        for (Object space : spaces) {
            i++;
            BoardSpace mySpace = (BoardSpace)(space);
            System.out.println("" + i + ": " + mySpace.getName());
        }
    }

    public BoardSpace getSpaceDetails(int spaceNum){
        BoardSpace mySpace = (BoardSpace)(this.spaces.get(spaceNum));
        return mySpace;

    }
}
