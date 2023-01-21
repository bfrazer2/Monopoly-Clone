import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        spaces.add(new BoardSpace("Go", "Action Space"));
<<<<<<< Updated upstream
        spaces.add(new House("Mediterranean Avenue","House",60, 30,33,"","Brown",50,0, new int[]{2,4,10,30,90,160,250}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Baltic Avenue","House",60, 30,33,"","Brown",50,0, new int[]{4,8,20,60,180, 320, 450}, false));
        spaces.add(new BoardSpace("IncomeTax", "Action Space"));
        spaces.add(new Rail("Reading Railroad", "Rail",200,100,110,""));
        spaces.add(new House("Oriental Avenue", "House",100,50,55,"","Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Vermont Avenue", "House",100,50,55,"","Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new House("Connecticut Avenue", "House",120,60,66,"","Light Blue",50,0,new int[]{8,16,40,100,300,450,600}, false));
        spaces.add(new BoardSpace("Jail","Action Space"));
        spaces.add(new House("St. Charles Place", "House",140,70,77,"","Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new Utility("Electric Company", "Utility",150,75,83,""));
        spaces.add(new House("States Avenue", "House",140,70,77,"","Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new House("Virginia Avenue", "House",160,80,88,"","Purple",100,0,new int[]{12,24,60,180,500,700,900}, false));
        spaces.add(new Rail("Pennsylvania Railroad", "Rail",200,100,110,""));
        spaces.add(new House("St. James Place", "House",180,90,99,"","Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Tennessee Avenue", "House",180,90,99,"","Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new House("New York Avenue", "House",200,100,110,"","Orange",100,0,new int[]{16,32,80,220,600,800,1000}, false));
        spaces.add(new BoardSpace("Free Parking","Action Space"));
        spaces.add(new House("Kentucky Avenue", "House",220,110,121,"","Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Indiana Avenue", "House",220,110,121,"","Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new House("Illinois Avenue", "House",240,120,132,"","Red",150,0,new int[]{20,40,100,300,750,925,1100}, false));
        spaces.add(new Rail("B&O Railroad", "Rail",200,100,110,""));
        spaces.add(new House("Atlantic Avenue", "House",260,130,143,"","Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new House("Ventnor Avenue", "House",260,130,143,"","Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new Utility("Water Works", "Utility",150,75,83,""));
        spaces.add(new House("Marvin Gardens", "House",280,140,154,"","Yellow",150,0,new int[]{24,48,120,360,850,1025,1200}, false));
        spaces.add(new BoardSpace("Go To Jail","Action Space"));
        spaces.add(new House("Pacific Avenue", "House",300,150,165,"","Green",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new House("North Carolina Avenue", "House",300,160,165,"","Geen",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Pennsylvania Ave", "House",320,160,176,"","Green",200,0,new int[]{28,56,150,450,1000,1200,1400}, false));
        spaces.add(new Rail("Short Line", "Rail",200,100,110,""));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Park Place", "House",350,175,193,"","Dark Blue",200,0,new int[]{35,70,175,500,1100,1300,1500},false));
        spaces.add(new BoardSpace("Luxury Tax","Action Space"));
        spaces.add(new House("Boardwalk", "House",400,200,220,"","Dark Blue",200,0,new int[]{50,100,200,600,1400,1700,2000},false));
=======
        spaces.add(new House("Mediterranean Avenue","House",60,"",false,"Brown",50,0, new int[]{2,4,10,30,90,160,250}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Baltic Avenue","House",60,"",false,"Brown",50,0, new int[]{4,8,20,60,180, 320, 450}, false));
        spaces.add(new BoardSpace("IncomeTax", "Action Space"));
        spaces.add(new Rail("Reading Railroad", "Rail",200,"", false));
        spaces.add(new House("Oriental Avenue", "House",100,"",false, "Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Vermont Avenue", "House",100,"",false,"Light Blue",50,0,new int[]{6,12,30,90,270,400,550}, false));
        spaces.add(new House("Connecticut Avenue", "House",120,"",false,"Light Blue",50,0,new int[]{8,16,40,100,300,450,600}, false));
        spaces.add(new BoardSpace("Jail","Action Space"));
        spaces.add(new House("St. Charles Place", "House",140,"",false,"Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new Utility("Electric Company", "Utility",150,"", false));
        spaces.add(new House("States Avenue", "House",140,"",false,"Purple",100,0,new int[]{10,20,50,150,450,625,750}, false));
        spaces.add(new House("Virginia Avenue", "House",160,"",false,"Purple",100,0,new int[]{12,24,60,180,500,700,900}, false));
        spaces.add(new Rail("Pennsylvania Railroad", "Rail",200,"",false));
        spaces.add(new House("St. James Place", "House",180,"",false,"Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Tennessee Avenue", "House",180,"",false,"Orange",100,0,new int[]{14,28,70,200,550,750,950}, false));
        spaces.add(new House("New York Avenue", "House",200,"",false,"Orange",100,0,new int[]{16,32,80,220,600,800,1000}, false));
        spaces.add(new BoardSpace("Free Parking","Action Space"));
        spaces.add(new House("Kentucky Avenue", "House",220,"",false,"Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Indiana Avenue", "House",220,"",false,"Red",150,0,new int[]{18,36,90,250,700,875,1050}, false));
        spaces.add(new House("Illinois Avenue", "House",240,"",false,"Red",150,0,new int[]{20,40,100,300,750,925,1100}, false));
        spaces.add(new Rail("B&O Railroad", "Rail",200,"",false));
        spaces.add(new House("Atlantic Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new House("Ventnor Avenue", "House",260,"",false,"Yellow",150,0,new int[]{22,44,110,330,800,975,1150}, false));
        spaces.add(new Utility("Water Works", "Utility",150,"",false));
        spaces.add(new House("Marvin Gardens", "House",280,"",false,"Yellow",150,0,new int[]{24,48,120,360,850,1025,1200}, false));
        spaces.add(new BoardSpace("Go To Jail","Action Space"));
        spaces.add(new House("Pacific Avenue", "House",300,"",false,"Green",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new House("North Carolina Avenue", "House",300,"",false,"Geen",200,0,new int[]{26,52,130,390,900,1100,1275}, false));
        spaces.add(new BoardSpace("Community Chest", "Action Space"));
        spaces.add(new House("Pennsylvania Ave", "House",320,"",false,"Green",200,0,new int[]{28,56,150,450,1000,1200,1400}, false));
        spaces.add(new Rail("Short Line", "Rail",200,"",false));
        spaces.add(new BoardSpace("Chance","Action Space"));
        spaces.add(new House("Park Place", "House",350,"",false,"Dark Blue",200,0,new int[]{35,70,175,500,1100,1300,1500},false));
        spaces.add(new BoardSpace("Luxury Tax","Action Space"));
        spaces.add(new House("Boardwalk", "House",400,"",false,"Dark Blue",200,0,new int[]{50,100,200,600,1400,1700,2000},false));
>>>>>>> Stashed changes


        Board myBoard = new Board(spaces);
        myBoard.viewBoard();
    }

    public static List<Object> spaces = new ArrayList<>();
}