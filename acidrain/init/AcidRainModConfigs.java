package net.mcreator.acidrain.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.acidrain.configuration.AcidRainConfiguration;
import net.mcreator.acidrain.AcidRainMod;

@Mod.EventBusSubscriber(modid = AcidRainMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AcidRainModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AcidRainConfiguration.SPEC, "acidrain.toml");
		});
	}
}
