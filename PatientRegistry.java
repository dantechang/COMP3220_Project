import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // Returns the patient with that ID, or null if not registered
    public Patient findById(int patientId) {
        return patients.get(patientId);
    }

    // Returns every registered patient for the list view, ordered by ID
    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>(patients.values());
        list.sort((a, b) -> Integer.compare(a.getPatientId(), b.getPatientId()));
        return list;
    }
}
