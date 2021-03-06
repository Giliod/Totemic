package totemic_commons.pokefenn.block.tipi;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.lib.Strings;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class BlockDummyTipi extends Block
{
    public BlockDummyTipi()
    {
        super(Material.cloth);
        setUnlocalizedName(Strings.DUMMY_TIPI_NAME);
        setHardness(0.2F);
        setStepSound(soundTypeCloth);
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        //find main Tipi block
        int range = 1;
        int height = 5;
        for(int i = -range; i <= range; i++)
            for(int j = 0; j >= -height; j--) //search downwards
                for(int k = -range; k <= range; k++)
                {
                    BlockPos p = pos.add(i, j, k);
                    IBlockState s = world.getBlockState(p);
                    if(s.getBlock() == ModBlocks.tipi)
                    {
                        BlockDummyTipi.breakTipi(world, p);
                        return;
                    }
                }
    }

    public static void breakTipi(World world, BlockPos pos)
    {
        int height = 5;
        int radius = 2;
        for(int i = -radius; i <= radius; i++)
            for(int j = 0; j <= height; j++)
                for(int k = -radius; k <= radius; k++)
                {
                    BlockPos p = pos.add(i, j, k);
                    IBlockState s = world.getBlockState(p);

                    if(s.getBlock() == ModBlocks.dummyTipi)
                    {
                        world.setBlockToAir(p);
                    }
                    else if(s.getBlock() == ModBlocks.tipi)
                    {
                        s.getBlock().dropBlockAsItem(world, p, world.getBlockState(p), 0);
                        world.setBlockToAir(p);
                    }
                }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getItem(World world, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.tipi);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    public int getMobilityFlag()
    {
        return 2;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }

}
