package com.joaodartora.core.challenge.parsers;

import java.util.ArrayList;
import java.util.List;

import com.joaodartora.core.challenge.model.Item;
import com.joaodartora.core.challenge.model.Sales;

public class SalesParser {

	private static final String ITEM_DELIMITER = ",";
	private static final String ITEM_PARTS_DELIMITER = "-";
	
	public Sales processSalesData (String lineReaded, String delimiter) {
		String[] lineParsed = lineReaded.split(delimiter);
		String item = lineParsed[2].substring(1, lineParsed[2].length()-1);			
		List<Item> listOfItems = new ArrayList<Item>();
			for(String it: item.split(ITEM_DELIMITER)) {
				String[] itemData = it.split(ITEM_PARTS_DELIMITER);
				listOfItems.add(new Item(Long.parseLong(itemData[0]), Long.parseLong(itemData[1]), Float.parseFloat(itemData[2])));
			}
		return new Sales(Long.parseLong(lineParsed[1]), listOfItems, lineParsed[3]);
	}
}
