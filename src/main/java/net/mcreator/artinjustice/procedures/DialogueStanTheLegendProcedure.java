package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.StanTheLegendEntity;
import net.mcreator.artinjustice.entity.ArtTheUnemployedEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.Comparator;

public class DialogueStanTheLegendProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.HONEYCOMB)) {
			if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_quest) : 0) == 1) {
				if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> Oh, how are you doing?"), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 1);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Stanley> Sorry, did you said something? My hearing isn't good as it once was. Maybe you could help me with that. I will do a pretty funny treatment in some days, but it will take some time to finish. I might need something to distract myself, can you give me a book about archers?"),
								false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 2);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 2) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.ARCHER_BOOK.get()) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Stanley> Oh, you found it! Thanks, it will make easier for me to hear... I mean... to make easier to deal with the treatment. Thanks, you're a kind soul."), false);
						StamTheLegendManagementProcedure.execute(world, x, y, z, entity, sourceentity, 7, -0.00015, 2, 0);
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Stanley> Not yet? I think one day I saw an arrowsmith selling it."), false);
					}
				}
			} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_quest) : 0) == 2) {
				if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> Hi..."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 1);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> I hope you're doing good, because I don't feel so good."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 2);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> I think it was a weird brazilian drink that I bought with a Farmer with some spare money I had, it's called, Pingo Doce, or something like that."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 3);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 3) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> Kiddo, go on and do me a favor, find the trader, and empty his stock before someone gets hurt with that, it's a really cheap drink, I promise."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 4);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 4) {
					if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PINGO_DOCE.get()
							&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() >= 10) {
						if (sourceentity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.PINGO_DOCE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 10, _player.inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Stanley> Well, thank you, if there was any other contamined bottle there, it's with you now, treat them with care."), false);
						StamTheLegendManagementProcedure.execute(world, x, y, z, entity, sourceentity, 7, -0.0002, 3, 0);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("<Stanley> Go on kid! With all these powers you got, come great responsabilities!"), false);
					}
				}
			} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_quest) : 0) == 3) {
				if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 0) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> How you have been doing? It's been a long time, or maybe not, it always confuses me."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 1);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 1) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stanley> No, time isn't a simple thing. I could lecture you on philosophy and psychology, but your mind can comprehend things that are greater than that."), false);
					if (entity instanceof StanTheLegendEntity _datEntSetI)
						_datEntSetI.getEntityData().set(StanTheLegendEntity.DATA_step, 2);
				} else if ((entity instanceof StanTheLegendEntity _datEntI ? _datEntI.getEntityData().get(StanTheLegendEntity.DATA_step) : 0) == 2) {
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								"<Stanley> So, as paradoxal that it may sounds, there are beings and things that just don't exist, I don't mean like imagination, it's something way more complex than that, beings that already were before space and time, before the creation, before m..."),
								false);
					if (!entity.level().isClientSide())
						entity.discard();
					{
						Entity _ent = sourceentity;
						_ent.setYRot((float) (sourceentity.getYRot() * (-1)));
						_ent.setXRot((float) (sourceentity.getXRot() * (-1)));
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
					Art5019injusticeMod.queueServerWork(60, () -> {
						if (!(null == ((Entity) world.getEntitiesOfClass(ArtTheUnemployedEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)))) {
							if (sourceentity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("<" + ((Entity) world.getEntitiesOfClass(ArtTheUnemployedEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getDisplayName().getString() + "> Who were you talking to?")), false);
						}
						if (sourceentity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:help_stan_the_legend"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					});
				}
			}
		}
	}
}
