package appointmentService;

import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
	
int currentIDNum = 0;
	
	public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	public String addUniqueAppointment(Date _date, String _description) {

		String stringID = Integer.toString(currentIDNum);		
		Appointment tempAppointment = new Appointment (stringID, _date, _description);
		appointments.put(stringID, tempAppointment);	

		++currentIDNum;
		return stringID;		
	}
	
	public void deleteAppointment(String _ID) {
		
		if(appointments.containsKey(_ID)) {			
			appointments.remove(_ID);
		}		
	}
	
}
