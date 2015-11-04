/*package com.camp.client.cape;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.camp.Logger;
import com.example.examplemod.cm;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class CapeUtils {
	public static Boolean debug = true;
	public static final ResourceLocation CAPE_LOCATION = new ResourceLocation(cm.MODID, "textures/capes/cm.png");
	public static final UUID UUID_CHOONSTER = UUID.fromString("97c6aa3f-72b0-4ba4-9996-0a51b17f5adf");

	// Copied from SkinManager
	private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());

	*//**
	 * Queue the replacement of a player's cape with the TestMod3 cape.
	 * <p>
	 * In at least 100 milliseconds, the player's cape will be replaced on the next iteration of the client's main loop.
	 *
	 * @param player The player
	 *//*
	public static void queuePlayerCapeReplacement(AbstractClientPlayer player) {
		final String displayName = player.getDisplayNameString();

		Logger.info("Queueing cape replacement for %s", displayName);

		THREAD_POOL.submit(() -> {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Logger.fatal(e, "Cape delay thread for %s interrupted", displayName);
				return;
			}

			Minecraft.getMinecraft().addScheduledTask(() -> replacePlayerCape(player));
		});
	}

	*//**
	 * Replace a player's cape with the TestMod3 cape.
	 *
	 * @param player The player
	 *//*
	public static void replacePlayerCape(AbstractClientPlayer player) {
		String displayName = player.getDisplayNameString();

		NetworkPlayerInfo playerInfo;

		try {
			playerInfo = (NetworkPlayerInfo) ReflectionHelper.findMethod(AbstractClientPlayer.class, player, new String[]{"getPlayerInfo", "func_175155_b"}).invoke(player);
		} catch (IllegalAccessException | InvocationTargetException e) {
			Logger.fatal(e, "Failed to get NetworkPlayerInfo of %s", displayName);
			return;
		}

		if (playerInfo == null) {
			Logger.fatal("NetworkPlayerInfo of %s is null", displayName);
			return;
		}

		ReflectionHelper.setPrivateValue(NetworkPlayerInfo.class, playerInfo, CAPE_LOCATION, "locationCape", "field_178862_f");
		Logger.info("Replaced cape of %s!", displayName);
		
		if(debug.equals(true)){
			return;
		}
	}
	

	*//**
	 * Does the player have a TestMod3 cape?
	 * <p>
	 * Currently only returns true for me (Choonster)
	 *
	 * @param player The player
	 * @return True if the player has a TestMod3 cape
	 *//*
	public static boolean doesPlayerHaveCape(AbstractClientPlayer player) {
		return player.getUniqueID().equals(UUID_CHOONSTER);
	}
}*/