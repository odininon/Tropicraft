package net.tropicraft.registry;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.tropicraft.block.tileentity.TileEntityAirCompressor;
import net.tropicraft.block.tileentity.TileEntityBambooChest;
import net.tropicraft.block.tileentity.TileEntityCurareBowl;
import net.tropicraft.block.tileentity.TileEntitySifter;
import net.tropicraft.client.entity.model.ModelAshen;
import net.tropicraft.client.entity.model.ModelEIH;
import net.tropicraft.client.entity.model.ModelIguana;
import net.tropicraft.client.entity.model.ModelSeaTurtle;
import net.tropicraft.client.entity.model.ModelSeahorse;
import net.tropicraft.client.entity.model.ModelTreeFrog;
import net.tropicraft.client.entity.model.ModelTurtleEgg;
import net.tropicraft.client.entity.render.RenderAshen;
import net.tropicraft.client.entity.render.RenderChair;
import net.tropicraft.client.entity.render.RenderDart;
import net.tropicraft.client.entity.render.RenderEIH;
import net.tropicraft.client.entity.render.RenderEagleRay;
import net.tropicraft.client.entity.render.RenderIguana;
import net.tropicraft.client.entity.render.RenderPoolFloat;
import net.tropicraft.client.entity.render.RenderSeaTurtle;
import net.tropicraft.client.entity.render.RenderSeahorse;
import net.tropicraft.client.entity.render.RenderTreeFrog;
import net.tropicraft.client.entity.render.RenderTurtleEgg;
import net.tropicraft.client.entity.render.RenderUmbrella;
import net.tropicraft.client.tileentity.TileEntityAirCompressorRenderer;
import net.tropicraft.client.tileentity.TileEntityBambooChestRenderer;
import net.tropicraft.client.tileentity.TileEntityCurareBowlRenderer;
import net.tropicraft.client.tileentity.TileEntitySifterRenderer;
import net.tropicraft.entity.hostile.EntityAshenHunter;
import net.tropicraft.entity.hostile.EntityEIH;
import net.tropicraft.entity.hostile.EntityTreeFrog;
import net.tropicraft.entity.passive.EntityIguana;
import net.tropicraft.entity.placeable.EntityChair;
import net.tropicraft.entity.placeable.EntityUmbrella;
import net.tropicraft.entity.pool.EntityPoolFloat;
import net.tropicraft.entity.projectile.EntityCoconutGrenade;
import net.tropicraft.entity.projectile.EntityDart;
import net.tropicraft.entity.projectile.EntityPoisonBlot;
import net.tropicraft.entity.underdasea.EntityEagleRay;
import net.tropicraft.entity.underdasea.EntitySeaTurtle;
import net.tropicraft.entity.underdasea.EntitySeahorse;
import net.tropicraft.entity.underdasea.EntityTurtleEgg;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class TCRenderRegistry {

    /**
     * Register all Entity*.class -> Render*.class mappings
     */
    public static void initEntityRenderers() {
        registerEntityRender(EntityChair.class, new RenderChair());
        registerEntityRender(EntityUmbrella.class, new RenderUmbrella());
        registerEntityRender(EntityPoolFloat.class, new RenderPoolFloat());
        registerEntityRender(EntitySeahorse.class, new RenderSeahorse(new ModelSeahorse(), 0.75F));
        registerEntityRender(EntityDart.class, new RenderDart());
        registerEntityRender(EntityIguana.class, new RenderIguana(new ModelIguana(), 0.75F));
        registerEntityRender(EntityEIH.class, new RenderEIH(new ModelEIH(), 0.75F));
        registerEntityRender(EntityTreeFrog.class, new RenderTreeFrog(new ModelTreeFrog(), 0.5F));
        registerEntityRender(EntityPoisonBlot.class, new RenderPoisonBlot());
        registerEntityRender(EntitySeaTurtle.class, new RenderSeaTurtle(new ModelSeaTurtle(), 0.75F));
        registerEntityRender(EntityTurtleEgg.class, new RenderTurtleEgg(new ModelTurtleEgg(), 0.75F));
        registerEntityRender(EntityEagleRay.class, new RenderEagleRay());
        registerEntityRender(EntityAshenHunter.class, new RenderAshen(new ModelAshen(), 0.75F));
        registerEntityRender(EntityCoconutGrenade.class, new RenderSnowball(TCItemRegistry.coconutBomb));
    }

    /**
     * Register all tile entity special render mappings
     */
    public static void initTileEntityRenderers() {
        registerTileEntityRenderer(TileEntityBambooChest.class, new TileEntityBambooChestRenderer());
        registerTileEntityRenderer(TileEntityAirCompressor.class, new TileEntityAirCompressorRenderer());
        registerTileEntityRenderer(TileEntitySifter.class, new TileEntitySifterRenderer());
        registerTileEntityRenderer(TileEntityCurareBowl.class, new TileEntityCurareBowlRenderer());
    }

    private static void registerTileEntityRenderer(Class<? extends TileEntity> tileEntityClass, 
            TileEntitySpecialRenderer specialRenderer) {
        ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer);
    }

    private static void registerEntityRender(Class<? extends Entity> entityClass, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
    }	
}
