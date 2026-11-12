package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import model.Appointment;

public class AppointmentQueue {

    private Queue<Appointment> queue;

    public AppointmentQueue() {
        queue = new LinkedList<>();
    }

    // Add Appointment
    public void addAppointment(Appointment appointment) {

        queue.add(appointment);

        System.out.println("Appointment added to queue successfully.");
    }

    // Display Appointments
    public void displayAppointments() {

        if (queue.isEmpty()) {

            System.out.println("No appointments in queue.");
            return;
        }

        System.out.println("\n--- APPOINTMENT QUEUE ---");

        for (Appointment appointment : queue) {

            appointment.displayAppointment();
        }
    }

    // Serve Appointment
    public void serveAppointment() {

        if (queue.isEmpty()) {

            System.out.println("No appointments to serve.");
            return;
        }

        Appointment appointment = queue.poll();

        System.out.println("\nServing Appointment:");

        appointment.displayAppointment();
    }
}