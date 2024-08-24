package Project.StudentManagement1.response;

public class StudentResponse {
	
	 private Long id;
	    private String message;
	    

	    public StudentResponse(Long id, String message) {
	        this.id = id;
	        this.message = message;
	       
	    }


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	    
	    

}
