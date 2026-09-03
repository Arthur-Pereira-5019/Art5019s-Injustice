package com.art5019.art5019s_injustice.item;

import com.art5019.art5019s_injustice.data.Skill;
import com.art5019.art5019s_injustice.data.Skills;
import com.art5019.art5019s_injustice.helper.QueriedTickedCounterHelper;
import com.art5019.art5019s_injustice.helper.SkillHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

import static com.art5019.art5019s_injustice.data.DataAttachments.STRESS;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

public class SkillBook extends Item {
    public SkillBook(Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        Skill associatedSkill = player.getItemInHand(hand).get(SKILL_COMPONENT);
        if(level instanceof ServerLevel sl && player instanceof ServerPlayer sp) {
            int currentStress = QueriedTickedCounterHelper.queryData(sp, STRESS);
            if(currentStress == 0) {
                int newStress = SkillHelper.learnSkill(Skills.fromId(associatedSkill.skillId()),
                        associatedSkill.level(), sp, 0, sl);
                if(newStress == 0) {
                    player.sendOverlayMessage(Component.translatable("art5019sinjustice.item.skill_book.skilled_enough"));
                }
                QueriedTickedCounterHelper.setData(sp,STRESS,newStress);
            } else {
                player.sendOverlayMessage(Component.translatable("art5019sinjustice.event.should_rest"));
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
