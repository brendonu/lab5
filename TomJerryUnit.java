import java.util.Random;

public class TomJerryUnit extends Unit{
    /*
     * <h1>Lab3</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     *
     *This is a class that represents the abilities  and attributes of the game piece
     * Tom & Jerry in our game
     *
     * @author Brendon Uzoigwe
     * @since 2023-03-07
     */

    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;

/**
 * This method allows the private properties to be used
 * @param symbol a char that represents the first letter of the piece's name
 * @param name the pieces name
 * @param health the health the piece starts with
 * @param healthModifier changes to the health of the piece
 * @param damage the amount of damage the piece does
 * @param damageModifier changes to the damage the piece does
 * @param luck random luck mechanism
 * @param xCor coordinate on the x-axis
 * @param yCor coordinate on the y-axis
 * @param movement how much the unit can move
 * @param movementModifier changes to how much the unit can move
 * @param homingRocket can use a homing rocket
 * @param offerCheese can offer cheese
 * @param hiding is the unit hidden
 * */
    public TomJerryUnit(char symbol,String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor){
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }


    /**
     * This method has no parameters and sets all the fields equal to something
     */
    public TomJerryUnit(){this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "Blue");}

    //accessor methods for the fields

    public boolean isHomingRocket() {return this.homingRocket;}
    public boolean isOfferCheese() {return this.offerCheese;}

    public boolean isHiding() {return this.hiding;}

    //mutator methods for the fields


    public void setHomingRocket(boolean newHomingRocket) {
        this.homingRocket = newHomingRocket;
    }

    public void setOfferCheese(boolean newOfferCheese) {
        this.offerCheese = newOfferCheese;
    }

    public void setHiding(boolean newHiding) {
        this.hiding = newHiding;
    }

//calculates damage dealt to others
    public double dealDamage(){
        double totalDamage = damage + damageModifier;
        //makes the total damage go up by ten if the homing rocket is used
        if(isHomingRocket() == true){
            totalDamage += 10;
        }
        return totalDamage;
    }

    //calculates damage taken
    public void takeDamage( double damage){
        //makes it so that health is not lost when piece is hiding
        if (isHiding() == true){
            health = health;
        }
        else{
            health = health - damage;
        }
    }

    public TomJerryUnit spawn() {
        TomJerryUnit newTom = new TomJerryUnit('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "Blue");
        //updates number of spawns by the unit
        numTimesSpawned += 1;
        return newTom;
    }
}
