import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Room currentRoom;
    private Room previousRoom;
    private Map map;
    private Items items;
    int updateItems = 0;
    private final Puzzles puzzle;
    private Monsters monster;

    private int playerAttackDamage;
    private int playerHealthPoints;
    private int playerDefensePoints;

    private final ArrayList<String> playerInventory = new ArrayList<>();
    private final ArrayList<String> roomInventory = new ArrayList<>();
    private final ArrayList<String> equippedItems = new ArrayList<>();
    private final ArrayList<String> healingItems = new ArrayList<>();
    private final ArrayList<Monsters> ignoredMonsters = new ArrayList<>();

    public Player() {
        map = new Map();
        currentRoom = map.hashMapRooms.get(1);
        puzzle = map.hashMapPuzzles.get(5);
        items = map.hashMapItems.get(1);
        monster = map.hashMapMonsters.get(4);
        roomInventory.add(items.getItemName());
        updateItems = items.getItemRoomID();
        this.playerHealthPoints = 100;
        this.playerAttackDamage = 5;
        this.playerDefensePoints = 5;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Puzzles getPuzzle() {
        return puzzle;
    }

    public Monsters getMonster() {
        return monster;
    }

    public Items getItems() {
        return items;
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
    }

    public void setPlayerHealthPoints(int playerHealthPoints) {
        this.playerHealthPoints = playerHealthPoints;
    }

    public int getAttackDamage() {
        return playerAttackDamage;
    }

    public void setAttackDamage(int playerAttackDamage) {
        this.playerAttackDamage = playerAttackDamage;
    }

    public void help() {
        System.out.println("----------------------------------------");
        System.out.println("~HELP MENU~\n" +
                "NAVIGATION COMMANDS: \n" +
                "|NORTH| |EAST| |SOUTH| |WEST| \n" +
                "The cardinal commands above are used to move across rooms.\n" +
                "OTHER COMMANDS: \n" +
                "|PICKUP| |DROP| |INVENTORY| |EXPLORE| |INSPECT| |EQUIP| |UNEQUIP| |HEAL| |STATS| |EXAMINE| |ATTACK| |IGNORE| |EXIT| |MAP|\n" +
                "The pickup command allows you to add items to your inventory.\n" +
                "The drop command allows you to drop items from your inventory.\n" +
                "The inventory command will display all the items in your current inventory.\n" +
                "The explore command will display the room description and any items/puzzles in the room.\n" +
                "The inspect command will display the designated item's description.\n" +
                "The equip command will equip the designated item.\n" +
                "The unequip command will unequip the designated item.\n" +
                "The heal command will heal the player with the designated item.\n" +
                "The stats command will display the player's stats.\n" +
                "The examine command will display the monster's stats.\n" +
                "The attack command will attack the monster.\n" +
                "The ignore command will ignore the monster.\n" +
                "The exit command will exit the game.\n" +
                "The map command will display the map.");
        System.out.println("----------------------------------------");
    }

    public void move(String playerInput) {
        int direction = -1;

        if (playerInput.equalsIgnoreCase("NORTH")) {
            direction = currentRoom.getNorthRoomID();
        } else if (playerInput.equalsIgnoreCase("SOUTH")) {
            direction = currentRoom.getSouthRoomID();
        } else if (playerInput.equalsIgnoreCase("EAST")) {
            direction = currentRoom.getEastRoomID();
        } else if (playerInput.equalsIgnoreCase("WEST")) {
            direction = currentRoom.getWestRoomID();
        }

        if (direction != 0) {
            updateRoom(direction);
        } else {
            System.out.println("You cannot go that way. You are back to " + getCurrentRoom());
        }
    }

    private void updateRoom(int newRoomID) {
        items.setRoomID(currentRoom.getRoomID());
        items = map.hashMapItems.get(currentRoom.getRoomID());
        roomInventory.remove(items.getItemName());

        currentRoom.setRoomVisited(true);
        previousRoom = currentRoom;
        currentRoom = map.hashMapRooms.get(newRoomID);

        items.setRoomID(currentRoom.getRoomID());
        items = map.hashMapItems.get(currentRoom.getRoomID());
        roomInventory.add(items.getItemName());

        System.out.println("You have arrived to " + getCurrentRoom());
        System.out.println(currentRoom.getRoomDescription());
    }

    public static void quitGame(String playerInput) {
        System.out.println("See you next time!");
        System.exit(0);
    }

    public void checkIfRoomHasBeenVisited() {
        if (currentRoom.isRoomVisited()) {
            System.out.println("Hmmm, this is familiar...");
        }
    }

    public void solvePuzzle(String playerInput) {
        puzzle.checkPlayersAnswer(playerInput);
    }

    public void pickUpItem(String playerInput) {
        if (playerInput.equalsIgnoreCase("PICKUP " + items.getItemName())
                && roomInventory.contains(items.getItemName()) &&
                (!items.getItemName().isEmpty()) && (!playerInventory.contains(items.getItemName()))) {
            playerInventory.add(items.getItemName());
            roomInventory.remove(items.getItemName());
            System.out.println(items.getItemName() + " has been added to inventory");
            System.out.println(playerInventory);
            System.out.println("---------------------------------------------");

        } else
            System.out.println("Invalid command. Try again.");
    }

    public void dropItem(String playerInput) {
        if (playerInput.equalsIgnoreCase("DROP " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            playerInventory.remove(items.getItemName());
            updateItems = items.getItemRoomID();
            roomInventory.add(items.getItemName());
            System.out.println(items.getItemName() + " has been removed from inventory.");
            System.out.println("---------------------------------------------");

        } else {

            System.out.println("This item is not in your inventory.");
        }
    }

    public void inspectItem(String playerInput) {
        if (playerInput.equalsIgnoreCase("INSPECT " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            System.out.println(items.getItemDescription());
            System.out.println("---------------------------------------------");
        } else
            System.out.println("This item is not in your inventory.");
    }

    public void getCurrentInventory(String playerInput) {
        if (playerInput.contains("INVENTORY") && playerInventory.isEmpty()) {
            System.out.println("Hmm, nothing in here...");
        } else
            System.out.println(playerInventory);
    }

    public void exploreRoom(String playerInput) {
        if (playerInput.equalsIgnoreCase("EXPLORE")) {
            System.out.println("Items in this room: " + roomInventory);
            System.out.println("Monsters in room: " + currentRoom.getMonsterName());
            System.out.println("---------------------------------------------");
        }
    }

    public void equipItem(String playerInput) {
        if (playerInput.equalsIgnoreCase("EQUIP " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            if (items.getItemType().equalsIgnoreCase("equip")) {
                equippedItems.add(items.getItemName());
                playerInventory.remove(items.getItemName());
                playerAttackDamage += items.getItemPoints();
                System.out.println(items.getItemName() + " has been equipped");
                System.out.println("Item Attack Damage: " + items.getItemPoints());
                System.out.println("Updated Attack Damage: " + playerAttackDamage);
                System.out.println("The " + items.getItemName() + " has added " + items.getItemPoints() + " to your attack damage.");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("This item cannot be equipped.");
            }
        } else {
            System.out.println("This item is not in your inventory.");
        }
    }

    public void unEquipItem(String playerInput) {
        if (playerInput.equalsIgnoreCase("UNEQUIP " + items.getItemName())
                && equippedItems.contains(items.getItemName())) {
            playerInventory.add(items.getItemName());
            equippedItems.remove(items.getItemName());
            playerAttackDamage -= items.getItemPoints();
            System.out.println(items.getItemName() + " has been unequipped.");
            System.out.println("Item Attack Damage: " + items.getItemPoints());
            System.out.println("Attack Damage: " + playerAttackDamage);
            System.out.println("Removal of " + items.getItemName() + " has deducted " + items.getItemPoints() + " to your attack damage.");
            System.out.println("---------------------------------------------");

        } else
            System.out.println("This item is not currently equipped.");
    }

    public void heal(String playerInput) {
        if (playerInput.equalsIgnoreCase("HEAL " + items.getItemName()) && playerInventory.contains(items.getItemName())) {
            if (items.getItemType().equalsIgnoreCase("heal")) {
                healingItems.add(items.getItemName());
                playerInventory.remove(items.getItemName());
                playerHealthPoints += items.getItemPoints();
                System.out.println(items.getItemName() + " has been used to heal you.");
                System.out.println("Healing Item Points: " + items.getItemPoints());
                System.out.println("Player Health Points: " + playerHealthPoints);
                System.out.println("The " + items.getItemName() + " has added " + items.getItemPoints() + " to your HP.");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("This item cannot be used to heal.");
            }
        } else {
            System.out.println("This item is not in your inventory.");
        }
    }

    //TODO: ADD PLAYER STATS, ITEM STATS, MONSTER STATS COMMAND
    public void stats(String playerInput) {
        if (playerInput.equalsIgnoreCase("STATS")) {
            System.out.println("-----------------------------------------------------");
            System.out.println("Player Attack Damage: " + playerAttackDamage);
            System.out.println("Player Health Points: " + playerHealthPoints);
            System.out.println("Player Defense Points: " + playerDefensePoints);
            System.out.println("-----------------------------------------------------");
        }

//        if (playerInput.equalsIgnoreCase("ITEM STATS")) {
//            System.out.println("-----------------------------------------------------");
//            System.out.println("Item Attack Damage: " + items.getItemPoints());
//            System.out.println("Item Health Points: " + items.getItemPoints());
//            System.out.println("Item Defense Points: " + items.getItemPoints());
//            System.out.println("-----------------------------------------------------");
//        }
//
//        if (playerInput.equalsIgnoreCase("MONSTER STATS")) {
//            System.out.println("-----------------------------------------------------");
//            System.out.println("Monster Attack Damage: " + monster.getMonsterAttackDamage());
//            System.out.println("Monster Health Points: " + monster.getMonsterHealthPoints());
//            System.out.println("-----------------------------------------------------");
//        }
    }

    private int getItemPoints(String itemName) {
        // Implement logic to retrieve attack points of the item
        items.getItemPoints();
        if (items.getItemType().equalsIgnoreCase("equip")) {
            return items.getItemPoints();
//            calculateTotalDamage();
        } else if (items.getItemType().equalsIgnoreCase("heal")) {
            heal(itemName);
        }
        // Return the attack points of the specified item
        return 0;
    }

    public void examineMonster(String playerInput) {
        if (playerInput.equalsIgnoreCase("EXAMINE")) {
            System.out.println("Monster Name: " + monster.getMonsterName());
            System.out.println("Monster Description: " + monster.getMonsterDescription());
            System.out.println("Monster Attack Damage: " + monster.getMonsterAttack());
        }
    }

    private boolean inCombat = false;

    public void attackMonster(String playerInput) {
        if (playerInput.equalsIgnoreCase("ATTACK")) {
            int totalDamage = calculateTotalDamage();
            System.out.println("You have attacked " + monster.getMonsterName() + " with " + totalDamage + " damage!");
            inCombat = true;

            Scanner scanner = new Scanner(System.in);
            // Loop for turn-based combat
            while (monster.getMonsterHealthPoints() > 0 && playerHealthPoints > 0) {
                // Player's turn
                monster.setMonsterHealthPoints(monster.getMonsterHealthPoints() - totalDamage);
                System.out.println("You have dealt " + totalDamage + " damage to " + monster.getMonsterName() + "!");
                System.out.println("Monster Health: " + monster.getMonsterHealthPoints());
                showCombatOptions(playerInput);
                System.out.println("-----------------------------------------------------");

                // Check if the monster is defeated after the player's attack
                if (monster.isDefeated()) {
                    // Handle the defeated monster scenario
                    System.out.println("You have defeated " + monster.getMonsterName() + "!");
                    defeated();
                    //removeMonsterFromRoom(monster.getMonsterName());
                    break;
                }

                // Monster's turn after player's attack
                monster.monstersTurn(this);

                // Check if the player is defeated after the monster's attack
                if (playerHealthPoints <= 0) {
                    // Handle the defeated player scenario
                    inCombat = false;
                    System.out.println("You have been defeated by " + monster.getMonsterName() + "!");
                    break;
                }

                // Display player's health after monster's attack
                System.out.println("Your health: " + playerHealthPoints);
            }

            inCombat = false; // Exiting combat after the fight
        }
    }

    private void defeated() {
        //System.out.println("Game over! You have been defeated by " + monster.getMonsterName() + "!");
        System.out.println("Would you like to restart the game? Enter 'RESTART' to play again or 'EXIT' to exit:");
        gameOver("");
    }

    private void startNewGame() {
        playerInventory.clear();
        equippedItems.clear();
        ignoredMonsters.clear();
        playerHealthPoints = 100;
        playerAttackDamage = 5;
        playerDefensePoints = 5;
        currentRoom = map.hashMapRooms.get(1);
        previousRoom = null;
        monster = map.hashMapMonsters.get(4);
        puzzle.setPuzzleAttempts(3);
    }

    // Method to quit the game
    private void quitGame() {
        System.out.println("Exiting the game. Goodbye!");
        System.exit(0);
    }

    private void showCombatOptions(String playerInput) {
        //TODO: ADD HEAL
        if (!monster.isMonsterDefeated()) {
            System.out.println("Enter a command: {ATTACK, HEAL}");
            handleCombatActions(playerInput);
        }
    }

    private void handleCombatActions(String playerInput) {
        switch (playerInput.toUpperCase()) {
            case "INVENTORY":
                getCurrentInventory(playerInput);
                break;
            case "EXAMINE":
                examineMonster(playerInput);
                break;
            case "EQUIP":
                equipItem(playerInput);
                break;
            case "UNEQUIP":
                unEquipItem(playerInput);
                break;
            case "IGNORE":
                ignoreMonster(playerInput);
                //System.out.println("You have ignored " + monster.getMonsterName() + "!");
                //inCombat = false; // Exiting combat after ignoring the monster
                break;
//            default:
//                System.out.println("Invalid command.");
        }
    }

    public void ignoreMonster(String playerInput) {
        if (playerInput.equalsIgnoreCase("IGNORE")) {
            if (!ignoredMonsters.contains(monster)) {
                removeMonsterFromRoom(monster.getMonsterName());
                ignoredMonsters.add(monster);
                System.out.println("You have ignored " + monster.getMonsterName() + "!");
            } else {
                System.out.println("You have already ignored " + monster.getMonsterName() + ".");
            }
            inCombat = false; // Exiting combat after ignoring the monster
        }
    }

    private void removeMonsterFromRoom(String monsterName) {
        // Remove monster from the room
        currentRoom.getRoomMonsters().remove(monsterName);
//        addMonsterToPreviousRoom();
    }

    private void addMonsterToPreviousRoom() {
        // Add monster to the previous room only if it's not already there
        if (!previousRoom.getRoomMonsters().contains(monster) && !ignoredMonsters.contains(monster)) {
            previousRoom.getRoomMonsters().add(monster);
        }
    }

    public int calculateTotalDamage() {
        int totalDamage = playerAttackDamage;
        for (String equippedItem : equippedItems) {
            // Get attack points of the equipped item and add to total damage
            int itemPoints = getItemPoints(equippedItem);
            totalDamage += itemPoints;
        }
        return totalDamage;
    }

    public void gameOver(String playerInput) {
        Scanner scanner = new Scanner(System.in);
        playerInput = scanner.nextLine();

        if (playerInput.equalsIgnoreCase("RESTART")) {
            startNewGame();
            System.out.println("You have restarted the game. You are now in " + getCurrentRoom());
        } else if (playerInput.equalsIgnoreCase("EXIT")) {
            quitGame();
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }
//
//    public void saveGame(String playerInput) {
//        if (playerInput.equalsIgnoreCase("SAVE")) {
//            System.out.println("Game saved.");
//        }
//    }
//
//    public void loadGame(String playerInput) {
//        if (playerInput.equalsIgnoreCase("LOAD")) {
//            System.out.println("Game loaded.");
//        }
//    }
}

