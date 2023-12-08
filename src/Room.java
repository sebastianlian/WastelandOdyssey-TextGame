import java.util.ArrayList;

public class Room {

    private int  roomID = 0;
    private boolean roomVisited = false;
    private String roomName = "";
    private int northRoomID = 0;
    private int eastRoomID = 0;
    private int southRoomID = 0;
    private int westRoomID = 0;
    private String roomDescription = "";
    private String itemName = "";
    private String monsterName = "";
    private ArrayList  roomInventory ;
    private ArrayList<Monsters> roomMonsters; // ArrayList to store monsters


    public Room() {

    }

    public Room(int roomID, boolean roomVisitedStatus, String roomName,
                int northRoomID, int eastRoomID, int southRoomID, int westRoomID,
                String roomDescription, String itemName, String monsterName) {
        this.roomID = roomID;
        this.roomVisited = roomVisitedStatus;
        this.roomName = roomName;
        this.northRoomID = northRoomID;
        this.eastRoomID = eastRoomID;
        this.southRoomID = southRoomID;
        this.westRoomID = westRoomID;
        this.roomDescription = roomDescription;
        this.itemName = itemName;
        this.monsterName = monsterName;
        this.roomMonsters = new ArrayList<>(); // Initialize ArrayList for monsters

    }

    public ArrayList<Monsters> getRoomMonsters() {
        return roomMonsters;
    }

    public void addMonster(Monsters monster) {
        roomMonsters.add(monster);
    }

    public int getRoomID() {
        return roomID;
    }

    public boolean isRoomVisited() {

        return roomVisited;
    }

    public void setRoomVisited(boolean roomVisitedStatus) {
        this.roomVisited  = roomVisitedStatus;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

//    public void setRoomDescription(String roomDescription) {
//        this.roomDescription = roomDescription;
//    }
//
//    public String getRoomName() {
//        return roomName;
//    }
//
//    public void setRoomName(String roomName) {
//        this.roomDescription = roomName;
//    }

    public int getNorthRoomID() {
        return northRoomID;
    }

    public int getEastRoomID() {
        return eastRoomID;
    }

    public int getSouthRoomID() {
        return southRoomID;
    }

    public int getWestRoomID() {
        return westRoomID;
    }

    public String getItemName() {
        return itemName;
    }

    public String getMonsterName() {
        return monsterName;
    }

//    public void addItem(ArrayList roomInventory){
//        roomInventory.add(itemName);
//    }

    public void map() {
        System.out.println("----------------------------------------");
        System.out.println("MAP");
        System.out.println("Current Location: " + roomName);
        System.out.println("Exits: ");
        if (northRoomID != 0) {
            System.out.println("North -> " + northRoomID);
        }
        if (eastRoomID != 0) {
            System.out.println("East -> " + eastRoomID);
        }
        if (southRoomID != 0) {
            System.out.println("South -> " + southRoomID);
        }
        if (westRoomID != 0) {
            System.out.println("West -> " + westRoomID);
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String toString() {
        return  roomName;
    }
}