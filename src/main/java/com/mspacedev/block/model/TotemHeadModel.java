package com.mspacedev.block.model;

import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.texture.ISprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraftforge.client.model.IModel;

import javax.annotation.Nullable;
import java.util.function.Function;

public class TotemHeadModel implements IModel
{
	public TotemHeadModel()
	{
	}

	@Nullable
	@Override
	public IBakedModel bake(ModelBakery bakery, Function spriteGetter, ISprite sprite, VertexFormat format)
	{
		return null;
	}
}
