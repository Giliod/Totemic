package totemic_commons.pokefenn.network.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.network.PacketBase;
import totemic_commons.pokefenn.tileentity.music.TileWindChime;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class PacketWindChime extends PacketBase<PacketWindChime>
{
    private BlockPos pos;

    public PacketWindChime()
    {

    }

    public PacketWindChime(BlockPos pos)
    {
        this.pos = pos;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.pos = BlockPos.fromLong(buf.readLong());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeLong(pos.toLong());
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected void handleClient(MessageContext ctx)
    {
        World world = Minecraft.getMinecraft().theWorld;

        TileEntity tile = world.getTileEntity(pos);
        if(tile instanceof TileWindChime)
        {
            ((TileWindChime) tile).setPlaying(true);
        }
    }
}
