import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_test.Dummy;

public class DummyTest {
    private static final int BASE_HP = 10;
    private static final int BASE_XP = 10;
    private static final int BASE_ATTACK = 10;
    private Dummy aliveDummy;
    private Dummy deadDummy;


    @Before
    public void beforeEach() {
        this.aliveDummy = new Dummy(BASE_HP, BASE_XP);
        this.deadDummy = new Dummy(-BASE_HP, BASE_XP);
    }

    @Test
    public void shouldLoseHealthWhenAttacked() {
        this.aliveDummy.takeAttack(BASE_ATTACK);

        Assert.assertEquals("Dummy health is not correct after attack",
                BASE_HP - BASE_ATTACK, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenDeadOnAttack() {
        this.deadDummy.takeAttack(BASE_ATTACK);
    }

    @Test()
    public void shouldGiveExperienceIfDead() {
//        Dummy mocked = Mockito.mock(Dummy.class);
//        Mockito.when(mocked.giveExperience()).thenReturn(BASE_XP);
        this.deadDummy = new Dummy(-BASE_HP, BASE_XP);
        int actual = deadDummy.giveExperience();

        Assert.assertEquals(BASE_XP, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfGettingExperienceOnAlive() {
        this.aliveDummy.giveExperience();
    }
}
