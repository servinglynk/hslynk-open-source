package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestCollection {

	public static void main(String args[]) {
		Map<UUID,List<UUID>> maps = new HashMap<>();
		List<UUID> values = new ArrayList<>();
		values.add(UUID.randomUUID());
		values.add(UUID.fromString("c7557ffa-6454-428a-9057-c7f886785acb"));
		values.add(UUID.randomUUID());
		maps.put(UUID.fromString("52a6ad2b-0e2e-487b-aa03-7cb7dd42a51d"), values);
		TestCollection col = new TestCollection();
		Map<UUID, List<UUID>> removeList = col.removeList(maps);
		List<UUID> list = removeList.get(UUID.fromString("52a6ad2b-0e2e-487b-aa03-7cb7dd42a51d"));
		for(UUID sr : list) {
			System.out.println(sr);
		}
	}
	
	private Map<UUID,List<UUID>> removeList(Map<UUID,List<UUID>> maps) {
		List<UUID> list = maps.get(UUID.fromString("52a6ad2b-0e2e-487b-aa03-7cb7dd42a51d"));
		list.remove(UUID.fromString("c7557ffa-6454-428a-9057-c7f886785acb"));
		return maps;
	}
}
