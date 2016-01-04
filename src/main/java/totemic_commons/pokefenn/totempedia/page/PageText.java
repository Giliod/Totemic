/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Totemic Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 */
package totemic_commons.pokefenn.totempedia.page;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import totemic_commons.pokefenn.client.FontHelper;
import vazkii.botania.totemic_custom.api.internal.IGuiLexiconEntry;
import vazkii.botania.totemic_custom.api.lexicon.LexiconPage;

public class PageText extends LexiconPage
{

    public PageText(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderScreen(IGuiLexiconEntry gui, int mx, int my)
    {
        int width = gui.getWidth() - 30;
        int x = gui.getLeft() + 14;
        int y = gui.getTop() + 2;

        renderText(x, y, width, gui.getHeight(), getUnlocalizedName());
    }

    @SideOnly(Side.CLIENT)
    public static void renderText(int x, int y, int width, int height, String unlocalizedText)
    {
        FontRenderer renderer = Minecraft.getMinecraft().fontRendererObj;
        boolean unicode = renderer.getUnicodeFlag();
        renderer.setUnicodeFlag(true);
        String text = StatCollector.translateToLocal(unlocalizedText).replaceAll("&", "\u00a7");
        String[] textEntries = text.split("<br>");

        String lastFormat = "";
        String pendingFormat = "";
        for(String s : textEntries)
        {
            List<String> wrappedLines = new ArrayList<>();
            String workingOn = "";

            int i = 0;
            String[] tokens = s.split(" ");
            for(String s1 : tokens)
            {
                boolean skipPending = false;
                String format = FontHelper.getFormatFromString(s1);

                if(!format.isEmpty() && s1.length() > 0 && s1.charAt(0) != '\u00a7')
                {
                    skipPending = true;
                    pendingFormat = format;
                    format = "";
                }

                if(!pendingFormat.isEmpty() && !skipPending)
                {
                    format = pendingFormat;
                    pendingFormat = "";
                }

                if(format == null || format.equals(""))
                    format = lastFormat;

                if(renderer.getStringWidth(workingOn + " " + s1) >= width)
                {
                    wrappedLines.add(workingOn);
                    workingOn = "";
                }
                workingOn = workingOn + format + " " + s1;

                if(i == tokens.length - 1)
                    wrappedLines.add(workingOn);

                ++i;
                lastFormat = format;
            }

            for(String s1 : wrappedLines)
            {
                y += 10;
                renderer.drawString(s1, x, y, 0);
            }

            y += 10;
        }

        renderer.setUnicodeFlag(unicode);
    }

}
