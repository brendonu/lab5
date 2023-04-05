import java.util.Random;
public class GameBoard {
    private int numRows;
    private int numColumns;
    private BoardSquare[][] squares;

    public GameBoard(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        squares = new BoardSquare[numRows][numColumns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public BoardSquare[][] getSquares() {
        return this.squares;
    }

    public boolean inBounds(int rowIndex, int columnIndex) {
        if (((rowIndex < 0) || (this.numRows < rowIndex + 1)) || ((columnIndex < 0) || (this.numColumns < columnIndex + 1))) {
            return false;
        }
        else {
            return true;
        }
    }

    private void setUpEmptyBoard() {
        int row;
        int column;
        String color;
        for (row = 0; row < this.numRows; row++ ) {
            for (column = 0; column < this.numColumns; column++) {
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

    public BoardSquare findRandomEmptySpace() {
        Random rand = new Random();
        int row;
        int column;
        int intRowIndex = 0;
        int intColumnIndex = 0;
        while (this.squares[intRowIndex][intColumnIndex].isEmpty() != true) {
            double doubleRowIndex = Math.random() * this.numRows - 1;
            intRowIndex = (int)doubleRowIndex;
            double doubleColumnIndex = Math.random() * this.numColumns - 1;
            intColumnIndex = (int)doubleColumnIndex;
        }
        return this.squares[intRowIndex][intColumnIndex];
    }

    public String toString() {
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
