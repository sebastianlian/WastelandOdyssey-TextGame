public class Puzzles {
    private int puzzleRoomID = 0;
    private String puzzleDescription = "";
    private String puzzleAnswer = "";
    private String puzzleCorrect = "";
    private String puzzleWrong = "";
    private int puzzleMaxAttempts = 0;
    private Boolean puzzleSolved = false;

//    Puzzles() {
//    }

    public Puzzles(int puzzleRoomID, String puzzleDescription, String puzzleAnswer, String puzzleCorrect,
                   String puzzleWrong, int puzzleMaxAttempts,
                   Boolean puzzleSolved) {
        this.puzzleRoomID = puzzleRoomID;
        this.puzzleDescription = puzzleDescription;
        this.puzzleAnswer = puzzleAnswer;
        this.puzzleCorrect = puzzleCorrect;
        this.puzzleWrong = puzzleWrong;
        this.puzzleMaxAttempts = puzzleMaxAttempts;
        this.puzzleSolved = puzzleSolved;
    }

    public int getPuzzleRoomID() {
        return puzzleRoomID;
    }

//    public void setPuzzleRoomID(int roomID) {
//        this.puzzleRoomID = roomID;
//    }

    public String getPuzzleAnswer() {
        return puzzleAnswer;
    }

    public void setPuzzleAnswer(String puzzleAnswer) {
        this.puzzleAnswer = puzzleAnswer;
    }

    public String getPuzzleDescription() {
        return puzzleDescription;
    }

//    public void setPuzzleDescription(String puzzleDescription) {
//        this.puzzleDescription = puzzleDescription;
//    }
//
//    public String getPuzzleAnsweredCorrectlyMsg() {
//        return puzzleCorrect;
//    }

//    public void setPuzzleAnsweredCorrectlyMsg(String puzzleCorrect) {
//        this.puzzleCorrect = puzzleCorrect;
//    }
//
//    public String getPuzzleNotAnsweredCorrectlyMsg() {
//        return puzzleWrong;
//    }
//
//    public void setPuzzleNotAnsweredCorrectlyMsg(String puzzleWrong) {
//        this.puzzleWrong = puzzleWrong;
//    }

    public int getPuzzleAttempts() {
        return puzzleMaxAttempts;
    }

    public void setPuzzleAttempts(int puzzleMaxAttempts) {
        this.puzzleMaxAttempts = puzzleMaxAttempts;
    }

//    public Boolean getPuzzleSolvedStatus() {
//        return puzzleSolved;
//    }
//
//    public void setPuzzleSolvedStatus(Boolean puzzleSolved) {
//        this.puzzleSolved = puzzleSolved;
//    }

    // method used to check user input for puzzle
    public void checkPlayersAnswer(String playerInput) {
        if (!(playerInput.equals(puzzleAnswer))) {
            puzzleMaxAttempts--;
            System.out.println(puzzleWrong + "You have " + puzzleMaxAttempts + "left.");

            if (puzzleMaxAttempts == 0 && !puzzleSolved) {
                System.out.println("Maximum attempt reached. Puzzle will reset upon re-entering.");
            }

        } else {
            System.out.println(puzzleCorrect);
            puzzleSolved = true;
            puzzleRoomID = 0;
        }
    }
}
