
public class task {
	private String uniqueID;
	private String fullName;
	private String description;

	
	public task(String stringID, String _name, String _description) {
	
	}

	/**
	 * validates the uniqueID
	 */
	private final boolean validateID(String uniqueID) {
		if(uniqueID == null || uniqueID.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	/**
	 * validates the Name
	 */
	private final boolean validateName(String fullName) {
		if(fullName == null || fullName.length() > 20 || fullName.equals("")) {
			return false;			
		}
		return true;
	}
	/**
	 * validates the description
	 */
	private final boolean validateDescription(String description) {
		if(description == null || description.length() > 50 || description.equals("")) {	
			return false;			
		}
		return true;
	}
	
	
	public void Task_DL(String uniqueID, 
			String fullName, 
			String description) {
		
		if(!this.validateID(uniqueID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		if(!this.validateDescription(description)) {
			throw new IllegalArgumentException("Invalid description");
		}		

		
		setID(uniqueID);
		setName(fullName);
		setDescription(description);

	}

	public int getUniqueID() {
		return Integer.valueOf(uniqueID);
	}

	
	private void setID(String uniqueID){ 
		this.uniqueID = uniqueID; 
	}
	 

	public String getName() {
		return fullName;
	}

	public void setName(String fullName) {
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.fullName = fullName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(!this.validateDescription(fullName)) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.description = description;
	}

	public static boolean containsKey(String _ID) {
		
		return false;
	}

	public static task get(String _ID) {
		
		return null;
	}

	public static void remove(String _ID) {
		
		
	}

	public static void put(String stringID, task tempTask) {
		
		
	}


}
