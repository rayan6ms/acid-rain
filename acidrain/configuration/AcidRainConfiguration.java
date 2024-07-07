package net.mcreator.acidrain.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class AcidRainConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> ACID_RAIN_TIMER;
	static {
		BUILDER.push("Acid Rain Timer");
		ACID_RAIN_TIMER = BUILDER.comment("Time in ticks for the acid rain to start again, a day is 24000 ticks, eg. if you want the rain to start at day 2, every 2 days, set to 48000").define("acidRainTimer", (double) 168000);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
