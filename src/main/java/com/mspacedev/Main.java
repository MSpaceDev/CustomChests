package com.mspacedev;

import com.mspacedev.util.Log;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.MODID)
public class Main
{
	public static final String MODID = "customchests";

	public static Main instance;

	public Main()
	{
		Log.debug("Hello World from Custom Chests!");

		instance = this;
	}
}
