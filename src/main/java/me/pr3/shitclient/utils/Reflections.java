package me.pr3.shitclient.utils;

import com.mojang.authlib.GameProfile;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.network.handshake.NetworkDispatcher;
import org.apache.commons.lang3.ClassUtils;

import java.nio.charset.Charset;
import java.util.*;

public class Reflections {

    public static HashMap<String, String[]> dumpPacket(Packet<?> packet) {

        HashMap<String, String[]> fieldsSerialized = new HashMap<>();

        Arrays.asList(packet.getClass().getDeclaredFields()).forEach(field -> {

            Object value;
            field.setAccessible(true);

            try {
                value = field.get(packet);
            } catch (IllegalAccessException e) {
                Log.warn("Unable to parse field " + field.getName() + " (" + field.getType().getTypeName() + ") of packet " + packet.toString());
                Log.warn(e.getMessage());
                return;
            }

            if (value == null) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), "null"});
            } else if (value instanceof byte[]) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((byte[]) value).length > 256 ? "cropped to 256 bytes: " + new String(Arrays.copyOfRange((byte[]) value, 0, 255)) + "..." : new String((byte[]) value)});
            } else if (value.getClass().isArray()) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), String.valueOf(value)});
            } else if (ClassUtils.isPrimitiveOrWrapper(field.getType())) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof Collection) { // TODO: dump entry values
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof Map) { // TODO: dump entry values
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof Enum) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof WorldType) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((WorldType) value).getId() + " " + ((WorldType) value).getName()});
            } else if (value instanceof GameProfile) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof UUID) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), value.toString()});
            } else if (value instanceof String) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), (String) value});
            } else if (value instanceof ByteBuf) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((ByteBuf) value).toString(Charset.defaultCharset())});
            } else if (value instanceof ChunkPos) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((ChunkPos) value).toString()});
            } else if (value instanceof BlockPos) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((BlockPos) value).toString()});
            } else if (value instanceof Vec3d) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((Vec3d) value).toString()});
            } else if (value instanceof IBlockState) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((IBlockState) value).getBlock().toString()});
            } else if (value instanceof SoundEvent) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((SoundEvent) value).getSoundName().toString()});
            } else if (value instanceof ItemStack) {
                ItemStack stack = ((ItemStack) value);
                NBTTagCompound nbt = stack.getTagCompound();
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), stack.toString() + (stack.hasTagCompound() && nbt != null ? " " + nbt.toString() : "")});
            } else if (value instanceof ServerStatusResponse) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((ServerStatusResponse) value).getJson()});
            } else if (value instanceof ITextComponent) {
                fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), ((ITextComponent) value).getFormattedText()});
            } else //noinspection StatementWithEmptyBody
                if (value instanceof EntityDataManager || value instanceof NetworkDispatcher) {
                    // ignored
                } else {
                    fieldsSerialized.put(field.getName(), new String[]{field.getType().getTypeName(), "not implemented"});
                }

        });

        return fieldsSerialized;

    }

}
