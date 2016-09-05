package testingFramework;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Reporting {

	public void generateHTMLreport(String pathToReports) throws IOException, WriteException {
		// îòêðûòü íîâûé ôàéë äëÿ çàïèñè
		// ïîëíûé ïóòü ê ýòîìó ôàéëó âûãëÿäåò òàê: pathToReports + "testReport"
		// + yyyymmddhhss
		String fullPathToFile = pathToReports + ""; // îò ñþäà
													// https://docs.oracle.com/javase/tutorial/datetime/iso/datetime.html

		WritableWorkbook myWorkbook;
		myWorkbook = Workbook.createWorkbook(new File(fullPathToFile));
		WritableSheet mySheet1 = myWorkbook.createSheet("Simple scenarios", 0);
		WritableSheet mySheet2 = myWorkbook.createSheet("Complex scenarios", 1);
		WritableFont cellFormat1 = new WritableFont(WritableFont.TIMES, 14);
		WritableCellFormat cellFormat = new WritableCellFormat(cellFormat1);
		cellFormat.setBorder(Border.ALL, BorderLineStyle.THICK);
		cellFormat.setLocked(false);
		cellFormat.setAlignment(Alignment.CENTRE);

		// create cells, width
		int col = 1;
		int widthInChars = 107;
		mySheet1.setColumnView(col, widthInChars);
		mySheet2.setColumnView(col, widthInChars);
		mySheet1.addCell(new Label(col, 1, "A", cellFormat));
		mySheet2.addCell(new Label(col, 1, "B", cellFormat));

		// enter content(labels) of heders
		Label label1 = new Label(0, 0, "Number", cellFormat);
		Label label2 = new Label(1, 0, "Test case name", cellFormat);
		Label label3 = new Label(2, 0, "Result", cellFormat);
		Label label11 = new Label(0, 0, "Number", cellFormat);
		Label label21 = new Label(1, 0, "Test case name", cellFormat);
		Label label31 = new Label(2, 0, "Result", cellFormat);

		Label label_1 = new Label(0, 1, "1", cellFormat);
		mySheet1.addCell(label_1);
		Label label_21 = new Label(1, 1, "Check all airports", cellFormat);
		mySheet1.addCell(label_21);

		Label label_2 = new Label(0, 2, "2", cellFormat);
		mySheet1.addCell(label_2);
		Label label_22 = new Label(1, 2, "Check flight numbers", cellFormat);
		mySheet1.addCell(label_22);

		Label label_3 = new Label(0, 3, "3", cellFormat);
		mySheet1.addCell(label_3);
		Label label_23 = new Label(1, 3, "Check unic airlines", cellFormat);
		mySheet1.addCell(label_23);

		Label label_4 = new Label(0, 4, "4", cellFormat);
		mySheet1.addCell(label_4);
		Label label_24 = new Label(1, 4, "Check airports with duty free", cellFormat);
		mySheet1.addCell(label_24);

		Label label_5 = new Label(0, 5, "5", cellFormat);
		mySheet1.addCell(label_5);
		Label label_25 = new Label(1, 5, "Check airports without priority boarding", cellFormat);
		mySheet1.addCell(label_25);

		Label label_6 = new Label(0, 6, "6", cellFormat);
		mySheet1.addCell(label_6);
		Label label_26 = new Label(1, 6, "Check all flight number from London", cellFormat);
		mySheet1.addCell(label_26);

		Label label_7 = new Label(0, 7, "7", cellFormat);
		mySheet1.addCell(label_7);
		Label label_27 = new Label(1, 7, "Check all from Prague to Kiev", cellFormat);
		mySheet1.addCell(label_27);

		Label label_8 = new Label(0, 8, "8", cellFormat);
		mySheet1.addCell(label_8);
		Label label_28 = new Label(1, 8, "Check flight numbers from New York to Helsinki witch coast more then 100",
				cellFormat);
		mySheet1.addCell(label_28);

		Label label_9 = new Label(0, 9, "9", cellFormat);
		mySheet1.addCell(label_9);
		Label label_29 = new Label(1, 9, "Check all cities (departure and arrival) whitch flying without stops",
				cellFormat);
		mySheet1.addCell(label_29);

		Label label_10 = new Label(0, 10, "10", cellFormat);
		mySheet1.addCell(label_10);
		Label label_30 = new Label(1, 10, "Check all names of airlines", cellFormat);
		mySheet1.addCell(label_30);

		Label label_11 = new Label(0, 11, "11", cellFormat);
		mySheet1.addCell(label_11);
		Label label_31 = new Label(1, 11, "Check airlines without web registration", cellFormat);
		mySheet1.addCell(label_31);

		Label label_12 = new Label(0, 12, "12", cellFormat);
		mySheet1.addCell(label_12);
		Label label_32 = new Label(1, 12, "Check airlines and numbers without additional space service", cellFormat);
		mySheet1.addCell(label_32);

		Label label_13 = new Label(0, 13, "13", cellFormat);
		mySheet1.addCell(label_13);
		Label label_33 = new Label(1, 13, "Check airlines and flight numbers where meal included", cellFormat);
		mySheet1.addCell(label_33);

		Label label_14 = new Label(0, 14, "14", cellFormat);
		mySheet1.addCell(label_14);
		Label label_34 = new Label(1, 14, "Check all flight numbers of Virgin company where meal included on board",
				cellFormat);
		mySheet1.addCell(label_34);

		Label label_15 = new Label(0, 15, "15", cellFormat);
		mySheet1.addCell(label_15);
		Label label_35 = new Label(1, 15,
				"Check all flight numbers of Wizzair company where meal included on board, exist additional space service and is web registration",
				cellFormat);
		mySheet1.addCell(label_35);

		Label label_36 = new Label(0, 1, "1", cellFormat);
		mySheet2.addCell(label_36);
		Label label_37 = new Label(1, 1, "Check all airlines from Beijing to Helsinki", cellFormat);
		mySheet2.addCell(label_37);

		Label label_38 = new Label(0, 2, "2", cellFormat);
		mySheet2.addCell(label_38);
		Label label_39 = new Label(1, 2, "Check all arrival airports from Kiev with web registration and duty free",
				cellFormat);
		mySheet2.addCell(label_39);

		Label label_40 = new Label(0, 3, "3", cellFormat);
		mySheet2.addCell(label_40);
		Label label_41 = new Label(1, 3,
				"Check all airlines with priority boerding quontity seats more then 50 and without meal on the board",
				cellFormat);
		mySheet2.addCell(label_41);

		Label label_42 = new Label(0, 4, "4", cellFormat);
		mySheet2.addCell(label_42);
		Label label_43 = new Label(1, 4, "story 1", cellFormat);
		mySheet2.addCell(label_43);

		Label label_44 = new Label(0, 5, "5", cellFormat);
		mySheet2.addCell(label_44);
		Label label_45 = new Label(1, 5, "story 2", cellFormat);
		mySheet2.addCell(label_45);

		Label label_46 = new Label(0, 6, "6", cellFormat);
		mySheet2.addCell(label_46);
		Label label_47 = new Label(1, 6, "story 3", cellFormat);
		mySheet2.addCell(label_47);

		// get results
		mySheet1.addCell(label1);
		mySheet1.addCell(label2);
		mySheet1.addCell(label3);

		mySheet2.addCell(label11);
		mySheet2.addCell(label21);
		mySheet2.addCell(label31);

		// close processes
		myWorkbook.write();
		myWorkbook.close();

	}

}
