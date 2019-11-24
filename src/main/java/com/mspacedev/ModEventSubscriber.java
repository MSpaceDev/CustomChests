package com.mspacedev;

import com.google.common.base.Preconditions;
import com.mspacedev.block.CustomChest;
import com.mspacedev.itemgroup.ModItemGroups;
import com.mspacedev.util.Data;
import com.mspacedev.util.Log;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nonnull;
import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber
{
	@SubscribeEvent
	public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
	{
		IForgeRegistry<Block> registry = event.getRegistry();

		ArrayList<CustomChest.Properties> customChestProperties = Data.Chests.getChestProperties();
		if (!customChestProperties.isEmpty())
		{
			for (CustomChest.Properties properties : customChestProperties)
			{
				Log.debug(properties.toString());
				registry.register(new CustomChest(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0f, 1.0f).sound(SoundType.WOOD), properties));
			}
		}
		else
		{
			Log.error("Critical error while loading custom blocks. No blocks were loaded during initialization!");
		}
	}

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(
				setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "key")
		);
	}

	// Sets the registry name for any supported object passed in
	@Nonnull
	private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final String name)
	{
		Preconditions.checkNotNull(name, "Name to assign to entry cannot be null!");
		return setup(entry, new ResourceLocation(Main.MODID, name));
	}

	@Nonnull
	private static <T extends IForgeRegistryEntry<T>> T setup(@Nonnull final T entry, @Nonnull final ResourceLocation registryName)
	{
		Preconditions.checkNotNull(entry, "Entry cannot be null!");
		Preconditions.checkNotNull(registryName, "Registry name to assign to entry cannot be null!");
		entry.setRegistryName(registryName);
		return entry;
	}
}
