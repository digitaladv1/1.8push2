package com.camp.event;

import com.camp.world.MapGenScatteredFeatureModBiomes;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MapGenHandler {

	@SubscribeEvent
	public void initMapGen(InitMapGenEvent event) {
		if (event.type == InitMapGenEvent.EventType.SCATTERED_FEATURE) {
			event.newGen = new MapGenScatteredFeatureModBiomes();
		}
	}
}