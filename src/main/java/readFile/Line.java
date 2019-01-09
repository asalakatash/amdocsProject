package readFile;

public class Line {

	//private String content = null;
	private String appName = null;
	private String appType = null;
	private String errorCode = null;	
	private String severity = null;	
	private String solution = null;
	
	
	public Line() {
		super();	
	}


	public Line(String appName, String appType, String errorCode, String severity, String solution) {
		super();
	//	this.content = content;
		this.appName = appName;
		this.appType = appType;
		this.errorCode = errorCode;
		this.severity = severity;
		this.solution = solution;
	}

	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppType() {
		return appType;
	}


	public void setAppType(String appType) {
		this.appType = appType;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getSolution() {
		return solution;
	}


	public void setSolution(String solution) {
		this.solution = solution;
	}
	
}
