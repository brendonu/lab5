public class BoardSquare {
    /**
     * <h1>Lab5</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     * This is a class that represents each square on the game board
     *
     * @author Brendon Uzoigwe, Zachary Villamor, Christopher Sullivan
     * @since 2023-04-09
     */

    //properties of board square
    private boolean empty;
    private Unit unit;
    private String squareColor;

    //constructor that accepts color
    public BoardSquare(String squareColor){
        this.squareColor = squareColor;
        this.empty = true;
    }

    //getter methods
    public Unit getUnit(){
        return this.unit;
    }
    public boolean isEmpty(){
        return this.empty;
    }
    public String getSquareColor(){
        return this.squareColor;
    }

    //mutator to set Unit and update empty
    public void setUnit(Unit unit) {
        this.unit = unit;
        this.empty = false;
    }

    //mutator that returns the unit on the square and updates the unit to null
    public Unit removeUnit(){
        Unit tempUnit = this.unit;
        this.unit = null;
        this.empty = true;
        return tempUnit;
    }

    //toString override based on whether the square is empty or not
    @Override
    public String toString() {
        if (this.empty == true){
            return "-------";
        }
        else{
            return "-" + this.unit + "-";
        }
    }

}
