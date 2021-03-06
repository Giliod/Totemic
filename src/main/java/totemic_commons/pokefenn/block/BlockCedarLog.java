package totemic_commons.pokefenn.block;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import totemic_commons.pokefenn.Totemic;
import totemic_commons.pokefenn.lib.Strings;

/**
 * Created with IntelliJ IDEA.
 * User: Pokefenn
 * Date: 09/12/13
 * Time: 14:35
 */
public class BlockCedarLog extends BlockLog
{
    public BlockCedarLog()
    {
        super();
        setUnlocalizedName(Strings.CEDAR_LOG_NAME);
        setHardness(2F);
        setCreativeTab(Totemic.tabsTotem);
        setDefaultState(getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y));
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, LOG_AXIS);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int meta = 0;
        switch(state.getValue(LOG_AXIS))
        {
            case Y:
                break;
            case X:
                meta |= 4;
                break;
            case Z:
                meta |= 8;
                break;
            case NONE:
                meta |= 12;
        }

        return meta;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState state = getDefaultState();
        switch(meta)
        {
            case 0:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                state = state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
        return state;
    }
}








