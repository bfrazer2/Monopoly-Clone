public class PropertySpace extends main.java.BoardSpace {

    private int price;
    private String owner;
    private boolean mortgaged;

    public PropertySpace() {

    }

    public PropertySpace(String name, String type, int price, String owner, boolean mortgaged) {
        super(name, type);
        this.price = price;
        this.owner = owner;
        this.mortgaged = mortgaged;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setMortgaged() {
        this.mortgaged = true;
    }

    public void setUnMortgaged() {
        this.mortgaged = false;
    }

    public int getPrice() {
        return price;
    }

    public Player getOwnerObject() {
        Player owner = Main.players.stream().filter(player -> player.getName().equals(this.getOwner())).findFirst().orElse(null);
        return owner;
    }

    public int calculateRent(main.java.BoardSpace landedSpace, int diceRoll) {
        String type = landedSpace.getType();
        if (type == "House") {
            House house = (House) landedSpace;
            return house.calculateRent();
        } else if (type == "Rail") {
            Rail rail = (Rail) landedSpace;
            Player owner = Main.players.stream().filter(player -> player.getName().equals(rail.getOwner())).findFirst().orElse(null);
            return rail.calculateRent(owner);
        } else {
            Utility utility = (Utility) landedSpace;
            Player owner = Main.players.stream().filter(player -> player.getName().equals(utility.getOwner())).findFirst().orElse(null);
            return utility.calculateRent(owner, owner.rollDice());
        }
    }
}