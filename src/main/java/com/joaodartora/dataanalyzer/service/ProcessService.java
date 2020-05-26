package com.joaodartora.dataanalyzer.service;

import com.joaodartora.dataanalyzer.file.Reader;
import com.joaodartora.dataanalyzer.file.Writer;
import com.joaodartora.dataanalyzer.model.AnalyzedData;
import com.joaodartora.dataanalyzer.model.BaseModel;

import java.util.List;

public class ProcessService {

    private static final Reader reader = new Reader();
    private static final Writer writer = new Writer();
    private static final AnalysisService analysisService = new AnalysisService();
    private static final ParseService parseService = new ParseService();

    public static void processFile(String fileName) {
        List<String> fileLines = reader.read(fileName);
        List<BaseModel> parsedData = parseService.parseLinesAccordingToType(fileLines);
        AnalyzedData analyzedData = analysisService.getAnalyzedData(parsedData);
        writer.writeOutputFile(analyzedData, fileName);
    }
}
