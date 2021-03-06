package totemic_commons.pokefenn.item.equipment;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.ModBlocks;
import totemic_commons.pokefenn.Totemic;
import totemic_commons.pokefenn.api.totem.TotemEffect;
import totemic_commons.pokefenn.apiimpl.RegistryImpl;
import totemic_commons.pokefenn.block.totem.BlockTotemBase;
import totemic_commons.pokefenn.block.totem.BlockTotemPole;
import totemic_commons.pokefenn.item.ItemTotemic;
import totemic_commons.pokefenn.lib.Strings;
import totemic_commons.pokefenn.lib.WoodVariant;
import totemic_commons.pokefenn.tileentity.totem.TileTotemPole;
import totemic_commons.pokefenn.util.ItemUtil;

public class ItemTotemWhittlingKnife extends ItemTotemic
{
    private static final List<TotemEffect> totemList = ((RegistryImpl)Totemic.api.registry()).getTotemList();

    public ItemTotemWhittlingKnife()
    {
        super(Strings.TOTEM_WHITTLING_KNIFE_NAME);
        setMaxStackSize(1);
        setContainerItem(this);
        setMaxDamage(254);
    }

    @SideOnly(Side.CLIENT)
    public String getCurrentlyCarving(int i)
    {
        if(i < totemList.size())
            return StatCollector.translateToLocal(totemList.get(i).getUnlocalizedName());
        else if(i == totemList.size())
            return StatCollector.translateToLocal("tile.totemBase.name");
        else
            return "";
    }

    public static int getCarvingIndex(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null)
            return totemList.size();
        else
            return MathHelper.clamp_int(tag.getInteger(Strings.KNIFE_TOTEM_KEY), 0, totemList.size());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
    {
        list.add(StatCollector.translateToLocal("item.totemic:totemWhittlingKnife.tooltip1"));
        list.add(StatCollector.translateToLocal("item.totemic:totemWhittlingKnife.tooltip2"));
        list.add(StatCollector.translateToLocalFormatted("item.totemic:totemWhittlingKnife.tooltip3", getCurrentlyCarving(getCarvingIndex(stack))));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getItemStackDisplayName(ItemStack stack) {
        return StatCollector.translateToLocalFormatted(getUnlocalizedName() + ".display", getCurrentlyCarving(getCarvingIndex(stack)));
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(player.isSneaking())
            return changeIndex(itemStack, 1);
        else
            return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(player.isSneaking())
        {
            player.setCurrentItemOrArmor(0, onItemRightClick(stack, world, player));
            return true;
        }
        else
        {
            if(world.isRemote)
                return true;

            IBlockState state = world.getBlockState(pos);
            WoodVariant wood = WoodVariant.fromLog(state);
            if(wood == null)
                return false;

            int index = getCarvingIndex(stack);
            if(index == totemList.size())
            {
                world.setBlockState(pos, ModBlocks.totemBase.getDefaultState().withProperty(BlockTotemBase.WOOD, wood), 3);
            }
            else if(index < totemList.size())
            {
                world.setBlockState(pos, ModBlocks.totemPole.getDefaultState().withProperty(BlockTotemPole.WOOD, wood), 3);
                TileTotemPole tile = (TileTotemPole)world.getTileEntity(pos);

                tile.effect = totemList.get(getCarvingIndex(stack));
                tile.markDirty();
                world.markBlockForUpdate(pos);
            }
            else
                return false;
            stack.damageItem(1, player);

            return true;
        }
    }

    public static ItemStack changeIndex(ItemStack itemStack, int i)
    {
        ItemStack stack = itemStack.copy();
        int newIndex = (i + getCarvingIndex(stack)) % (totemList.size() + 1);
        if(newIndex < 0)
            newIndex += totemList.size() + 1;
        ItemUtil.getOrCreateTag(stack).setInteger(Strings.KNIFE_TOTEM_KEY, newIndex);
        return stack;
    }

}


