package com.mspacedev.itemgroup;

import com.mspacedev.Main;
import com.mspacedev.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups
{
	public static final ModItemGroup MOD_ITEM_GROUP = new ModItemGroup(Main.MODID, () -> ModItems.KEY);

	public static class ModItemGroup extends ItemGroup
	{
		Item supplierIcon;

		ModItemGroup(String label, Supplier<Item> supplierIcon)
		{
			super(label);
			this.supplierIcon = supplierIcon.get();
		}

		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(supplierIcon);
		}
	}
}
