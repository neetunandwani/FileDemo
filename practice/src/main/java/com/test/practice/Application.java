package com.test.practice;

import com.test.practice.enums.FileType;
import com.test.practice.pojo.SummaryRow;
import com.test.practice.services.CSVFileService;
import com.test.practice.services.FileFactory;
import com.test.practice.services.FileService;
import com.test.practice.services.SummaryReportService;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        FileService fileService = FileFactory.getFileService(FileType.XLX, "transactions.xlsx");
        CSVFileService service = (CSVFileService) FileFactory.getFileService(FileType.CSV, "result.xlsx");
        List<SummaryRow> summaryRows = SummaryReportService.getInstance().generateReport(fileService.read());
        service.write("result.csv", summaryRows);
    }
}
