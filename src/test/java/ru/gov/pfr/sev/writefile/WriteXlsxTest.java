package ru.gov.pfr.sev.writefile;

import org.junit.jupiter.api.Test;
import ru.gov.pfr.sev.data.Persons;

import static org.junit.jupiter.api.Assertions.*;

class WriteXlsxTest {

    @Test
    void saveInFileMic() {
        WriteXlsx writeXlsx = new WriteXlsx();
        writeXlsx.saveInFileMic(new Persons(), "92_sqlreq_001.xlsx");
    }
}