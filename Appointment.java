package model;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;

    public Appointment(int appointmentId,
                       int patientId,
                       int doctorId) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void displayAppointment() {

        System.out.println("-----------------------------");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("-----------------------------");
    }
}