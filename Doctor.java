
public class Doctor {


    //private variables with scope of class only for encapsulation
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;

    public Doctor(int doctorId, String firstName, String lastName, String specialty) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override //replaces inherited toString() method  with its own
    public String toString() {
        return "Dr. " + getFullName() + " - " + specialty;
    }

}