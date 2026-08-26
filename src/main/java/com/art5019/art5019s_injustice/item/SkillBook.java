package com.art5019.art5019s_injustice.item;

import com.art5019.art5019s_injustice.data.Skill;
import com.art5019.art5019s_injustice.data.Skills;
import com.art5019.art5019s_injustice.helper.SkillHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WrittenBookItem;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class SkillBook extends Item {
    private final Skill associatedSkill;

    public SkillBook(Properties properties, Skill associatedSkill) {
        super(properties);
        this.associatedSkill = associatedSkill;
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(level instanceof ServerLevel && player instanceof ServerPlayer) {
            SkillHelper.learnSkill(Skills.fromId(associatedSkill.skillId()), associatedSkill.level(), (ServerPlayer) player, 0, (ServerLevel) level);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        super.inventoryTick(itemStack, level, owner, slot);
    }
}
