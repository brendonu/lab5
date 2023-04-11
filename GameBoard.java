import java.lang.Math;
public class GameBoard {
    /**
     * <h1>Lab5</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     * This class creates the board that the game will be played on
     *
     * @author Brendon Uzoigwe, Zachary Villamor, Christopher Sullivan
     * @since 2023-04-09
     */

    //properties for the board
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    //constructor that sets numRows and numColumns and creates a new 2d array
    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    //getter methods
    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        return this.squares;
    }


    //method that determines if the location of the space is in the boundaries of the board
    public boolean inBounds(int rowIndex, int columnIndex) {
        if (((rowIndex < 0) || (this.numRows < rowIndex + 1)) || ((columnIndex < 0) || (this.numColumns < columnIndex + 1))) {
            return false;
        }
        else {
            return true;
        }
    }

    //method that sets up the board with alternating black and white squares
    private void setUpEmptyBoard() {
        int row;
        int column;
        String color;
        for (row = 0; row < this.numRows; row++ ) {
            for (column = 0; column < this.numColumns; column++) {
                //sets even spaces to black and odd spaces to white
                if (((row + column) % 2) == 0) {
                    color = "black";
                }
                else {
                    color = "white";
                }
                this.squares[row][column] = new BoardSquare(color);
            }
        }
    }

    //method that generates the location of a random space and returns it if the space is empty, if not then it keeps looking until it finds an empty one
    public BoardSquare findRandomEmptySpace(){
        double randRow = Math.random() * this.numRows - 1;
        double randColumn = Math.random() * this.numColumns - 1;
        int randRow2 = (int)randRow;
        int randColumn2 = (int)randColumn;
        BoardSquare emptySpace = squares[randRow2][randColumn2];
        while(!squares[randRow2][randColumn2].isEmpty()) {
            randRow = Math.random() * this.numRows - 1;
            randColumn = Math.random() * this.numColumns - 1;
            randRow2 = (int)randRow;
            randColumn2 = (int)randColumn;
            emptySpace = squares[randRow2][randColumn2];
        }
        return emptySpace;

        }
    //toString method for the game board
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }







}
