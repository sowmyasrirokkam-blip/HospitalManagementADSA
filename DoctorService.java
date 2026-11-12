package services;

import datastructures.DoctorLinkedList;
import model.Doctor;

public class DoctorService {

    private static DoctorLinkedList doctorList =
            new DoctorLinkedList();

    // Add doctor
    public static void addDoctor(Doctor doctor) {
        doctorList.addDoctor(doctor);
    }

    // Display doctors
    public static void displayDoctors() {
        doctorList.displayDoctors();
    }

    // Search doctor
    public static Doctor searchDoctor(int id) {
        return doctorList.searchDoctor(id);
    }

    // Delete doctor
    public static void deleteDoctor(int id) {
        doctorList.deleteDoctor(id);
    }

    // Sort doctors
    public static void sortDoctors() {
        doctorList.sortDoctors();
    }
}