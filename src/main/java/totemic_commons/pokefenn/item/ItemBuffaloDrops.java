package totemic_commons.pokefenn.item;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.lib.Strings;

/**
 * Created by Pokefenn.
 * Licensed under MIT (If this is one of my Mods)
 */
public class ItemBuffaloDrops extends ItemTotemic
{
    public enum Type
    {
        hide, teeth/*, horn, hair, hoof, dung*/;

        private final String fullName = "buffalo" + StringUtils.capitalize(name());

        @Override
        public String toString()
        {
            return fullName;
        }
    }

    public ItemBuffaloDrops()
    {
        super("");
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        int index = MathHelper.clamp_int(itemStack.getItemDamage(), 0, Type.values().length - 1);
        return "item." + Strings.RESOURCE_PREFIX + Type.values()[index].toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, List<ItemStack> list)
    {
        for(int meta = 0; meta < Type.values().length; ++meta)
            list.add(new ItemStack(id, 1, meta));
    }
}
