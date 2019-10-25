import fakes.FakeTarget;
import fakes.FakeWeapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_test.Hero;
import rpg_test.Target;
import rpg_test.Weapon;

public class HeroTest {

    @Test
    public void shouldReceiveXpWhenTargetDies(){
       Hero hero =  new Hero(new FakeWeapon(),"Name");
        Target target = new FakeTarget();
        hero.attack(target);

        Assert.assertEquals(hero.getExperience(),target.giveExperience());
    }

    @Test
    public void shouldGetLootAfterTargetKill(){
        Weapon loot = new FakeWeapon();
        Hero hero = new Hero(new FakeWeapon(),"Name");
        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(loot);

        hero.attack(target);

        Assert.assertEquals(loot,hero.getInventory().get(0));
    }
}
