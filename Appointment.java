import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    // Appointment details
    private int appointmentID;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;

    // Constructor
    public Appointment(int appointmentID, Patient patient, Doctor doctor,
                       LocalDate date, LocalTime time) {

        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    // Getter methods
    public int getAppointmentID() {
        return appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    // Displays appointment information
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentID +
               "\nPatient: " + patient +
               "\nContact: " + patient.getPhone() + (patient.getEmail().isEmpty() ? "" : ", " + patient.getEmail()) +
               "\nDoctor: " + doctor +
               "\nDate: " + date +
               "\nTime: " + time;
    }
}
