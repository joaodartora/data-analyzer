package com.joaodartora.dataanalyzer.parser.factory;

import com.joaodartora.dataanalyzer.parser.BaseParser;
import com.joaodartora.dataanalyzer.parser.CustomerParser;
import com.joaodartora.dataanalyzer.parser.SalesParser;
import com.joaodartora.dataanalyzer.parser.SalesmanParser;

import java.util.stream.Stream;

public class ParserFactory {

    private CustomerParser customerParser;
    private SalesmanParser salesmanParser;
    private SalesParser salesParser;

    public ParserFactory() {
        customerParser = new CustomerParser();
        salesmanParser = new SalesmanParser();
        salesParser = new SalesParser();
    }

    public Stream<BaseParser> get() {
        return Stream.of(customerParser, salesmanParser, salesParser);
    }
}
