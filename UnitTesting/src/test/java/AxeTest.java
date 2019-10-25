import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_test.Axe;
import rpg_test.Dummy;

public class AxeTest {
    private Axe axe;
    private Dummy dummy;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE= 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY -1;

    @Before
    public void setUp(){
        axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH,DUMMY_EXPERIENCE);
    }

    @Test
    public void axeShouldLoseDurabilityAfterAttack(){
        axe.attack(dummy);
        Assert.assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeShouldThrowIfNegativeDurability(){
        Axe axe = new Axe(AXE_ATTACK,-AXE_DURABILITY);
        axe.attack(dummy);

    }
}
