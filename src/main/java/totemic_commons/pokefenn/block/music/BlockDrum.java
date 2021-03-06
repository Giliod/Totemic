package totemic_commons.pokefenn.block.music;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import totemic_commons.pokefenn.block.BlockTileTotemic;
import totemic_commons.pokefenn.lib.Strings;
import totemic_commons.pokefenn.recipe.HandlerInitiation;
import totemic_commons.pokefenn.tileentity.music.TileDrum;
import totemic_commons.pokefenn.util.TotemUtil;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class BlockDrum extends BlockTileTotemic
{
    public BlockDrum()
    {
        super(Material.wood);
        setUnlocalizedName(Strings.DRUM_NAME);
        setBlockBounds(3F/16, 0F/16, 3F/16, 13F/16, 13F/16, 13F/16);
        setStepSound(soundTypeWood);
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
        return new TileDrum();
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player)
    {
        TileDrum tileDrum = (TileDrum) world.getTileEntity(pos);

        if(!world.isRemote && tileDrum.canPlay)
            playDaMusicu((WorldServer)world, pos, player, tileDrum, player.isSneaking());
    }

    public void playDaMusicu(WorldServer world, BlockPos pos, EntityPlayer player, TileDrum tileDrum, boolean isSneaking)
    {
        if(!isSneaking)
        {
            if(!(player instanceof FakePlayer))
            {
                tileDrum.canPlay = false;
                TotemUtil.playMusic(world, pos, HandlerInitiation.drum, 0, 0);
                world.spawnParticle(EnumParticleTypes.NOTE, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 2, 0.0, 0.0, 0.0, 0.0);
                world.markBlockForUpdate(pos);
            }
        } else
        {
            tileDrum.canPlay = false;
            TotemUtil.playMusicForSelector(world, pos, HandlerInitiation.drum, 0);
            world.spawnParticle(EnumParticleTypes.NOTE, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 2, 0.0, 0.0, 0.0, 0.0);
            world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 2, 0.0, 0.0, 0.0, 0.0);
            world.markBlockForUpdate(pos);
        }

        TotemUtil.playSound(world, pos, "totemic:drum", 1.0f, 1.0f);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileDrum tileDrum = (TileDrum) world.getTileEntity(pos);

        if(!world.isRemote)
        {
            if(tileDrum.canPlay)
            {
                playDaMusicu((WorldServer)world, pos, player, tileDrum, player.isSneaking());
            }
        }

        return true;
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
}
