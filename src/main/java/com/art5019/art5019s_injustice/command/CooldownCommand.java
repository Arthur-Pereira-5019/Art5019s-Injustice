package com.art5019.art5019s_injustice.command;

import com.art5019.art5019s_injustice.powers.ClientPowerService;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class CooldownCommand {
    @SubscribeEvent // on the game event bus
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("cooldown")
                        .then(Commands.literal("reset")
                                .then(Commands.argument("ability", IntegerArgumentType.integer())
                                        .executes(context -> {
                                            int ability = IntegerArgumentType.getInteger(context, "ability");
                                            if(context.getSource().getEntity() instanceof ServerPlayer player) {
                                                ClientPowerService.resetCooldown(player, ability);
                                            }
                                            return Command.SINGLE_SUCCESS;
                                        })
                                )
                        )
        );
    }


}
