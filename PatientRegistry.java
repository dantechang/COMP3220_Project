import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PatientRegistry {

    // Stores every registered patient, keyed by patient ID for fast lookup
    private Map<Integer, Patient> patients;

    // Keeps track of the ID that will be given to the next patient
    private int nextId;

    // Constructor initializes an empty registry; patient IDs start at 1
    public PatientRegistry() {
        patients = new HashMap<>();
        nextId = 1;
    }

    // Assigns the next available ID, creates the Patient and stores it.
    // If the details are invalid, the Patient constructor throws an
    // IllegalArgumentException and the ID is not used up.
    public Patient registerPatient(String firstName, String lastName, LocalDate dateOfBirth,
                                   String phone, String email) {

        Patient patient = new Patient(nextId, firstName, lastName, dateOfBirth, phone, email);
        patients.put(nextId, patient);
        nextId++;
        return patient;
    }
}
