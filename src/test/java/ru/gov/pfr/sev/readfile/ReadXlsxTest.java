package ru.gov.pfr.sev.readfile;

import org.junit.jupiter.api.Test;
import ru.gov.pfr.sev.data.Persons;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadXlsxTest {

    @Test
    void readFromExcel() {
        ReadXlsx readXlsx = new ReadXlsx();
        try {
//            readXlsx.readFromExcel(new Persons(), "fileIn/??? ?? ??????????? ?? 58 ???. ?? 04.04.2022.xlsx");
            readXlsx.read("fileIn/ПФ  129 человек.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }

        readXlsx.getPersons().getPersons().stream().forEach(System.out::println);

    }
}