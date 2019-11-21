package com.mspacedev;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;

@Mod(Main.MODID)
public class Main
{
	public static final String MODID = "customchests";

	public static void debug(String debug)
	{
		LogManager.getLogger().debug(debug);
	}

	public Main()
	{
		Main.debug("Hello World from Custom Chests!");
	}
}
