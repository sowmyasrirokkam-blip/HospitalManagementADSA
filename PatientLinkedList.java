package datastructures;

import model.Patient;

public class PatientLinkedList {

    private class Node {

        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node head;

    // Add Patient
    public void addPatient(Patient patient) {

        Node newNode = new Node(patient);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Patient added successfully.");
    }

    // Display Patients
    public void displayPatients() {

        if (head == null) {
            System.out.println("No patients found.");
            return;
        }

        Node current = head;

        while (current != null) {

            current.patient.displayPatient();

            current = current.next;
        }
    }

    // Search Patient
    public Patient searchPatient(int id) {

        Node current = head;

        while (current != null) {

            if (current.patient.getPatientId() == id) {
                return current.patient;
            }

            current = current.next;
        }

        return null;
    }

    // Delete Patient
    public void deletePatient(int id) {

        if (head == null) {
            System.out.println("No patients found.");
            return;
        }

        if (head.patient.getPatientId() == id) {

            head = head.next;

            System.out.println("Patient deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.patient.getPatientId() == id) {

                current.next = current.next.next;

                System.out.println("Patient deleted successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Patient not found.");
    }

    // Bubble Sort Patients by ID
    public void sortPatients() {

        if (head == null || head.next == null) {

            System.out.println("Not enough patients to sort.");
            return;
        }

        boolean swapped;

        do {

            swapped = false;

            Node current = head;

            while (current.next != null) {

                Node nextNode = current.next;

                if (current.patient.getPatientId()
                        > nextNode.patient.getPatientId()) {

                    Patient temp = current.patient;

                    current.patient = nextNode.patient;

                    nextNode.patient = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);

        System.out.println("Patients sorted successfully.");
    }
}