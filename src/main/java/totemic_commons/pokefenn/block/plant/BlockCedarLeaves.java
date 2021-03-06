package totemic_commons.pokefenn.block.plant;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.Totemic;
import totemic_commons.pokefenn.lib.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 16/02/14
 * Time: 17:48
 */
public class BlockCedarLeaves extends BlockLeaves
{
    public static final PropertyBool TRANSPARENT = PropertyBool.create("transparent");

    public BlockCedarLeaves()
    {
        setCreativeTab(Totemic.tabsTotem);
        setUnlocalizedName(Strings.TOTEM_LEAVES_NAME);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.cedarSapling);
    }

    @Override
    protected int getSaplingDropChance(IBlockState state)
    {
        return 80;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iba, BlockPos pos, EnumFacing side)
    {
        return Minecraft.isFancyGraphicsEnabled() || super.shouldSideBeRendered(iba, pos, side);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return Blocks.leaves.isOpaqueCube();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return Minecraft.isFancyGraphicsEnabled() ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, CHECK_DECAY, DECAYABLE, TRANSPARENT);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        if(!state.getValue(DECAYABLE))
            meta |= 4;
        if(state.getValue(CHECK_DECAY))
            meta |= 8;

        return meta;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState()
                .withProperty(DECAYABLE, (meta & 4) == 0)
                .withProperty(CHECK_DECAY, (meta & 8) != 0);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(TRANSPARENT, !isOpaqueCube());
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return Collections.singletonList(item);
    }

    @Override
    public EnumType getWoodType(int meta)
    {
        return null;
    }
}
