package com.mspacedev.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mspacedev.Main;
import com.mspacedev.block.CustomChest;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager
{
	// Files paths (run\... for user edits)
	public static final String REL_CHESTS_PATH = "customchests/chests/";
	public static final String REL_MODELS_PATH = "customchests/models/";
	public static final String REL_TEXTURES_PATH = "customchests/textures/";

	// Resources (resources\... for defaults)
	public static final String LOCAL_CHESTS_PATH = "../src/main/resources/data/customchests/chests/";

	// Files
	public static ArrayList<File> CHEST_FILES = getFilesInPath(REL_CHESTS_PATH);
	public static ArrayList<File> MODEL_FILES = getFilesInPath(REL_MODELS_PATH);
	public static ArrayList<File> TEXTURE_FILES = getFilesInPath(REL_TEXTURES_PATH);

	public static final ArrayList<File> LOCAL_CHEST_FILES = getFilesInPath(LOCAL_CHESTS_PATH);

	public static FileManager create()
	{
		return new FileManager();
	}

	public static ArrayList<File> getFilesInPath(final String relativeFolderPath)
	{
		ArrayList<File> files = new ArrayList<>();

		File folder = new File(FileManager.getAbsolutePath(relativeFolderPath));

		// Get all files using absolute paths
		File[] folderFiles = folder.listFiles();
		if (folderFiles != null)
		{
			for (final File fileEntry : folderFiles)
			{
				Log.debug("stop right there!");

				if (fileEntry.isDirectory())
					continue;

				files.add(new File(fileEntry.getAbsolutePath()));
			}
		}

		files.forEach(p -> Log.debug(p.getAbsolutePath()));

		return files;
	}

	// Converts relative path to absolute path
	private static String getAbsolutePath(String relPath)
	{
		File tempFile = new File(relPath);
		Path path = Paths.get(tempFile.getAbsolutePath());

		return new File(path.normalize().toString()).getAbsolutePath();
	}


	public static <T> T convertJSONFileToObject(File file, Class<T> typeOf)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try
		{
			Log.debug("Attempting access: " + file.getAbsoluteFile());
			FileReader reader = new FileReader(file);
			Log.debug("Succeeded access: " + file.getAbsoluteFile());

			return gson.fromJson(reader, typeOf);
		}
		catch (FileNotFoundException e)
		{
			Log.warn("Tried to access a file that does not exist! Either this is the first setup, or files were deleted at runtime! File: " + file.getAbsolutePath());
			return null;
		}
	}

	public static <T> void writeJSONObjectToFile(T object, Class<T> clazz, String fileName, String toFolder)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String saveDir = FileManager.getAbsolutePath(toFolder) + "\\" + fileName + ".json";

		try
		{
			File relChestFile = new File(saveDir);

			relChestFile.getParentFile().mkdirs();
			relChestFile.createNewFile();

			if (relChestFile.exists())
			{
				String json = gson.toJson(object, clazz);
				FileUtils.writeStringToFile(new File(saveDir), json);
			}
		}
		catch (IOException e)
		{
			Log.warn("Writing to file failed for path: " + saveDir);
		}
	}
}
