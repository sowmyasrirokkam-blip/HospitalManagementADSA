package datastructures;

import java.util.PriorityQueue;

public class EmergencyPriorityQueue {

    private class EmergencyPatient {

        int patientId;
        String name;
        int priority;

        EmergencyPatient(int patientId, String name, int priority) {
            this.patientId = patientId;
            this.name = name;
            this.priority = priority;
        }
    }

    private PriorityQueue<EmergencyPatient> queue;

    public EmergencyPriorityQueue() {

        queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.priority, a.priority)
        );
    }

    // Add Emergency Patient
    public void addEmergencyPatient(
            int patientId,
            String name,
            int priority) {

        if (priority < 1 || priority > 5) {

            System.out.println(
                "Invalid priority. Enter priority between 1 and 5."
            );

            return;
        }

        EmergencyPatient patient =
                new EmergencyPatient(
                        patientId,
                        name,
                        priority
                );

        queue.add(patient);

        System.out.println(
            "Emergency patient added successfully."
        );
    }

    // Display Emergency Patients
    public void displayEmergencyPatients() {

        if (queue.isEmpty()) {

            System.out.println(
                "No emergency patients."
            );

            return;
        }

        System.out.println(
            "\n--- EMERGENCY PATIENT QUEUE ---"
        );

        for (EmergencyPatient patient : queue) {

            System.out.println(
                "Patient ID : " + patient.patientId
            );

            System.out.println(
                "Name       : " + patient.name
            );

            System.out.println(
                "Priority   : " + patient.priority
            );

            System.out.println(
                "-----------------------------"
            );
        }
    }

    // Treat Highest Priority Patient
    public void treatPatient() {

        if (queue.isEmpty()) {

            System.out.println(
                "No emergency patients to treat."
            );

            return;
        }

        EmergencyPatient patient = queue.poll();

        System.out.println(
            "\nTreating Emergency Patient:"
        );

        System.out.println(
            "Patient ID : " + patient.patientId
        );

        System.out.println(
            "Name       : " + patient.name
        );

        System.out.println(
            "Priority   : " + patient.priority
        );
    }
}