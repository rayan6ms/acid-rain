package net.mcreator.acidrain.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.acidrain.network.AcidRainModVariables;
import net.mcreator.acidrain.configuration.AcidRainConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StartAcidRainProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.dayTime() % (double) AcidRainConfiguration.ACID_RAIN_TIMER.get() == 0) {
			if (!world.getLevelData().isRaining() && !AcidRainModVariables.MapVariables.get(world).isRainingAcid) {
				world.getLevelData().setRaining(true);
				AcidRainModVariables.MapVariables.get(world).isRainingAcid = true;
				AcidRainModVariables.MapVariables.get(world).syncData(world);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Acid rain"), false);
			}
			if (world.getLevelData().isRaining() && !AcidRainModVariables.MapVariables.get(world).isRainingAcid) {
				AcidRainModVariables.MapVariables.get(world).isRainingAcid = true;
				AcidRainModVariables.MapVariables.get(world).syncData(world);
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Acid rain"), false);
			}
		}
		if (world.dayTime() % 300 == 0 && AcidRainModVariables.MapVariables.get(world).isRainingAcid) {
			if (!world.getLevelData().isRaining()) {
				AcidRainModVariables.MapVariables.get(world).isRainingAcid = false;
				AcidRainModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
