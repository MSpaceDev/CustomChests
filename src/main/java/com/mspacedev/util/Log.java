package com.mspacedev.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log
{
	private static final Logger LOGGER = LogManager.getLogger();

	public static void info(String info)
	{
		LOGGER.info(info);
	}

	public static void debug(String debug)
	{
		LOGGER.debug(debug);
	}

	public static void warn(String warn)
	{
		LOGGER.warn(warn);
	}

	public static void error(String error)
	{
		LOGGER.error(error);
		throw new RuntimeException();
	}
}
