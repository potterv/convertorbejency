package ru.gov.pfr.sev.readfile;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.LocalDate;

import ru.gov.pfr.sev.data.Person;
import ru.gov.pfr.sev.data.Persons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReadXlsx {

    private Persons persons;

    public ReadXlsx() {
        this.persons = new Persons();
    }

//    public void readFromExcel(Persons persons, String file) throws IOException {
//        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
//        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
//        Person person;
//        List<Person> pers = new ArrayList<>();
//        Iterator<Row> it = myExcelSheet.iterator();
//
//        persons = new Persons();
////        int i = 0;
//        while (it.hasNext()) {
//            Row row = it.next();
//            person = new Person();
//
//            if (row.getRowNum() > 8 && !row.equals(null)) {
////                System.out.println(row.getRowNum());
//
//                if (row.getCell(0).getCellType() == CellType.NUMERIC) {
//
////                    person.setId(row.getCell(0));
//                }
//                if (row.getCell(1).getCellType() == CellType.STRING) {
//                    person.setFa(row.getCell(1).getStringCellValue().split(" ")[0]);
//
//                }
//
//                if (row.getCell(1).getCellType() == CellType.STRING) {
//                    person.setIm(row.getCell(1).getStringCellValue().split(" ")[1]);
//
//                }
//                if (row.getCell(1).getCellType() == CellType.STRING) {
//                    person.setOt(row.getCell(1).getStringCellValue().split(" ")[2]);
//
//                }
//
//
//                if (row.getCell(4).getCellType() == CellType.STRING) {
//                    person.setVidDoc(row.getCell(4).getStringCellValue());
//
//                }
//                if (row.getCell(5).getCellType() == CellType.STRING) {
//                    person.setSerNumDoc(row.getCell(5).getStringCellValue());
//
//                }
//                if (row.getCell(6).getCellType() == CellType.NUMERIC) {
//                    person.setDateVydachi(row.getCell(6).getNumericCellValue());
//
//                }
//                if (row.getCell(7).getCellType() == CellType.STRING) {
//                    person.setKemVydan(row.getCell(7).getStringCellValue());
//
//                }
////                    System.out.println(person);
//
////                    persons.addPerson(person);
//                if (!row.getCell(1).equals(null)) {
//                    pers.add(person);
//                    System.out.println(person);
//                } else {
//                    break;
//                }
//
//
//            }
//        }
//        System.out.println(pers);
//
//        myExcelBook.close();
//
//    }

    public void read(String file) throws IOException {
        XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
        Person person;
        List<Person> pers = new ArrayList<>();
        Iterator<Row> it = myExcelSheet.iterator();
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd-mm-yyyy");

        while (it.hasNext()) {
            Row row = it.next();
            person = new Person();
            if (row.getRowNum() > 8 && !row.equals(null)) {
                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    if (cell.getColumnIndex() >= 0 && cell.getColumnIndex() <= 7) {
                        if (cell.getColumnIndex() == 0 && cell.getCellType() == CellType.NUMERIC) {

                            person.setId((int) cell.getNumericCellValue());
                        }


                        if (cell.getColumnIndex() == 1 && cell.getCellType() == CellType.STRING) {

                            person.setFa(cell.getStringCellValue().split(" ")[0]);
                        }
                        if (cell.getColumnIndex() == 1 && cell.getCellType() == CellType.STRING) {

                            person.setIm(cell.getStringCellValue().split(" ")[1]);
                        }
                        if (cell.getColumnIndex() == 1 && cell.getCellType() == CellType.STRING) {
                            if (cell.getStringCellValue().split(" ").length == 3) {
                                person.setOt(cell.getStringCellValue().split(" ")[2]);
                            } else {
                                person.setOt(" ");
                            }

                        }
                        if (cell.getColumnIndex() == 2 && cell.getCellType() == CellType.NUMERIC) {

                            person.setDr(LocalDate.fromDateFields(cell.getDateCellValue()));
                        }

                        if (cell.getColumnIndex() == 4 && cell.getCellType() == CellType.STRING) {

                            person.setVidDoc(cell.getStringCellValue());
                        }
                        if (cell.getColumnIndex() == 5 && cell.getCellType() == CellType.STRING) {

                            person.setSerNumDoc(cell.getStringCellValue());
                        }
                        if (cell.getColumnIndex() == 6 && cell.getCellType() == CellType.NUMERIC) {

                            person.setDateVydachi(LocalDate.fromDateFields(cell.getDateCellValue()));
                        }
                        if (cell.getColumnIndex() == 7 && cell.getCellType() == CellType.STRING) {

                            person.setKemVydan(cell.getStringCellValue());
                        }
                    }else{continue;}
                }

//                this.persons.addPerson(person);
//                System.out.println(person);
                    if (
                            person.getId() != null &&
                                    person.getFa() != "null" &&
                                    person.getIm() != "null" &&
                                    person.getOt() != "null" &&
                                    person.getDr() != null
//                                person.getAddr() != "null" &&
//                                person.getVidDoc() != "null" &&
//                                person.getSerNumDoc() != "null" &&
//                                person.getDateVydachi() != null &&
//                                person.getKemVydan() != "null"
                    ) {

                        System.out.println(person);
                        this.persons.addPerson(person);
                    }
//                if (
//                        person.getId() == Integer.getInteger("null") &&
//                                person.getFa() == "null" &&
//                                person.getIm() == "null" &&
//                                person.getOt() == "null" &&
//                                person.getDr()==null &&
//                                person.getAddr() == "null" &&
//                                person.getVidDoc() != "null" &&
//                                person.getSerNumDoc() != "null" &&
//                                person.getDateVydachi()!=null &&
//                                person.getKemVydan() != "null") {
//
//                    System.out.println(person);
//                    this.persons.addPerson(person);
//                }
                }
            }
        }


    public Persons getPersons() {
        return persons;
    }
}
