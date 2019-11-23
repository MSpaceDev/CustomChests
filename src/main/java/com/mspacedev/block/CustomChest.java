package com.mspacedev.block;

import com.google.gson.annotations.SerializedName;
import com.mspacedev.util.enums.EnumModelType;
import net.minecraft.block.Block;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

public class CustomChest extends ChestBlock
{
	public CustomChest(Block.Properties properties, CustomChest.Properties chestProperties)
	{
		super(properties);
		this.setRegistryName(chestProperties.getName());
	}

	public static class Properties
	{
		@SerializedName("name")
		private String name;
		@SerializedName("model_type")
		private String modelType;
		@SerializedName("model")
		private String modelLocation;
		@SerializedName("texture")
		private String textureLocation;
		@SerializedName("slot_x")
		private int slotX;
		@SerializedName("slot_y")
		private int slotY;

		// Builder
		public static Properties create()
		{
			// Defaults
			return new Properties()
					.setSlotX(9)
					.setSlotY(3)
					.setModelType(EnumModelType.CHEST);
		}

		public Properties setName(String name)
		{
			this.name = name;
			return this;
		}

		public Properties setModelType(EnumModelType modelType)
		{
			this.modelType = modelType.toString();
			return this;
		}

		public Properties setModelLocation(ResourceLocation modelLocation)
		{
			this.modelLocation = new ModelResourceLocation(modelLocation, "normal").toString();
			return this;
		}

		public Properties setTextureLocation(ResourceLocation textureLocation)
		{
			this.textureLocation = textureLocation.toString();
			return this;
		}

		public Properties setSlotX(int slotX)
		{
			this.slotX = slotX;
			return this;
		}

		public Properties setSlotY(int slotY)
		{
			this.slotY = slotY;
			return this;
		}

		// Getters
		public String getName()
		{
			return name;
		}

		public EnumModelType getModelType()
		{
			return EnumModelType.getEnum(this.modelType);
		}

		public ModelResourceLocation getModelLocation()
		{
			if (ResourceLocation.isResouceNameValid(modelLocation))
				return new ModelResourceLocation(new ResourceLocation(modelLocation), "normal");

			return null;
		}

		public ResourceLocation getTextureLocation()
		{
			if (ResourceLocation.isResouceNameValid(textureLocation))
				return new ResourceLocation(textureLocation);

			return null;
		}

		public int getSlotX()
		{
			return (slotX < 1) ? 1 : slotX;
		}

		public int getSlotY()
		{
			return (slotY < 1) ? 1 : slotY;
		}

		// Show JSON format when this#toString called
		@Override
		public String toString()
		{
			return "\n\"" + name + "\": {" + "\n" +
					"	\"model_type\": " + this.modelType + "\n" +
					"	\"model\": " + this.modelLocation + "\n" +
					"	\"texture\": " + this.textureLocation + "\n" +
					"	\"slot_x\": " + this.slotX + "\n" +
					"	\"slot_y\": " + this.slotY + "\n" +
					"}";
		}
	}
}
