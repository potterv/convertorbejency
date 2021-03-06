package ru.gov.pfr.sev.writefile;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.gov.pfr.sev.data.Person;
import ru.gov.pfr.sev.data.Persons;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteXlsx {

    public void saveInFileMic(Persons persons, String fileName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("001");
        Row row;
        int i = 0;
        int j = 1;
        for (Person person : persons.getPersons()
        ) {
//            if (
//                    person.getId() != Integer.getInteger("null") &&
//                            person.getFa() != "null" &&
//                            person.getIm() != "null" &&
//                            person.getOt() != "null" &&
////                                person.getDr() != "null" &&
//                            person.getAddr() != "null" &&
//                            person.getVidDoc() != "null" &&
//                            person.getSerNumDoc() != "null" &&
//                            person.getKemVydan() != "null") {
            row = sheet.createRow(i);
            System.out.println(j);
//                if (person.getId()!=null)
            row.createCell(0).setCellValue(j);

            row.createCell(1).setCellValue(person.getFa());

            row.createCell(2).setCellValue(person.getIm());

            row.createCell(3).setCellValue(person.getOt());
//                if (person.getDateVydachi()!=null)
            row.createCell(4).setCellValue(person.getDr().toDate());

//                row.createCell(5).setCellValue(person.getAddr());

            row.createCell(5).setCellValue(person.getVidDoc());

            row.createCell(6).setCellValue(person.getSerNumDoc());

//                if (person.getDateVydachi()!=null)
            row.createCell(7).setCellValue(person.getDateVydachi().toDate());

            row.createCell(8).setCellValue(person.getKemVydan());
//            }
            i++;
            ++j;
        }
        System.out.println("count Row "+j);
        try {
            workbook.write(new FileOutputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
