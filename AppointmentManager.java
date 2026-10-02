import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentManager {

    // Stores all appointments created during the current program session
    private List<Appointment> appointments;

    // Keeps track of the ID that will be given to the next appointment
    private int nextAppointmentID;

    // Constructor initializes an empty appointment list
    // and starts appointment IDs from 1
    public AppointmentManager() {
        appointments = new ArrayList<>();
        nextAppointmentID = 1;
    }

    // Creates a new appointment using the selected patient, doctor,
    // date, and time
    public Appointment createAppointment(Patient patient, Doctor doctor,
                                         LocalDate date, LocalTime time) {

        // Create a new Appointment object with the next available ID
        Appointment appointment = new Appointment(
                nextAppointmentID,
                patient,
                doctor,
                date,
                time
        );

        // Add the newly created appointment to the list
        appointments.add(appointment);

        // Increase the ID so the next appointment gets a different ID
        nextAppointmentID++;

        // Return the appointment that was just created
        return appointment;
    }

    // Returns the list of all appointments created so far
    public List<Appointment> getAppointments() {
        return appointments;
    }
}