import java.util.ArrayList;
import java.util.Collections;
/**
 * <h1>Lab5</h1>
 * <h2>Cisc 181-010L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * This is a class that displays the game: showing the game board, each teams units,
 * and who's turn it is
 *
 *
 * @author Brendon Uzoigwe, Zachary Villamor, Christopher Sullivan
 * @since 2023-04-09
 */

public class Game {
    //properties for the game
    private GameBoard board;
    private Player player1;
    private Player player2;

    //method that creates a game board and sets both teams up randomly on the board
    private GameBoard initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
        //sets the board for player 1
        ArrayList<Unit> player1Unit = this.player1.getPlayersTeam().getTeamUnits();
        BoardSquare emptySquare = this.board.findRandomEmptySpace();
        for (Unit aUnit : player1Unit) {
            emptySquare.setUnit(aUnit);
            emptySquare = this.board.findRandomEmptySpace();
        }
        //sets the board for player 2
        ArrayList<Unit> player2Unit = this.player2.getPlayersTeam().getTeamUnits();
        BoardSquare emptySquare2 = this.board.findRandomEmptySpace();
        for (Unit aUnit : player2Unit) {
            emptySquare2.setUnit(aUnit);
            emptySquare2 = this.board.findRandomEmptySpace();
        }
        return this.board;
    }

    //four parameter constructor that sets both players and initializes a game board
    public Game(int numRows, int numColumns, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(numRows, numColumns);
    }

    //getter methods
    public GameBoard getBoard() {
        return this.board;
    }
    public Player getCurrentPlayer() {
        //returns whose turn it is
        if (this.player1.isTurn()) {
            return this.player1;
        }
        else {
            return this.player2;
        }
    }
    public Player getOpponentPlayer() {
        //return whose turn it isn't
        if (!(this.player1.isTurn())) {
            return this.player1;
        }
        else {
            return this.player2;
        }
    }
    public boolean isTurn(Player player) {
        //returns whether it is the player's turn
        if (player.isTurn()) {
            return true;
        }
        else {
            return false;
        }
    }
    public BoardSquare[][] getBoardSquares() {
        return this.board.getSquares();
    }
    
    //mutator that changes whose turn it is
    public void changeTurn() {
        if (this.player1.isTurn() == true) {
            this.player1.setTurn(false);
            this.player2.setTurn(true);
        }
        else {
            this.player1.setTurn(true);
            this.player2.setTurn(false);
        }
    }
    
    //toString method for the game

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

}
