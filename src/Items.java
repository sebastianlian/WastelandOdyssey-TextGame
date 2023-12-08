import java.util.ArrayList;

public class Items {
    private int itemRoomID = 0;
    private String itemName = "";
    private String itemDescription = "";
    private String itemType = "";
    private int itemPoints = 0;
    private ArrayList<String> arrayListOfItemNames = new ArrayList<>();
    private Map map;

    public Items() {
        map = new Map();
    }

    public Items(int itemRoomID, String itemName, String itemDescription, String itemType, int itemPoints) {
        this.itemRoomID = itemRoomID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.itemPoints = itemPoints;
    }

    public int getItemRoomID() {
        return itemRoomID;
    }

    public void setRoomID(int itemRoomID) {
        this.itemRoomID = itemRoomID;
    }

    public String getItemName() {
        setItemName(itemName.toLowerCase());
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    //TODO: FIX THIS SO THERE CAN BE DIFFERENT TYPES USAGES OF ITEMS
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
        arrayListOfItemNames.add(itemType);
    }

    public int getItemPoints() {
        return itemPoints;
    }

    public void setItemPoints(int itemPoints) {
        this.itemPoints = itemPoints;
    }

//    public void setItemDescription(String itemDescription) {
//        this.itemDescription = itemDescription;
//    }
}