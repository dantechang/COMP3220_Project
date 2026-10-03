import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class UI extends Application {

    PatientRegistry registry = new PatientRegistry();
    AppointmentManager manager = new AppointmentManager();

    @Override
    public void start(Stage stage) {

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1, "Sarah", "Marsh", "Internal Medicine"));
        doctors.add(new Doctor(2, "James", "Wilson", "Cardiology"));
        doctors.add(new Doctor(3, "Emily", "Chen", "Dermatology"));
        doctors.add(new Doctor(4, "Michael", "Patel", "Pediatrics"));
        doctors.add(new Doctor(5, "Olivia", "Brown", "Neurology"));
        doctors.add(new Doctor(6, "Daniel", "Kim", "Orthopedics"));
        doctors.add(new Doctor(7, "Sophia", "Martinez", "Family Medicine"));
        doctors.add(new Doctor(8, "Ethan", "Taylor", "Psychiatry"));
        doctors.add(new Doctor(9, "Ava", "Anderson", "Obstetrics and Gynecology"));
        doctors.add(new Doctor(10, "Noah", "Thomas", "Ophthalmology"));
        doctors.add(new Doctor(11, "Mia", "Jackson", "Endocrinology"));
        doctors.add(new Doctor(12, "Liam", "White", "Gastroenterology"));
        doctors.add(new Doctor(13, "Isabella", "Harris", "Pulmonology"));
        doctors.add(new Doctor(14, "Lucas", "Martin", "Urology"));
        doctors.add(new Doctor(15, "Charlotte", "Thompson", "Rheumatology"));

        ListView<Doctor> docList = new ListView<>();
        docList.getItems().addAll(doctors);
        docList.setPrefHeight(150);

        TextField first = new TextField();
        first.setPromptText("First name");
        TextField last = new TextField();
        last.setPromptText("Last name");
        DatePicker dob = new DatePicker();
        dob.setPromptText("Date of birth");
        TextField phone = new TextField();
        phone.setPromptText("Phone");
        TextField email = new TextField();
        email.setPromptText("Email");

        DatePicker date = new DatePicker(LocalDate.now());
        ComboBox<String> time = new ComboBox<>();
        time.getItems().addAll("09:00", "10:00", "11:00", "13:00", "14:00", "15:00");
        time.setPromptText("Time");

        Button bookBtn = new Button("Book Appointment");
        Label msg = new Label();
        msg.setMinHeight(Region.USE_PREF_SIZE);
        ListView<Appointment> apptList = new ListView<>();

        bookBtn.setOnAction(e -> {
            Doctor doc = docList.getSelectionModel().getSelectedItem();

            if (doc == null || dob.getValue() == null || date.getValue() == null || time.getValue() == null) {
                msg.setText("Pick a doctor, date of birth, date and time");
                return;
            }

            try {
                Patient p = registry.registerPatient(first.getText(), last.getText(),
                        dob.getValue(), phone.getText(), email.getText());
                manager.createAppointment(p, doc, date.getValue(), LocalTime.parse(time.getValue()));

                String contact = p.getEmail().isEmpty() ? p.getPhone() : p.getPhone() + ", " + p.getEmail();
                msg.setText("Booked for " + p + "\nContact: " + contact);
                apptList.getItems().setAll(manager.getAppointments());
            } catch (IllegalArgumentException ex) {
                msg.setText(ex.getMessage());
            }
        });

        VBox root = new VBox(8,
                new Label("Choose a doctor:"), docList,
                new Label("Your details:"), first, last, dob, phone, email,
                new Label("Date and time:"), date, time,
                bookBtn, msg,
                new Label("Booked appointments:"), apptList);
        root.setPadding(new Insets(15));

        stage.setTitle("Clinic Booking");
        stage.setScene(new Scene(root, 450, 750));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
