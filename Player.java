import java.util.ArrayList;
public class Player {
    /**
     * <h1>Lab5</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     * This is a class that represents each player in the game
     *
     * @author Brendon Uzoigwe, Zachary Villamor, Christopher Sullivan
     * @since 2023-04-09
     */

    // Represents player number
    private int playerNumber;
    // Says if it is the player's turn
    private boolean turn;
    // Game piece team
    private Team team;

    // Accessor method
    public int getPlayerNumber() {
        return playerNumber;
    }

    // Mutator method
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    // Accessor method
    public boolean isTurn() {
        return turn;
    }

    // Mutator method
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    // Accessor method
    public Team getPlayersTeam() {
        return team;
    }

    // Mutator method
    public void setPlayersTeam(Team team) {
        this.team = team;
    }

    // 3 parameter constructor
    public Player(int playerNumber, boolean turn, Team team) {
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
    }

    // 2 parameter constructor
    public Player(int playerNumber, Team team) {
        this.playerNumber = playerNumber;
        this.turn = false;
        this.team = team;
    }

    // No parameter constructor
    public Player() {
        this.playerNumber = 1;
        this.turn = false;
        this.team = new Team("blue", new ArrayList<Unit>());
    }
}
