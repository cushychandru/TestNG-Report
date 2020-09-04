package report_genarator;

import java.util.ArrayList;

public class Report {
	public String _count;
	public String _class;
	public String _mothod;
	public String _time;
	public String _status;
	public String _exception;	
	
	public static ArrayList<Report> report =new ArrayList<Report>();

	/**
	 * Instantiates a new report.
	 *
	 * @param _count the count
	 * @param _class the class
	 * @param _mothod the mothod
	 * @param _time the time
	 * @param _status the status
	 * @param _exception the exception
	 */
	public Report(String _count, String _class, String _mothod, String _time, String _status, String _exception) {
		super();
		this._count = _count;
		this._class = _class;
		this._mothod = _mothod;
		this._time = _time;
		this._status = _status;
		this._exception = _exception;
	}

	public Report() {
		
	} 

}
