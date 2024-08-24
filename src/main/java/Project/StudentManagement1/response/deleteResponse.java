package Project.StudentManagement1.response;

public class deleteResponse {
	
	private String message;
	private String studentName;
	
	

	public deleteResponse(String message, String studentName) {
		super();
		this.message = message;
		this.studentName = studentName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	

}

