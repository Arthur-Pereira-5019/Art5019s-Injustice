package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.entity.MrNegativeEntity;

import java.util.List;
import java.util.Comparator;

public class MrNegativeRandomDialogueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 0) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> It's not about the damage, it's about the message!"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 1);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 1) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> I will make him pay!"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 2);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 2) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> Get out of my way!"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 3);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 3) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> \u8B93\u6211\u7D66\u4F60\u6307\u8DEF"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 4);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 4) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(
								Component.literal("<Mr Negative> \u5149\u660E\u8207\u9ED1\u6697\u7684\u4E8C\u5143\u6027\u662F\u4E00\u500B\u8B0A\u8A00\u3002\u6211\u5F88\u65E9\u5C31\u5F9E\u75DB\u82E6\u4E2D\u5B78\u6703\u4E86\u9019\u4E00\u9EDE\u3002"),
								false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 5);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 5) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> Now... \u4E86\u89E3\u9ED1\u6697"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 6);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 6) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> It's the lack of responsabilities your leaders have with the freedom \"proclaimed by God\" you have here that created all the darkness I needed to take control."),
								false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 7);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 7) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> Stop running from you darkness... if you really want to defeat me, that will be your first step... still you will be another ten behind me."), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 8);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 8) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> Can't you hear the light echoing trough the dark room that this country is?"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 9);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 9) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> You won't get out of my way, won't you?"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 10);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 10) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> Darkness brought you here. And your light will take your soul out of this world."), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 11);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 11) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> \u5ABD\u5ABD...\uFF1F\u7238\u7238...?"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 12);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 12) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> \u90A3\u9053\u5149\u2026\u2026\u5B83\u5728\u9019\u88E1\u505A\u4EC0\u9EBC\uFF1F"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 13);
				} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_dialogues) : 0) == 13) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr Negative> \u6211\u770B\u5230\u706B\u5728\u53E6\u4E00\u908A\u7B49\u8457\u6211"), false);
					if (entity instanceof MrNegativeEntity _datEntSetI)
						_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_dialogues, 14);
				}
			}
		}
	}
}
