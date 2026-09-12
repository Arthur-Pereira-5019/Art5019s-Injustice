package com.art5019.art5019s_injustice.block;

import com.art5019.art5019s_injustice.data.records.skill.Skill;
import com.art5019.art5019s_injustice.data.records.skill.Skills;
import com.art5019.art5019s_injustice.helper.QueriedTickedCounterHelper;
import com.art5019.art5019s_injustice.helper.SkillHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.art5019.art5019s_injustice.Art5019sInjustice.BLOCKS;
import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.STRESS;
import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.SKILL_COMPONENT;

@Mod(MODID)
public class Blocks {
    public final static DeferredBlock<EngineeringTable> ENGINEERING_TABLE = BLOCKS.register("engineering_table", registryName -> new EngineeringTable(engineeringProperties(registryName)));

    public static BlockBehaviour.Properties engineeringProperties(Identifier registryName) {
        return BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK,registryName))
                .destroyTime(1.0f)
                .explosionResistance(8.0f)
                .sound(SoundType.METAL);
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
}
