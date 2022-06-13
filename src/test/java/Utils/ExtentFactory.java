package Utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent;
        String Path = "C://Users//bochandana//IdeaProjects//AllocationengineTask//target";
        extent = new ExtentReports(Path, false);

//this extent Factory used to run multiple testcases on a single run
        return extent;
    }
}
