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
            System.out.print("" + i + ": " + mySpace.getName() +"\n");
            if (mySpace.getType() == "House" || mySpace.getType() == "Rail" || mySpace.getType() == "Utility") {
                PropertySpace prop = (PropertySpace) mySpace;
                if (prop.getOwner() != "") {
                    System.out.print("  Owner: " + prop.getOwner());
                }
            }
        }
    }

    public main.java.BoardSpace getSpaceDetails(int spaceNum){
        main.java.BoardSpace mySpace = (main.java.BoardSpace)(this.spaces.get(spaceNum));
        return mySpace;

    }
}
