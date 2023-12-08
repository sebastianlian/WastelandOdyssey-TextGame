import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Map {
    public String loadRooms = "Rooms.txt";
    public String loadItems = "Items.txt";
    public String loadPuzzles = "Puzzles.txt";
    public String loadMonsters = "Monsters.txt";
    public HashMap<Integer, Room> hashMapRooms = new HashMap<Integer, Room>();
    public HashMap<Integer, Items> hashMapItems = new HashMap<Integer, Items>();
    public HashMap<Integer, Puzzles> hashMapPuzzles = new HashMap<Integer, Puzzles>();
    public HashMap<Integer, Monsters> hashMapMonsters = new HashMap<Integer, Monsters>();

    public Map() {
        parseFiles();
    }

    public void parseFiles() {

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(loadRooms)); // buffer reader used to read the file
            while ((line = br.readLine()) != null) { // while loop that reads until the end of the file

                String[] rParts = line.split("~", 10);

                if (rParts.length >= 10) {
                    Room roomsParts = new Room(Integer.parseInt(rParts[0]), Boolean.parseBoolean(rParts[1]), rParts[2],
                            Integer.parseInt(rParts[3]), Integer.parseInt(rParts[4]), Integer.parseInt(rParts[5]),
                            Integer.parseInt(rParts[6]), rParts[7], rParts[8], rParts[9]);
                    hashMapRooms.put(roomsParts.getRoomID(), roomsParts);
                }
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(loadItems));
            while ((line = br.readLine()) != null) {

                String[] iParts = line.split("~", 5);
                if (iParts.length >= 5) {
                    Items itemsParts = new Items(Integer.parseInt(iParts[0]), iParts[1], iParts[2], iParts[3], Integer.parseInt(iParts[4]));
                    hashMapItems.put(itemsParts.getItemRoomID(), itemsParts);
                }
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(loadPuzzles));
            while ((line = br.readLine()) != null) {

                String[] pParts = line.split("~", 7);
                if (pParts.length >= 6) {
                    Puzzles puzzlesParts = new Puzzles(Integer.parseInt(pParts[0]), pParts[1], pParts[2], pParts[3], pParts[4], Integer.parseInt(pParts[5]), Boolean.parseBoolean(pParts[6]));
                    hashMapPuzzles.put(puzzlesParts.getPuzzleRoomID(), puzzlesParts);
                }
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(loadMonsters));
            while ((line = br.readLine()) != null) {

                String[] mParts = line.split("~", 5);
                if (mParts.length >= 5) {
                    int monsterID = Integer.parseInt(mParts[0]);
                    String monsterName = mParts[1];
                    String monsterDescription = mParts[2];
                    int monsterDamage = Integer.parseInt(mParts[3]);
                    boolean monsterDefeated = Boolean.parseBoolean(mParts[4]);

                    Monsters monstersParts = new Monsters(monsterID, monsterName, monsterDescription, monsterDamage, monsterDefeated);
                    hashMapMonsters.put(monstersParts.getMonsterRoomID(), monstersParts);
                }
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    public ArrayList<Monsters> getIgnoreMonsters() {
//        return ignoredMonsters;
//    }
}
