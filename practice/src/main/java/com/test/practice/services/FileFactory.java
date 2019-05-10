package com.test.practice.services;

import com.test.practice.enums.FileType;

public class FileFactory {
    public static FileService getFileService(FileType fileType, String name) {
        switch (fileType) {
            case CSV:
                return new CSVFileService(name);
            case XLX:
                return new ExcelFileService(name);
            default:
                return new CSVFileService(name);
        }
    }
}
