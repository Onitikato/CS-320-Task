import java.util.HashMap;

public class TaskService {
int currentIDNum = 0; //pseudo GUID
	
	public static HashMap<String, task> tasks = new HashMap<String, task>();
	
	public void addUniqueTask(String _name, String _description) {

		String stringID = Integer.toString(currentIDNum);		
		task tempTask = new task (stringID, _name, _description);
		task.put(stringID, tempTask);	

		++currentIDNum;		
	}
	
	public void deleteTasks(String _ID) {
		
		if(task.containsKey(_ID)) {			
			task.remove(_ID);
		}		
	}
	
	public void updateTasks(String _ID, String _newName, String _newDescription) {
		
		if(task.containsKey(_ID)) {
			
			task.get(_ID).setName(_newName);
			task.get(_ID).setDescription(_newDescription);
		}
		
	}

}
