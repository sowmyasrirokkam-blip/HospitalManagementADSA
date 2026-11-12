package datastructures;

import model.Doctor;

public class DoctorLinkedList {

    private class Node {
        Doctor doctor;
        Node next;

        Node(Doctor doctor) {
            this.doctor = doctor;
            this.next = null;
        }
    }

    private Node head;

    // Insert doctor
    public void addDoctor(Doctor doctor) {

        Node newNode = new Node(doctor);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Doctor added successfully.");
    }

    // Display doctors
    public void displayDoctors() {

        if (head == null) {
            System.out.println("No doctors found.");
            return;
        }

        Node current = head;

        while (current != null) {
            current.doctor.displayDoctor();
            current = current.next;
        }
    }

    // Search doctor
    public Doctor searchDoctor(int id) {

        Node current = head;

        while (current != null) {

            if (current.doctor.getDoctorId() == id) {
                return current.doctor;
            }

            current = current.next;
        }

        return null;
    }

    // Delete doctor
    public void deleteDoctor(int id) {

        if (head == null) {
            System.out.println("No doctors found.");
            return;
        }

        if (head.doctor.getDoctorId() == id) {
            head = head.next;
            System.out.println("Doctor deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.doctor.getDoctorId() == id) {
                current.next = current.next.next;
                System.out.println("Doctor deleted successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Doctor not found.");
    }

    // Sort doctors by Doctor ID
    public void sortDoctors() {

        if (head == null || head.next == null) {
            System.out.println("Not enough doctors to sort.");
            return;
        }

        boolean swapped;

        do {
            swapped = false;

            Node current = head;

            while (current.next != null) {

                Node nextNode = current.next;

                if (current.doctor.getDoctorId()
                        > nextNode.doctor.getDoctorId()) {

                    Doctor temp = current.doctor;
                    current.doctor = nextNode.doctor;
                    nextNode.doctor = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);

        System.out.println("Doctors sorted successfully.");
    }
}