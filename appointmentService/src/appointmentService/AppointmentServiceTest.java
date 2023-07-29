package appointmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

	@AfterEach
	void tearDown() throws Exception {
		AppointmentService.appointments.clear();
	}

	@DisplayName("Add an Appointment")
	@Test
	void testAddUniqueAppt() {
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		String id = tempAppt.addUniqueAppointment(goodDate, description);

		assertTrue(AppointmentService.appointments.containsKey(id));
		assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
		assertEquals(description, AppointmentService.appointments.get(id).getDescription());
	}

	@DisplayName("Add a bad Appointment w/ empty desc")
	@Test
	void testAddEmptyDesc() {
		String description = ""; // bad description
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppt.addUniqueAppointment(goodDate, description);
		});

		assertEquals("Invalid description", exception.getMessage());
	}

	@DisplayName("Add a bad Appointment w/ null desc")
	@Test
	void testAddNullDesc() {
		String description = null; // bad description
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			tempAppt.addUniqueAppointment(goodDate, description);
		});

		assertEquals("Invalid description", exception.getMessage());
	}

	/*
	 * Add 3 appointments via addAppt, delete the appointment at id 1, and check that
	 * there is no appointment with id 1.
	 */
	@DisplayName("Test deleteAppt")
	@Test
	void testDeleteAppt() {
		String description = "This is a good description";
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 05);
		c.set(Calendar.YEAR, 2025);
		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		String id1 = tempAppt.addUniqueAppointment(goodDate, description); // obj 0
		tempAppt.addUniqueAppointment(goodDate, description);
		tempAppt.addUniqueAppointment(goodDate, description);

		assertEquals(3, AppointmentService.appointments.size());

		tempAppt.deleteAppointment(id1);

		assertEquals(2, AppointmentService.appointments.size());
		assertFalse(AppointmentService.appointments.containsKey(id1));

		tempAppt.deleteAppointment(id1); // Deleting again should have no effect
		assertEquals(2, AppointmentService.appointments.size());
	}
}
