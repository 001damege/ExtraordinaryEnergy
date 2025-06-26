package extraordinaryenergy.common.items;

import extraordinaryenergy.common.definitions.EEText;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TheNull extends MaterialItem{
    public TheNull(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag advancedTooltip) {
        tooltip.add(EEText.Null.text().withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        super.appendHoverText(stack, context, tooltip, advancedTooltip);
    }
}
