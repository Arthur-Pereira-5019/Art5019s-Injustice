package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.entity.MayParkerEntity;
import net.mcreator.artinjustice.entity.MartinLiEntity;

import java.util.List;
import java.util.Comparator;

public class DialogueAuntMayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		boolean thereismartinli = false;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB)) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(120 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof MartinLiEntity) {
						thereismartinli = true;
					}
				}
			}
			if (!thereismartinli) {
				if (sourceentity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
						&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:the_heartofthe_matter"))).isDone() && sourceentity instanceof ServerPlayer _plr5
						&& _plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:the_path_of_light"))).isDone()) {
					if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_quest) : 0) == 1) {
						if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 0) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> So... that's it."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 1);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 1) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> The man who taught me to believe in light on my hardest day."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 2);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 2) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> The day who I lost my husband..."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 3);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 3) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> It's the darkness itself."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 4);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 4) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity, "Well. He wasn't all evil.")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 5);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 5) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> Don't come up with that. Even my nephew Peter got harmed on Li's Inner Demons rampage."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 6);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 6) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity,
										"I'm sorry for your nephew, but Li's darkness overcame his own light. His powers attracted negativity, and negativity incresead his powers, it was some sort of devilish feedback circuit.")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 7);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 7) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> Is that supposed to make me feel better? That any of us can just get stuck on a path of endless evil toughts and them create a unstoppable mayhem?"), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 8);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 8) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity,
										"You're right. All of us can get stuck in the same insane path Li was. But as Li accepted being peacefuly arrested and yet has not scaped, I'm confortable to say that even in the darkest pathes, there are people, who can bring light to them.")),
										false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 9);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 9) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> Maybe you're right. But, how I am supposed to go on without him?"), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 10);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 10) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity,
										"It's not the first time you lost someone May. But you always came back, not because someone new led you, but because someone remebered what you can do by yourself.")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 11);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 11) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"<May Parker> You're right. And all these people need to remember too what we could do by ourselves, as my husband Ben would say if he was here... \"With great powers, come great responsability\". Thanks for the help, but now, FEAST needs me. You're more than welcome to stay here."),
										false);
							MayParkerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 75, -0.009, 2, 30);
							if (world instanceof ServerLevel _level)
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 25));
						}
					} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_quest) : 0) == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<May Parker> Again, thanks for the help."), false);
					}
				} else if (sourceentity instanceof ServerPlayer _plr45 && _plr45.level() instanceof ServerLevel
						&& _plr45.getAdvancements().getOrStartProgress(_plr45.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:the_heartofthe_matter"))).isDone()) {
					if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_quest) : 0) == 1) {
						if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 0) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> So... that's it."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 1);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 1) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> The man who taught me to believe in light on my hardest day."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 2);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 2) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> The day who I lost my husband..."), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 3);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 3) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> It's dead!"), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 4);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 4) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity, "May... I'm sorry to say that, but he had to go. His powers were corrupting him and they were unstoppable.")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 5);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 5) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> No, he hadn't! Every couple of weeks in the news some hero or villain lost or found again it's powers, but why it had to be different with Li?"), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 6);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 6) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity, "Maybe... but, he couldn't be arrested, that wasn't safe, he could lie and them get...")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 7);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 7) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("<May Parker> Why are you saying that as you killed him?"), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 8);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 8) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity, "May... listen to me... sometimes we can't do the right decisions and...")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 9);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 9) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										"<May Parker> Just like he did? Listen... if you really want to step in this hero business, you better have what it takes to be a good one, or else, people, like the ones from this shelter might suffer the consequences of incompetences, remember, with great power, comes great responsability!"),
										false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 10);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 10) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(ReturnEntityChatProcedure.execute(sourceentity, "May... I can't just...")), false);
							if (entity instanceof MayParkerEntity _datEntSetI)
								_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, 11);
						} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_step) : 0) == 11) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal("<May Parker> Shut up... maybe you really done what you tought it was right on your head... but that's not how the world works... deal with it. But now, I need sometime for myself. "), false);
							MayParkerTaskManagementProcedure.execute(world, x, y, z, entity, sourceentity, 75, -0.009, 2, 30);
							if (world instanceof ServerLevel _level)
								_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 25));
						}
					} else if ((entity instanceof MayParkerEntity _datEntI ? _datEntI.getEntityData().get(MayParkerEntity.DATA_quest) : 0) == 2) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<May Parker> Please, get out of my way."), false);
					}
				} else {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<May Parker> Sorry young person, these people need my help."), false);
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<May Parker> Sorry young person, these people need my help."), false);
			}
		}
	}
}
