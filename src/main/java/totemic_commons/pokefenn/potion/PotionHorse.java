package totemic_commons.pokefenn.potion;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 08/03/14
 * Time: 18:00
 */
public class PotionHorse extends Potion
{

    public PotionHorse()
    {
        super(new ResourceLocation("totemic:horse"), false, 0x614C07);
        setPotionName("totemic.potion.horse");
        setIconIndex(0, 0);
    }

}
