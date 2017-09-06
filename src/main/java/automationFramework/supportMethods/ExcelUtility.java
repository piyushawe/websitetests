package automationFramework.supportMethods;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static automationFramework.supportMethods.GenericObjects.f;

public class ExcelUtility {
    ReadFile readfile= new ReadFile();

    public ArrayList<String> readExcel() throws IOException {
        File file = new File(readfile.readProperty(f, "schooldomainsfilepath"));
        FileInputStream fin = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(fin);
        Sheet sheet = workbook.getSheet(readfile.readProperty(f, "readsheet"));
        int rcount = sheet.getPhysicalNumberOfRows();
        //System.out.println(rcount);
        Row row= sheet.getRow(1);
        Cell cell;
        int cellcount= row.getLastCellNum();
        //System.out.println(cellcount);
        ArrayList<String> list= new ArrayList<String>();
        for (int i=1; i<rcount; i++) {
            row= sheet.getRow(i);
            for (int j = 0; j < cellcount; j++) {
                cell = row.getCell(j);
                list.add(cell.getStringCellValue());
            }
        }
        /*for (String str:list){
            System.out.println(str);
        }*/
        return list;
    }
}
