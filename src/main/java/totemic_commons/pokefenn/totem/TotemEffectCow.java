package totemic_commons.pokefenn.totem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import totemic_commons.pokefenn.Totemic;
import totemic_commons.pokefenn.api.totem.TotemBase;
import totemic_commons.pokefenn.api.totem.TotemEffect;
import totemic_commons.pokefenn.util.EntityUtil;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class TotemEffectCow extends TotemEffect
{

    public TotemEffectCow(String name, int horizontal, int vertical)
    {
        super(name, horizontal, vertical);
    }

    @Override
    public void effect(World world, BlockPos pos, TotemBase totem, int repetition, int horizontal, int vertical)
    {
        if(world.isRemote)
            return;

        if(world.getTotalWorldTime() % 60L == 0)
        {
            for(EntityPlayer entity : EntityUtil.getEntitiesInRange(EntityPlayer.class, world, pos, horizontal, vertical))
            {
                Totemic.api.totemEffect().addPotionEffect(entity, Potion.resistance, 50, 1, totem, repetition);
                Totemic.api.totemEffect().addPotionEffect(entity, Potion.moveSlowdown, 150, 0, totem, repetition);
            }
        }
    }

}