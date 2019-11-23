package com.mspacedev.util;

import com.mspacedev.block.CustomChest;

import java.io.File;
import java.util.ArrayList;

public class Data
{
	public static class Chests
	{
		public static ArrayList<CustomChest.Properties> getChestProperties()
		{
			ArrayList<CustomChest.Properties> chestProperties = new ArrayList<>();

			if (!FileManager.chestFiles.isEmpty())
			{
				for (File jsonFile : FileManager.chestFiles)
				{
					CustomChest.Properties chestProperty = FileManager.convertJSONFileToObject(jsonFile, CustomChest.Properties.class);

					if (chestProperty != null)
					{
						chestProperties.add(chestProperty);
					}
					else
					{
						ArrayList<CustomChest.Properties> defaultProperties = getDefaultProperties();

						if (defaultProperties != null)
							return defaultProperties;
						else
							Log.error("Critical error loading mod! No blocks have been able to load!");
					}
				}
			}

			return chestProperties;
		}

		private static ArrayList<CustomChest.Properties> getDefaultProperties()
		{
			ArrayList<CustomChest.Properties> defaultChestProperties = new ArrayList<>();

			if (!FileManager.LOCAL_CHEST_FILES.isEmpty())
			{
				for (File jsonFile : FileManager.LOCAL_CHEST_FILES)
				{
					CustomChest.Properties chestProperty = FileManager.convertJSONFileToObject(jsonFile, CustomChest.Properties.class);

					if (chestProperty != null)
						defaultChestProperties.add(chestProperty);
				}
			}

			return defaultChestProperties;
		}
	}
}
