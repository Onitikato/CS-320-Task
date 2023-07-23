import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class TaskServiceTest {
	@AfterEach
	void tearDown() throws Exception {
		TaskService.tasks.clear();
	}

	@DisplayName("Add a Task")
	@Test
	void testAddUniqueTask() {
        String id = "0";
      	String fullName = "Jeffrey Pritchett";
        String description = "This is a good description";
        
        TaskService tempTask = new TaskService();
        
        assertEquals(0, TaskService.tasks.size());
        
        tempTask.addUniqueTask(fullName, description);
       
		assertTrue(TaskService.tasks.containsKey(id));
		assertEquals(fullName, TaskService.tasks.get(id).getName());
		assertEquals(description, TaskService.tasks.get(id).getDescription());              
        
	}

	private void assertTrue(boolean containsKey) {

		
	}

	private void assertEquals(String fullName, String name) {
	
		
	}

	private void assertEquals(int i, int size) {
	
		
	}

	/**
	* Add 3 contacts via addTask delete object at id 1 check that there is no
	* object there
	*/
	@DisplayName("Test deleteContact")			  
	@Test void testDeleteTask() {
				  
      	String fullName = "Jeffrey Pritchett";
        String description = "This is a good description";
		  
        TaskService tempTask = new TaskService();
        
        assertEquals(0, TaskService.tasks.size());

        tempTask.addUniqueTask(fullName, description); //obj 0
        tempTask.addUniqueTask(fullName, description); //obj 1
        tempTask.addUniqueTask(fullName, description); //obj 2
		  
		assertEquals(3,TaskService.tasks.size());
		  
		tempTask.deleteTasks("1");
		  
		assertEquals(2,TaskService.tasks.size());
		assertFalse(TaskService.tasks.containsKey("1"));
			 
	}
	private void assertFalse(boolean containsKey) {
		
		
	}

	/*
	 * create a task and then update with good id
	 */
	@DisplayName("Test updateTask with a good ID")
	@Test
	void testUpdateTasks() {
		String id = "0";
		String fullName = "Jeffrey Pritchett";
        String description = "This is a good description";
		  
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, description); //obj 0

        tempTask.updateTasks("0", fullName, "New description");
        assertEquals("New description", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        
	}
	
	/*
	 * create a task and then update with bad id
	 */
	@DisplayName("Test updateTask with a bad ID")
	@Test
	void testBadUpdateTasks() {
		String id = "0";
		String fullName = "Jeffrey Pritchett";
        String description = "This is a good description";
		  
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, description); //obj 0

        tempTask.updateTasks("1", fullName, "New description");
        assertNotEquals("New description", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        
	}

	private void assertNotEquals(String string, String description) {
	
	}

}
