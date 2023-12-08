This program is a text-based adventure game that utilizes an interactive world based upon user input to the console.
It reads the data from a text file name "TextGame3.Map.txt" and creates an array of rooms.
The user can move from room to room and interact with the world.

**Rooms***
The Rooms.txt has four elements per room:
1. roomID (unique identifier) assigned to each room (1-6)
2. checkedRoom (boolean value that determines if the room has been visited)
3. roomName (name of the room)
    a) 1 - Inside Safe House
    b) 2 - Outside Safe House
    c) 3 - Street
    d) 4 - Forest
    e) 5 - Abandoned Store
    f) 6 - Bridge
4. roomDescription (description of the room)

**Navigation**
The user can move from room to room by typing in the direction they want to go.
The connections determine the possible pathways a player can take, and where they can navigate.
TextGame3.Room Connections are defined by the following and the map is displayed below
1. North
2. East
3. South
4. West

------------------------
|     x     |     x     |
| x   1  E  | W   6   x |
|     S     |     S     |
------------------------
|     N     |    N      |
| x   2  E  |    3    x |
|     S     |    S      |
------------------------
|     N     |    N      |
| x   4  E  |    5    x |
|     x     |    x      |
------------------------

**Commands**
It also reads the data from a text file name "TextGame3.Items.txt" and creates an array of items.
The user can interact with the world by typing in the following commands:

The user can pick up items by typing in the item name.
The user can drop items by typing in the item name.
The user can inspect items by typing in the item name.
The user can view their inventory by typing in "inventory".
The user can view the help menu by typing in "help".
The user can quit the game by typing in "exit" or "quit".
The user can explore the room by typing in "explore.
The user can examine the monster in the room by typing in "examine".
The user can equip an item by typing in "equip".
The user can unequip an item by typing in "unequip".
The user can view their stats by typing in "stats".

**TextGame3.Items**
The TextGame3.Items.txt has four elements per item:
1. itemID (unique identifier) assigned to each item (1-6)
2. checkedItem (boolean value that determines if the item has been picked up)
3. itemName (name of the item)
    a) 1 - Key
    b) 2 - Flashlight
    c) 3 - Knife
    d) 4 - Gun
    e) 5 - Rope
    f) 6 - TextGame3.Map
4. itemDescription (description of the item)

**TextGame3.Puzzles**
The puzzles.txt file has four elements per puzzle:
1. puzzleID (unique identifier)
2. puzzleDescription (description of the puzzle)
3. puzzleAnswer (answer to the puzzle)
5 puzzleCorrect (boolean value that determines if the puzzle has been answered correctly)
6. puzzleWrong (description of the puzzle if answered incorrectly)
7. puzzleAttempts (number of attempts the user has to answer the puzzle)
8. puzzleStatus (boolean value that determines if the puzzle has been solved)

**TextGame3.Monsters**
The text file has four elements per monster:
1. monsterID (unique identifier) assigned to each monster (1-6)
2. monsterName (name of the monster)
    1) Zombie
3. monsterDescription (description of the monster)
4. monsterAttack (attack value of the monster)