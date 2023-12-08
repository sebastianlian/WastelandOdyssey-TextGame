public class Monsters {
    private int monsterRoomID = 0;
    private String monsterName = "";
    private String monsterDescription = "";
    private int monsterAttack = 0;
    private boolean monsterDefeated = false;
    private int monsterAttackDamage;
    private int monsterHealthPoints;

    public Monsters(int monsterRoomID, String monsterName, String monsterDescription,
                    int monsterAttack, boolean monsterDefeated) {
        this.monsterRoomID = monsterRoomID;
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
        this.monsterAttack = monsterAttack;
        this.monsterDefeated = monsterDefeated;
        this.monsterAttackDamage = 5;
        this.monsterHealthPoints = 25;
    }

    public int getMonsterRoomID() {
        return monsterRoomID;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public String getMonsterDescription() {
        return monsterDescription;
    }

    public boolean isMonsterDefeated() {
        return monsterDefeated;
    }

    public int getMonsterAttack() {
        return monsterAttack;
    }

    public void setMonsterAttack(int monsterAttack) {
        this.monsterAttack = monsterAttack;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public void setMonsterDescription(String monsterDescription) {
        this.monsterDescription = monsterDescription;
    }

    public void setMonsterRoomID(int monsterRoomID) {
        this.monsterRoomID = monsterRoomID;
    }

    public void setMonsterDefeated(boolean monsterDefeated) {
        this.monsterDefeated = monsterDefeated;
    }

    public int getMonsterAttackDamage() {
        return monsterAttackDamage;
    }

    public void setMonsterAttackDamage(int monsterAttackDamage) {
        this.monsterAttackDamage = monsterAttackDamage;
    }

    public int getMonsterHealthPoints() {
        return monsterHealthPoints;
    }

    public void setMonsterHealthPoints(int monsterHealthPoints) {
        this.monsterHealthPoints = monsterHealthPoints;
    }

    public boolean isDefeated() {
        return this.monsterHealthPoints <= 0;
    }

    public void monstersTurn(Player player) {
        int monsterAttackDamage = getMonsterAttackDamage();
        System.out.println("The " + this.monsterName + " attacks you for " + this.monsterAttackDamage + " damage!");
        player.setPlayerHealthPoints(player.getPlayerHealthPoints() - monsterAttackDamage);
    }
}