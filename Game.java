import java.util.ArrayList;
import java.util.Collections;
public class Game {
    private GameBoard board;
    private Player player1;
    private Player player2;

    private GameBoard initializeGameBoard(int numRows, int numColumns) {
        this.board = new GameBoard(numRows, numColumns);
        ArrayList<Unit> player1Unit = this.player1.getPlayersTeam().getTeamUnits();
        BoardSquare emptySquare = this.board.findRandomEmptySpace();
        for (Unit aUnit : player1Unit) {
            emptySquare.setUnit(aUnit);
            emptySquare = this.board.findRandomEmptySpace();
        }
        ArrayList<Unit> player2Unit = this.player2.getPlayersTeam().getTeamUnits();
        BoardSquare emptySquare2 = this.board.findRandomEmptySpace();
        for (Unit aUnit : player2Unit) {
            emptySquare2.setUnit(aUnit);
            emptySquare2 = this.board.findRandomEmptySpace();
        }
        return this.board;
    }

    public Game(int numRows, int numColumns, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(numRows, numColumns);
    }

    public GameBoard getBoard() {
        return this.board;
    }
    public Player getCurrentPlayer() {
        if (this.player1.isTurn()) {
            return this.player1;
        }
        else {
            return this.player2;
        }
    }
    public Player getOpponentPlayer() {
        if (!(this.player1.isTurn())) {
            return this.player1;
        }
        else {
            return this.player2;
        }
    }
    public boolean isTurn(Player player) {
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
