package com.test.practice.services;

import com.test.practice.adaptors.TransactionDataAdaptor;
import com.test.practice.pojo.Transaction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelFileService extends FileService {
    ExcelFileService(String name) {
        super(name);
    }

    @Override
    public boolean isValid(String fileName) {
        return fileName.endsWith(".xlx") || fileName.endsWith(".xlsx");
    }

    @Override
    public List<Transaction> read() throws IOException {
        List<Transaction> transactions = Collections.emptyList();
        if (isValid(getName())) {
            XSSFWorkbook workbook = new XSSFWorkbook(getFile());
            XSSFSheet sheet = workbook.getSheetAt(0);
            IntStream intStream = IntStream.range(1, sheet.getLastRowNum() + 1);
            transactions = intStream.mapToObj(i -> new TransactionDataAdaptor(getData(sheet.getRow(i).cellIterator()))).collect(Collectors.toList());

        }
        return transactions;
    }

    private String[] getData(Iterator<Cell> cellIterator) {
        ArrayList<String> arrayList = new ArrayList();
        while (cellIterator.hasNext()) {
            arrayList.add(convert(cellIterator.next()));
        }
        String[] strings = new String[arrayList.size()];
        return arrayList.toArray(strings);
    }

    private String convert(Cell cell) {
        switch (cell.getColumnIndex()) {
            case 0:
            case 1:
            case 2:
            case 4:
            default:
                return cell.getStringCellValue();
            case 3:
                return cell.getDateCellValue().toInstant().toString();
        }
    }
}
