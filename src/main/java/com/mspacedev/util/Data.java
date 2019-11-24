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

			if (!FileManager.CHEST_FILES.isEmpty())
			{
				for (File file : FileManager.CHEST_FILES)
				{
					chestProperties.add(FileManager.convertJSONFileToObject(file, CustomChest.Properties.class));
				}
			}
			else
			{
				return getDefaultProperties();
			}

			return chestProperties;
		}

		private static ArrayList<CustomChest.Properties> getDefaultProperties()
		{
			ArrayList<CustomChest.Properties> defaultChestProperties = new ArrayList<>();

			ArrayList<File> localChestFiles = FileManager.LOCAL_CHEST_FILES;

			if (!FileManager.LOCAL_CHEST_FILES.isEmpty())
			{
				for (File jsonFile : FileManager.LOCAL_CHEST_FILES)
				{
					CustomChest.Properties chestProperty = FileManager.convertJSONFileToObject(jsonFile, CustomChest.Properties.class);

					if (chestProperty != null)
					{
						FileManager.writeJSONObjectToFile(chestProperty, CustomChest.Properties.class, chestProperty.getName(), FileManager.REL_CHESTS_PATH);
						defaultChestProperties.add(chestProperty);
					}
				}
			}

			return defaultChestProperties;
		}
	}
}
