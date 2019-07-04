package com.joaodartora.core.temafinal.parsers;

import com.joaodartora.core.temafinal.model.Salesman;

public class SalesmanParser {

	public Salesman processSalesmanData (String lineReaded, String delimiter) {
		String[] lineParsed = lineReaded.split(delimiter);
		return new Salesman(lineParsed[1], lineParsed[2], Float.parseFloat(lineParsed[3]));
	}
}
