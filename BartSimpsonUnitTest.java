import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class BartSimpsonUnitTest {
    @Test
    public void testingBartSimpsonNoParameterConstructor() {
        System.out.println("Creating Bart Simpson with 0 parameter constructor");

        BartSimpsonUnit bs = new BartSimpsonUnit();

        System.out.println();
        System.out.println("-- Testing Getters");
        System.out.println();

        System.out.println("-- Testing Symbol");
        assertEquals('B', bs.getSymbol());

        System.out.println("-- Testing Name");
        assertEquals("Bart Simpson", bs.getName());

        System.out.println("-- Testing Health");
        assertEquals(100.0, bs.getHealth(), 0.0001);

        System.out.println("-- Testing numTimesSpawned");
        assertEquals(0, bs.getNumTimesSpawned());

        System.out.println("-- Testing distract");
        assertTrue(bs.isDistract());

        System.out.println("-- Testing recruit");
        assertTrue(bs.canRecruit());
    }


    @org.junit.Test
    public void testingBartSimpsonParameterConstructor() {
        System.out.println("Creating Bart Simpson with 14 parameter constructor");
        BartSimpsonUnit bs = new BartSimpsonUnit('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0, true, true, "blue");

        System.out.println("-- Testing Health Modifier");
        assertEquals(0.0, bs.getHealthModifier(), 0.0001);
        System.out.println("-- Testing Damage");
        assertEquals(25.0, bs.getDamage(), 0.0001);
        System.out.println("-- Testing Damage Modifier");
        assertEquals(0.0, bs.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Luck");
        assertEquals(0, bs.getLuck());
        System.out.println("-- Testing xCor");
        assertEquals(5, bs.getXCor());
        System.out.println("-- Testing yCor");
        assertEquals(5, bs.getYCor());
        System.out.println("-- Testing Movement");
        assertEquals(1, bs.getMovement());
        System.out.println("-- Testing Movement Modifier");
        assertEquals(0, bs.getMovementModifier());
        System.out.println("-- Testing Symbol");
        bs.setSymbol('B');
        assertEquals('B', bs.getSymbol());
        System.out.println("-- Testing Damage Modifier");
        bs.setDamageModifier(7.0);
        assertEquals(7.0, bs.getDamageModifier(), 0.0001);
        System.out.println("-- Testing Recruit");
        bs.setRecruit(true);
        assertTrue(bs.canRecruit());
        System.out.println("-- Testing Distract");
        bs.setDistract(true);
        assertTrue(bs.isDistract());

    }
    @Test
    public void test_spawn() {
        System.out.println("Testing spawn");
        // create a BartSimpsonUnit and call its spawn method
        BartSimpsonUnit bart = new BartSimpsonUnit();
        // bart should be able to spawn
        assertTrue(bart.canSpawn());
        // bart spawns
        BartSimpsonUnit lilBart = bart.spawn();
        // Number of times piece has spawned should be increased
        assertEquals(1, bart.getNumTimesSpawned());
        // Now that max time number of spawns reached - it
        // shouldn't be able to spawn anymore
        assertFalse(bart.canSpawn());

    }


}
