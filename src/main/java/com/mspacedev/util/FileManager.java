package com.mspacedev.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mspacedev.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager
{
// File paths
private static final String CHESTS_PATH = "customchests/chests/";
private static final String MODELS_PATH = "customchests/models/";
private static final String TEXTURES_PATH = "customchests/textures/";

// Files
public static final ArrayList<File> chestFiles = getFilesInPath("customchests/chests/");
public static final ArrayList<File> modelFiles = getFilesInPath(MODELS_PATH);
public static final ArrayList<File> textureFiles = getFilesInPath(TEXTURES_PATH);

// Resources
private static final String LOCAL_CHESTS_PATH = "src/main/resources/data/" + Main.MODID + "/chests/";
public static final ArrayList<File> LOCAL_CHEST_FILES = getFilesInPath(LOCAL_CHESTS_PATH);

private static ArrayList<File> getFilesInPath(final String pathName)
{
	ArrayList<File> files = new ArrayList<>();

	File folder = new File(pathName);

	Log.debug("stop right there!");
	for (final File fileEntry : folder.listFiles())
	{
		Log.debug("stop right there!");

		if (fileEntry.isDirectory())
			continue;

		files.add(new File(fileEntry.getName()));
	}

	return files;
}

	public static <T> T convertJSONFileToObject(File file, Class<T> typeOf)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try
		{
			Log.debug("Attempting access: " + file.getPath());

			FileReader reader = new FileReader(file);

			Log.debug("Succeeded access: " + file.getPath());

			return gson.fromJson(reader, typeOf);
		}
		catch (FileNotFoundException e)
		{
			Log.debug("Tried to access a file that does not exist! Either this is the first setup, or files were deleted at runtime!");
			return null;
		}
	}
}
