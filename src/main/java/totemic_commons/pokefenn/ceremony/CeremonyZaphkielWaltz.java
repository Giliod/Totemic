package totemic_commons.pokefenn.ceremony;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.api.ceremony.Ceremony;
import totemic_commons.pokefenn.api.music.MusicInstrument;
import totemic_commons.pokefenn.util.EntityUtil;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class CeremonyZaphkielWaltz extends Ceremony
{

    public CeremonyZaphkielWaltz(String modid, String name, int musicNeeded, int maxStartupTime, int effectTime,
            int musicPer5, MusicInstrument... instruments)
    {
        super(modid, name, musicNeeded, maxStartupTime, effectTime, musicPer5, instruments);
    }

    @Override
    public void effect(World world, BlockPos pos)
    {
        int radius = 6;

        if(!world.isRemote && world.getTotalWorldTime() % 20L == 0)
        {
            for(Entity entity : EntityUtil.getEntitiesInRange(world, pos, radius, radius))
            {
                if(entity instanceof EntityItem)
                {
                    EntityItem item = (EntityItem)entity;
                    if(item.getEntityItem().getItem() == Items.egg)
                    {
                        if(world.rand.nextInt(4) == 0)
                        {
                            EntityChicken chicken = new EntityChicken(world);
                            chicken.setPosition(entity.posX, entity.posY, entity.posZ);
                            world.spawnEntityInWorld(chicken);
                            if(item.getEntityItem().stackSize == 1)
                                item.setDead();
                            else
                            {
                                ItemStack stack = item.getEntityItem().copy();
                                stack.stackSize--;
                                item.setEntityItemStack(stack);
                            }
                        }
                    }
                }
            }
        }

        if(world.getTotalWorldTime() % 5L == 0)
        {
            for(int i = -radius; i <= radius; i++)
                for(int j = -radius; j <= radius; j++)
                    for(int k = -radius; k <= radius; k++)
                    {
                        BlockPos p = pos.add(i, j, k);
                        IBlockState s = world.getBlockState(p);
                        if(s.getBlock() == Blocks.sapling)
                        {
                            world.setBlockState(p, ModBlocks.totemSapling.getDefaultState(), 3);
                            spawnParticles(world, p.getX() + 0.5, p.getY() + 0.5, p.getZ() + 0.5);
                        }
                        else if(s.getBlock() instanceof IGrowable && s.getBlock().getTickRandomly())
                        {
                            if(world.rand.nextInt(4) == 0)
                            {
                                if(!world.isRemote)
                                    s.getBlock().updateTick(world, p, world.getBlockState(p), world.rand);
                                spawnParticles(world, p.getX() + 0.5, p.getY() + 0.5, p.getZ() + 0.5);
                            }
                        }
                    }
        }
    }

    private void spawnParticles(World world, double x, double y, double z)
    {
        if(world.isRemote)
        {
            double dx = world.rand.nextGaussian();
            double dy = world.rand.nextGaussian() * 0.5;
            double dz = world.rand.nextGaussian();
            double velY = world.rand.nextGaussian();
            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x + dx, y + dy, z + dz, 0, velY, 0);
        }
    }
}
