package me.pr3.shitclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtils {

   public static Minecraft mc = Minecraft.getMinecraft();

    public static void drawOutlineBox(float x, float y, float z, float w, float h, float d, float thickness, int hex) {

        //Draw Vertical Lines
        drawLine3D(x, y, z, x, y + h, z, thickness, hex);
        drawLine3D(x, y, z + d, x, y + h, z + d, thickness, hex);
        drawLine3D(x + w, y, z, x + w, y + h, z, thickness, hex);
        drawLine3D(x + w, y, z + d, x + w, y + h, z + d, thickness, hex);
        //Draw Bottom Quad
        drawLine3D(x, y, z, x + w, y, z, thickness, hex);
        drawLine3D(x, y, z, x, y, z + d, thickness, hex);
        drawLine3D(x + w, y, z, x + w, y, z + d, thickness, hex);
        drawLine3D(x, y, z + d, x + w, y, z + d, thickness, hex);
        //Draw Top Quad
        drawLine3D(x, y + h, z, x + w, y + h, z, thickness, hex);
        drawLine3D(x, y + h, z, x, y + h, z + d, thickness, hex);
        drawLine3D(x + w, y + h, z, x + w, y + h, z + d, thickness, hex);
        drawLine3D(x, y + h, z + d, x + w, y + h, z + d, thickness, hex);


    }

    public static void drawFlledCube(AxisAlignedBB bb, int color) {
        float red = (color >> 16 & 0xFF) / 255.0F;
        float green = (color >> 8 & 0xFF) / 255.0F;
        float blue = (color & 0xFF) / 255.0F;
        float alpha = 100;

      

        GlStateManager.pushMatrix();

        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);



        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();

        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();

        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();

        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();

        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.maxX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();

        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.minY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.maxZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos(bb.minX - mc.getRenderManager().viewerPosX, bb.maxY - mc.getRenderManager().viewerPosY, bb.minZ - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();

        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();

        GlStateManager.popMatrix();


    }


    public static void drawLine3D(float x, float y, float z, float x1, float y1, float z1, float thickness, int hex) {
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        float alpha = (hex >> 24 & 0xFF) / 255.0F;

        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
       // GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
       // GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(GL_SMOOTH);
        glLineWidth(thickness);
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        GlStateManager.disableDepth();
        glEnable(GL32.GL_DEPTH_CLAMP);
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(GL_LINES, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double) x - mc.getRenderManager().viewerPosX, (double) y  - mc.getRenderManager().viewerPosY, (double) z  - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos((double) x1 - mc.getRenderManager().viewerPosX, (double) y1  - mc.getRenderManager().viewerPosY, (double) z1  - mc.getRenderManager().viewerPosZ).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(GL_FLAT);
        glDisable(GL_LINE_SMOOTH);
        GlStateManager.enableDepth();
        glDisable(GL32.GL_DEPTH_CLAMP);
       // GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }

    public static void drawLine(float x, float y, float x1, float y1, float thickness, int hex) {
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        float alpha = 255;

        GlStateManager.pushMatrix();
        GlStateManager.disableTexture2D();
        //GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(GL_SMOOTH);
        glLineWidth(thickness);
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double) x, (double) y, (double) 0).color(red, green, blue, alpha).endVertex();
        bufferbuilder.pos((double) x1, (double) y1, (double) 0).color(red, green, blue, alpha).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(GL_FLAT);
        glDisable(GL_LINE_SMOOTH);
        //GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }


}
