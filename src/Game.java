import java.util.Scanner;

public class Game {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    private void startGame() {
        Player player = new Player();
        Room room = new Room();

        String playerInput = "";

        System.out.println("\nWelcome to ~W A S T E L A N D  O D Y S S E Y~\n" +
                "This game is set in a dystopian future where you are fighting for survival. You are a scavenger in a post-apocalyptic world infested with monsters and you must find a way to survive.\n" +
                "You will have to explore the world, solve puzzles, and fight monsters to survive. Good luck!");
        System.out.println("----------------------------------------");
        System.out.println("Enter the following keys to navigate in the game world: NORTH, EAST, SOUTH, WEST");
        System.out.println("Type HELP at any time to see the list of commands.");
        System.out.println("----------------------------------------");
        System.out.println("You are in " + player.getCurrentRoom());
        System.out.println(player.getCurrentRoom().getRoomDescription());

        boolean started = true;

        while (started) {
            if ((player.getCurrentRoom().getRoomID() == player.getPuzzle().getPuzzleRoomID())) {
                System.out.println(player.getPuzzle().getPuzzleDescription());
            } else {
                player.getPuzzle().setPuzzleAttempts(3);
            }
            while ((player.getCurrentRoom().getRoomID() == player.getPuzzle().getPuzzleRoomID()) && player.getPuzzle().getPuzzleAttempts() > -0) {
                playerInput = in.nextLine().toLowerCase();
                player.solvePuzzle(playerInput);
            }

//            if ((player.getCurrentRoom().getRoomID() == player.getMonster().getMonsterRoomID())) {
//                System.out.println(player.getMonster().getMonsterDescription());
//            } else {
//                player.getMonster().setMonsterDefeated(false);
//            }

            playerInput = in.nextLine().toLowerCase();
            //player.updateItems(playerInput);

            if (playerInput.equalsIgnoreCase("HELP")) {
                player.help();
            } else if (playerInput.equalsIgnoreCase("NORTH") ||
                    playerInput.equalsIgnoreCase("SOUTH") ||
                    playerInput.equalsIgnoreCase("EAST") ||
                    playerInput.equalsIgnoreCase("WEST")) {
                player.move(playerInput);
                player.checkIfRoomHasBeenVisited();
            } else if (playerInput.equalsIgnoreCase("MAP")) {
                player.getCurrentRoom().map();
            } else if (playerInput.equalsIgnoreCase("EXIT") || playerInput.equalsIgnoreCase("QUIT")) {
                player.quitGame(playerInput);
            } else if (playerInput.equalsIgnoreCase("PICKUP " + player.getItems().getItemName())) {
                player.pickUpItem(playerInput);
            } else if (playerInput.equalsIgnoreCase("DROP " + player.getItems().getItemName())) {
                player.dropItem(playerInput);
            } else if (playerInput.equalsIgnoreCase("INSPECT " + player.getItems().getItemName())) {
                player.inspectItem(playerInput);
            } else if (playerInput.equalsIgnoreCase("EXPLORE")) {
                player.exploreRoom(playerInput);
            } else if (playerInput.equalsIgnoreCase("INVENTORY")) {
                player.getCurrentInventory(playerInput);
            } else if (playerInput.equalsIgnoreCase("EQUIP " + player.getItems().getItemName())) {
                player.equipItem(playerInput);
            } else if (playerInput.equalsIgnoreCase("UNEQUIP " + player.getItems().getItemName())) {
                player.unEquipItem(playerInput);
            } else if (playerInput.equalsIgnoreCase("HEAL " + player.getItems().getItemName())) {
                player.heal(playerInput);
            } else if (playerInput.equalsIgnoreCase("IGNORE")) {
                player.ignoreMonster(playerInput);
            } else if (playerInput.equalsIgnoreCase("EXAMINE")) {
                player.examineMonster(playerInput);
            } else if (playerInput.equalsIgnoreCase("ATTACK")) {
                player.attackMonster(playerInput);
            } else if (playerInput.equalsIgnoreCase("STATS")) {
                player.stats(playerInput);
            } else if (playerInput.equalsIgnoreCase("RESTART")) {
                player.gameOver(playerInput);
//            } else if (playerInput.equalsIgnoreCase("SAVE")) {
//                player.saveGame(playerInput);
//            } else if (playerInput.equalsIgnoreCase("LOAD")) {
//                player.loadGame(playerInput);
            } else if ((!playerInput.equalsIgnoreCase(player.getPuzzle().getPuzzleAnswer()))) {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}

