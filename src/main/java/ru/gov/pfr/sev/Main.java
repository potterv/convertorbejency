package ru.gov.pfr.sev;

import ru.gov.pfr.sev.data.Persons;
import ru.gov.pfr.sev.readfile.ReadXlsx;
import ru.gov.pfr.sev.writefile.WriteXlsx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        ReadXlsx readXlsx = new ReadXlsx();
        WriteXlsx writeXlsx = new WriteXlsx();
        for ( Path filename: Files.walk(Paths.get("fileIn"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList())
             ) {
            System.out.println(filename.toFile().getCanonicalPath());

            readXlsx.read(filename.toFile().getCanonicalPath());

            }
        writeXlsx.saveInFileMic(readXlsx.getPersons(), "fileOut/92_sqlreq_001_.xlsx");
    }
}
