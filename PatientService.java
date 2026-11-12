package services;

import datastructures.PatientLinkedList;
import model.Patient;

public class PatientService {

    // One shared patient list for the application
    private static PatientLinkedList patientList = new PatientLinkedList();

    // Add Patient
    public static void addPatient(Patient patient) {
        patientList.addPatient(patient);
    }

    // Display all Patients
    public static void displayPatients() {
        patientList.displayPatients();
    }

    // Search Patient by ID
    public static Patient searchPatient(int id) {
        return patientList.searchPatient(id);
    }

    // Delete Patient by ID
    public static void deletePatient(int id) {
        patientList.deletePatient(id);
    }

    // Sort Patients by ID
    public static void sortPatients() {
        patientList.sortPatients();
    }
}