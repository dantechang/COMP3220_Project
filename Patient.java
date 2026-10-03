import java.time.LocalDate;

public class Patient {

    // private variables with scope of class only for encapsulation
    private int patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;

    // Registers a new patient; an empty name or phone is rejected
    public Patient(int patientId, String firstName, String lastName,
                   LocalDate dateOfBirth, String phone, String email) {

        if (isBlank(firstName) || isBlank(lastName)) {
            throw new IllegalArgumentException("First and last name cannot be empty");
        }
        if (isBlank(phone)) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }

        this.patientId = patientId;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.dateOfBirth = dateOfBirth;
        this.phone = phone.trim();
        this.email = email == null ? "" : email.trim();
    }

    public int getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    // Updates the phone number; an empty phone is rejected
    public void setPhone(String phone) {
        if (isBlank(phone)) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.phone = phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? "" : email.trim();
    }

    // Helper that checks for null or whitespace-only text
    private static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    @Override // one-line summary shown in the patient list
    public String toString() {
        return getPatientId() + " - " + getFullName() + " (DOB " + getDateOfBirth() + ")";
    }
}
