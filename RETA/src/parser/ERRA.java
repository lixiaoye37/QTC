package parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ERRA {
	private HashMap<String, ArrayList<CityInfo>> TimeSchedule;

	@SuppressWarnings("deprecation")
	public ERRA(String FilePath) throws IOException {
		TimeSchedule = new HashMap<String, ArrayList<CityInfo>>();

		ArrayList<Date_Time> date_time = new ArrayList<>();
		ArrayList<LocationHistory> locationHistory = new ArrayList<>();

		File myFile = new File(FilePath);
		FileInputStream fis = new FileInputStream(myFile);

		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Traversing over each row of XLSX file
		int RowIndex = 0;
		for (Row row : mySheet) {
			if (RowIndex > 2) {
				String VARO = null;
				String State = null;
				int indexTracker = 0;
				ArrayList<Boolean> QtcAssignedSlot = new ArrayList<>();

				for (Cell cell : row) {
					if (indexTracker > 1) {
						boolean isQtc = (cell.getStringCellValue().toUpperCase().contains("QTC")) ? true : false;
						QtcAssignedSlot.add(isQtc);
					} else if (indexTracker == 0) {
						VARO = cell.getStringCellValue();
					} else if (indexTracker == 1) {
						State = cell.getStringCellValue();
					}
					indexTracker++;
				}

				if (!(VARO.isEmpty() || State.isEmpty())) {
					locationHistory.add(new LocationHistory(VARO, State, QtcAssignedSlot));
				}
			} else if (RowIndex == 1) {
				int SkipFirstTwo = 0;
				for (Cell cell : row) {
					if (SkipFirstTwo < 2) {
						SkipFirstTwo++;
						continue;
					}

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: {
						if (cell.getStringCellValue().contains("AM") || cell.getStringCellValue().contains("PM")) {
							String dateWithNoSpaces = cell.getStringCellValue().replaceAll(" ", "");
							int TimeOfDayIndex = (dateWithNoSpaces.length() - 1) - 1;
							String date = dateWithNoSpaces.substring(0, TimeOfDayIndex);
							String TimeOfDay = dateWithNoSpaces.substring(TimeOfDayIndex, dateWithNoSpaces.length());
							date_time.add(new Date_Time(date, TimeOfDay));
						} else {
							System.out.println(
									"MainActivity.java: error in switch case [Cell.CELL_TYPE_STRING]: not suppose to enter this branch. formatting issue");
							System.exit(1);
						}
					}
						break;

					case Cell.CELL_TYPE_NUMERIC: {
						if (DateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
							date_time.add(new Date_Time(dateFormat.format(cell.getDateCellValue())));
						} else {
							System.out.println(
									"MainActivity.java: error in switch case [Cell.CELL_TYPE_NUMERIC]: not suppose to enter this branch. formatting issue");
							System.exit(1);
						}
					}
						break;

					case Cell.CELL_TYPE_BLANK: {
						date_time.add(new Date_Time(date_time.get(date_time.size() - 1).Date));
					}
						break;
					}
				}
			} else if (RowIndex == 2) {
				int SkipFirstTwo = 0;
				int indexTracker = 0;

				for (Cell cell : row) {
					if (SkipFirstTwo < 2) {
						SkipFirstTwo++;
						continue;
					}

					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						date_time.get(indexTracker).TimeOfDay = cell.getStringCellValue();
					}
					indexTracker++;
				}
			}
			RowIndex++;
		}

		for (int i = 0; i < date_time.size(); i++) {
			Date_Time dateTime = date_time.get(i);
			String[] MonthDayYear = dateTime.Date.split("/");

			if (MonthDayYear[0].length() == 1) {
				MonthDayYear[0] = "0" + MonthDayYear[0];
			}

			if (MonthDayYear[1].length() == 1) {
				MonthDayYear[1] = "0" + MonthDayYear[1];
			}

			if (MonthDayYear[2].length() == 2) {
				MonthDayYear[2] = "20" + MonthDayYear[2];
			}

			String date = MonthDayYear[0] + "/" + MonthDayYear[1] + "/" + MonthDayYear[2];
			ArrayList<CityInfo> ListOfCities = new ArrayList<>();

			if (TimeSchedule.containsKey(date)) {
				ListOfCities = TimeSchedule.get(date);

				for (int LocationIndex = 0; LocationIndex < locationHistory.size(); LocationIndex++) {
					LocationHistory location = locationHistory.get(LocationIndex);
					CityInfo City = ListOfCities.get(LocationIndex);
					boolean isQtcAssigned = location.QtcAssignedSlot.get(i);

					if (isQtcAssigned == true) {
						City.IsQtcAssignedSlot = isQtcAssigned;
					}
				}
			} else {
				ListOfCities = new ArrayList<>();
				for (LocationHistory location : locationHistory) {
					String VARO = location.VARO;
					String State = location.State;

					boolean isQtcAssigned = location.QtcAssignedSlot.get(i);

					ListOfCities.add(new CityInfo(VARO, State, isQtcAssigned));
				}
				TimeSchedule.put(date, ListOfCities);
			}

		}

		myWorkBook.close();
	}

	public class CityInfo {
		private String VARO;
		private String State;
		private boolean IsQtcAssignedSlot;

		public CityInfo(String varo, String state, boolean isQtcAssignedSlot) {
			super();
			VARO = varo;
			State = state;
			IsQtcAssignedSlot = isQtcAssignedSlot;
		}

		public String getVARO() {
			return VARO;
		}

		public String getState() {
			return State;
		}

		public boolean isIsQtcAssignedSlot() {
			return IsQtcAssignedSlot;
		}
	}

	private class LocationHistory {
		private String VARO;
		private String State;

		private ArrayList<Boolean> QtcAssignedSlot;

		private LocationHistory(String VARO, String State, ArrayList<Boolean> QtcAssignedSlot) {
			this.VARO = VARO;
			this.State = State;
			this.QtcAssignedSlot = QtcAssignedSlot;
		}
	}
	
	public HashMap<String, ArrayList<CityInfo>> getTimeSchedule() {
		return TimeSchedule;
	}

	private class Date_Time {
		private String Date;
		private String TimeOfDay;

		private Date_Time(String Date) {
			this.Date = Date;
			this.TimeOfDay = null;
		}

		private Date_Time(String Date, String TimeOfDay) {
			this.Date = Date;
			this.TimeOfDay = TimeOfDay;
		}
	}
}
