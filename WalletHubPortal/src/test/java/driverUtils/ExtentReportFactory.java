package driverUtils;
import java.util.Date;
import driverUtils.ExtentReportFactory;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportFactory {

	//Generate Extent Report
	static String path =null;
	public static ExtentReports getInstance() {
		ExtentReports reports;
		path = getReportName();
		setPath(path);
		reports = new ExtentReports(path, false);
		return reports;
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		ExtentReportFactory.path = path;
	}

	public static String getCurrentDateAndTime() {
		Date date = new Date();
		String date1 = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
		System.out.println(date1);
		return date1;
	}

	public static String getReportName() {
		String name = "reports//report_" + getCurrentDateAndTime() + ".html";
		return name;
	}

	public static String getLogName(String logName) {
		String name = "reports//" + logName + "_" + getCurrentDateAndTime() + ".txt";
		return name;
	}

}
