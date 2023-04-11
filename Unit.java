public abstract class Unit {
    /**
     * <h1>Lab5</h1>
     * <h2>Cisc 181-010L Spring 2023</h2>
     * <h3>University of Delaware</h3>
     * This is an abstract superclass that includes the similarities between
     * BartSimpsonUnit and TomJerryUnit and is extended by both of those classes
     *
     * @authors Brendon Uzoigwe, Zachary Villamor, Christopher Sullivan
     * @since 2023-04-09
     */


    //properties that were in TomJerry and BartSimpson
    protected char symbol;
    protected String name;
    protected double health;
    protected double healthModifier;
    protected double damage;
    protected double damageModifier;
    protected int luck;
    protected int xCor;
    protected int yCor;
    protected int movement;
    protected int movementModifier;
    protected String teamColor;
    protected int spawn;
    protected int numTimesSpawned;


    //multiple parameter constructor
    public Unit(char symbol,String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor){
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
        this.teamColor = teamColor;

    }

    //no parameter constructor to set the values
    public Unit(){this('C', "character", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "Red");}

   //getter methods
    public char getSymbol(){return this.symbol;}
    public String getName(){return this.name;}
    public double getHealth(){return this.health;}
    public double getHealthModifier(){return this.healthModifier;}

    public double getDamage() {return this.damage;}

    public double getDamageModifier() {return this.damageModifier;}
    public int getLuck(){return this.luck;}
    public int  getXCor(){return this.xCor;}
    public int getYCor(){return this.yCor;}
    public int getMovement(){return this.movement;}
    public int getMovementModifier(){return this.movementModifier;}
    public String getTeamColor(){return this.teamColor;}
    public int getSpawn(){return this.spawn;}


    //setter methods
    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public void setHealth(double newHealth) {
        this.health = newHealth;
    }

    public void setHealthModifier(double newHealthModifier) {
        this.healthModifier = newHealthModifier;
    }

    public void setDamage(double newDamage) {
        this.damage = newDamage;
    }

    public void setDamageModifier(double newDamageModifier) {
        this.damageModifier = newDamageModifier;
    }

    public void setLuck(int newLuck) {
        this.luck = newLuck;
    }

    public void setXCor(int newXCor) {
        this.xCor = newXCor;
    }

    public void setYCor(int newYCor) {
        this.yCor = newYCor;
    }

    public void setMovement(int newMovement) {
        this.movement = newMovement;
    }

    public void setMovementModifier(int newMovementModifier) {
        this.movementModifier = newMovementModifier;
    }
    public void setTeamColor(String newTeamColor){this.teamColor = newTeamColor;}

    //abstract spawn method that is used in BartSimpson
    public abstract Unit spawn();

    //toString override to display the team color and symbol
    @Override
    public String toString() {
        return this.teamColor + " " + this.symbol;
    }
}
