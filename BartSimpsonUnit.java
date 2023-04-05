public class BartSimpsonUnit extends Unit{
    /*
     * <h1>Lab3</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     *
     * This is a class that represents the abilities and attributes of the game piece
     * Bart Simpson in our game.
     *
     * @author Brendon Uzoigwe
     * @since 2023-03-07
     */
    private boolean distract;
    private boolean recruit;

    final static int MAX_NUM_SPAWNED = 1;

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
 * @param numTimesSpawned amount of times a new peace has been spawned
 * @param distract can the piece use distract
 * @param recruit can the piece recruit other pieces
  **/
    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numTimesSpawned, boolean distract, boolean recruit, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;

    }

    /**
     * This method has no parameters and sets all the fields equal to something
     */
    public BartSimpsonUnit() {
        this('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0, true, true, "Blue");
    }

    //accessor methods for the fields


    public int getNumTimesSpawned() {
        return numTimesSpawned;
    }

    public boolean isDistract() {
        return distract;
    }

    public boolean canRecruit() {
        return recruit;
    }

    public boolean canSpawn() {
        boolean spawn = false;
        //allows only pieces that are original and haven't reached the max number of spawns to spawn new pieces
        if (symbol == 'B' && numTimesSpawned < MAX_NUM_SPAWNED) {
            spawn = true;
        }

        return spawn;
    }

    //mutator methods for the fields


    public void setNumTimesSpawned(int newNumTimesSpawned){
        this.numTimesSpawned = newNumTimesSpawned;
    }

    public void setDistract(boolean newDistract) {
        this.distract = newDistract;
    }

    public void setRecruit(boolean newRecruit) {
        this.recruit = newRecruit;
    }

    public void distracted(){
        if (distract){
            System.out.println("Unit Distracted!");
        }
    }

    public BartSimpsonUnit spawn(){
        BartSimpsonUnit newBart = new BartSimpsonUnit('b', "Bart Simpson", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, 0, true, true, "Blue");
        //updates number of spawns by the unit
        numTimesSpawned += 1;
        return newBart;
    }

}


