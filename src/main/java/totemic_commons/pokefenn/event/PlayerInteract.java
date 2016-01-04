package totemic_commons.pokefenn.event;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.ModItems;
import totemic_commons.pokefenn.block.tipi.BlockTipi;
import totemic_commons.pokefenn.network.PacketHandler;
import totemic_commons.pokefenn.network.server.PacketMouseWheel;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class PlayerInteract
{

    @SubscribeEvent
    public void onInteract(PlayerInteractEvent event)
    {
        if(event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)
        {
            if(event.world.getBlockState(event.pos.up()).getBlock() == ModBlocks.tipi)
            {
                Block block = event.world.getBlockState(event.pos).getBlock();
                if(block != null)
                {
                    if(block.getMaterial() == Material.ground || block.getUnlocalizedName().contains("dirt") || block.getUnlocalizedName().contains("grass"))
                    {
                        ((BlockTipi)ModBlocks.tipi).tipiSleep(event.world, event.pos, event.entityPlayer);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onMouse(MouseEvent event)
    {
        if(event.isCanceled())
            return;

        if(event.dwheel != 0)
        {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            if(player.isSneaking() && player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.totemWhittlingKnife)
            {
                PacketHandler.sendToServer(new PacketMouseWheel(event.dwheel > 0));
                event.setCanceled(true);
            }
        }
    }
}
