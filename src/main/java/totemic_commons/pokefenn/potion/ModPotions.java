package totemic_commons.pokefenn.potion;

import net.minecraft.potion.Potion;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 28/02/14
 * Time: 15:48
 */
public class ModPotions
{
    public static Potion batPotion;
    public static Potion horsePotion;
    public static Potion spiderPotion;

    public static void init()
    {
        batPotion = new PotionBat();
        horsePotion = new PotionHorse();
        spiderPotion = new PotionSpider();
    }
}
