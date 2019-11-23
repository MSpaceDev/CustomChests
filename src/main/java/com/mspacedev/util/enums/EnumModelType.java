package com.mspacedev.util.enums;

import net.minecraft.util.IStringSerializable;

public enum EnumModelType implements IStringSerializable
{
	CHEST,
	BLOCK;

	@Override
	public String getName()
	{
		if (this == BLOCK)
			return "block";
		else
			return "chest";
	}

	public static EnumModelType getEnum(String name)
	{
		if (name.equals("block"))
			return BLOCK;
		else
			return CHEST;
	}
}
