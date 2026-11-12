import java.util.Scanner;

import model.Patient;
import model.Doctor;
import model.Appointment;

import datastructures.PatientLinkedList;
import datastructures.AppointmentQueue;
import datastructures.EmergencyPriorityQueue;
import datastructures.MedicalHistoryStack;
import datastructures.HospitalGraph;

import services.DoctorService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ==========================================
        // CREATE OBJECTS
        // ==========================================

        PatientLinkedList patientList = new PatientLinkedList();

        DoctorService doctorService = new DoctorService();

        AppointmentQueue appointmentQueue = new AppointmentQueue();

        EmergencyPriorityQueue emergencyQueue =
                new EmergencyPriorityQueue();

        MedicalHistoryStack medicalHistory =
                new MedicalHistoryStack();

        HospitalGraph hospitalGraph = new HospitalGraph();

        // ==========================================
        // ADD HOSPITAL DEPARTMENTS
        // ==========================================

        hospitalGraph.addDepartment("Emergency");
        hospitalGraph.addDepartment("Cardiology");
        hospitalGraph.addDepartment("Pharmacy");
        hospitalGraph.addDepartment("Laboratory");
        hospitalGraph.addDepartment("General");

        // ==========================================
        // CONNECT HOSPITAL DEPARTMENTS
        // ==========================================

        hospitalGraph.addConnection(
                "Emergency",
                "Cardiology"
        );

        hospitalGraph.addConnection(
                "Cardiology",
                "Pharmacy"
        );

        hospitalGraph.addConnection(
                "Cardiology",
                "Laboratory"
        );

        hospitalGraph.addConnection(
                "Pharmacy",
                "General"
        );

        hospitalGraph.addConnection(
                "Laboratory",
                "General"
        );

        // ==========================================
        // MAIN PROGRAM
        // ==========================================

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Emergency Management");
            System.out.println("5. Medical History");
            System.out.println("6. Search Patient");
            System.out.println("7. Sort Patients");
            System.out.println("8. Hospital Departments");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ==================================
                // CASE 1 - PATIENT MANAGEMENT
                // ==================================

                case 1:

                    System.out.println("\n--- PATIENT MANAGEMENT ---");

                    System.out.println("1. Add Patient");
                    System.out.println("2. Display Patients");
                    System.out.println("3. Search Patient");
                    System.out.println("4. Delete Patient");

                    System.out.print("Enter choice: ");

                    int patientChoice = sc.nextInt();

                    switch (patientChoice) {

                        // ADD PATIENT
                        case 1:

                            System.out.print("Enter Patient ID: ");
                            int id = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Age: ");
                            int age = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter Gender: ");
                            String gender = sc.nextLine();

                            System.out.print("Enter Phone: ");
                            String phone = sc.nextLine();

                            System.out.print("Enter Address: ");
                            String address = sc.nextLine();

                            System.out.print("Enter Disease: ");
                            String disease = sc.nextLine();

                            Patient patient =
                                    new Patient(
                                            id,
                                            name,
                                            age,
                                            gender,
                                            phone,
                                            address,
                                            disease
                                    );

                            patientList.addPatient(patient);

                            break;

                        // DISPLAY PATIENTS
                        case 2:

                            patientList.displayPatients();

                            break;

                        // SEARCH PATIENT
                        case 3:

                            System.out.print("Enter Patient ID: ");

                            int searchPatientId = sc.nextInt();

                            Patient found =
                                    patientList.searchPatient(
                                            searchPatientId
                                    );

                            if (found != null) {

                                found.displayPatient();

                            } else {

                                System.out.println(
                                        "Patient not found."
                                );
                            }

                            break;

                        // DELETE PATIENT
                        case 4:

                            System.out.print(
                                    "Enter Patient ID to delete: "
                            );

                            int deleteId = sc.nextInt();

                            patientList.deletePatient(deleteId);

                            break;

                        default:

                            System.out.println(
                                    "Invalid patient choice."
                            );
                    }

                    break;

                // ==================================
                // CASE 2 - DOCTOR MANAGEMENT
                // ==================================

                case 2:

                    System.out.println("\n--- DOCTOR MANAGEMENT ---");

                    System.out.println("1. Add Doctor");
                    System.out.println("2. Display Doctors");
                    System.out.println("3. Search Doctor");
                    System.out.println("4. Delete Doctor");

                    System.out.print("Enter choice: ");

                    int doctorChoice = sc.nextInt();

                    switch (doctorChoice) {

                        case 1:

                            System.out.print("Enter Doctor ID: ");

                            int doctorId = sc.nextInt();

                            sc.nextLine();

                            System.out.print("Enter Doctor Name: ");

                            String doctorName = sc.nextLine();

                            System.out.print(
                                    "Enter Specialization: "
                            );

                            String specialization =
                                    sc.nextLine();
                                    System.out.print("Enter Phone:");
                                String phone = sc.nextLine();
                                System.out.print("Enter Email:");
                                String email = sc.nextLine();
                                System.out.print("Enter Department:");
                                String department = sc.nextLine();


                            Doctor doctor =
                                    new Doctor(
                                            doctorId,
                                            doctorName,
                                            specialization,
                                            phone,
                                            email,
                                            department
                                    );

                            DoctorService.addDoctor(doctor);

                            break;

                        case 2:

                            DoctorService.displayDoctors();

                            break;

                        case 3:

                            System.out.print(
                                    "Enter Doctor ID: "
                            );

                            int searchDoctorId = sc.nextInt();

                            Doctor foundDoctor =
                                    DoctorService.searchDoctor(
                                            searchDoctorId
                                    );

                            if (foundDoctor != null) {

                                foundDoctor.displayDoctor();

                            } else {

                                System.out.println(
                                        "Doctor not found."
                                );
                            }

                            break;

                        case 4:

                            System.out.print(
                                    "Enter Doctor ID to delete: "
                            );

                            int deleteDoctorId = sc.nextInt();

                            DoctorService.deleteDoctor(
                                    deleteDoctorId
                            );

                            break;

                        default:

                            System.out.println(
                                    "Invalid doctor choice."
                            );
                    }

                    break;

                // ==================================
                // CASE 3 - APPOINTMENT MANAGEMENT
                // ==================================

                case 3:

                    System.out.println(
                            "\n--- APPOINTMENT MANAGEMENT ---"
                    );

                    System.out.println("1. Add Appointment");
                    System.out.println("2. Display Appointments");
                    System.out.println("3. Serve Appointment");

                    System.out.print("Enter choice: ");

                    int appointmentChoice = sc.nextInt();

                    switch (appointmentChoice) {

                        case 1:

                            System.out.print(
                                    "Enter Appointment ID: "
                            );

                            int appointmentId = sc.nextInt();

                            System.out.print(
                                    "Enter Patient ID: "
                            );

                            int patientId = sc.nextInt();

                            System.out.print(
                                    "Enter Doctor ID: "
                            );

                            int appointmentDoctorId =
                                    sc.nextInt();

                            Appointment appointment =
                                    new Appointment(
                                            appointmentId,
                                            patientId,
                                            appointmentDoctorId
                                    );

                            appointmentQueue.addAppointment(
                                    appointment
                            );

                            break;

                        case 2:

                            appointmentQueue.displayAppointments();

                            break;

                        case 3:

                            appointmentQueue.serveAppointment();

                            break;

                        default:

                            System.out.println(
                                    "Invalid appointment choice."
                            );
                    }

                    break;

                // ==================================
                // CASE 4 - EMERGENCY MANAGEMENT
                // ==================================

                case 4:

                    System.out.println(
                            "\n--- EMERGENCY MANAGEMENT ---"
                    );

                    System.out.println(
                            "1. Add Emergency Patient"
                    );

                    System.out.println(
                            "2. Display Emergency Patients"
                    );

                    System.out.println(
                            "3. Treat Emergency Patient"
                    );

                    System.out.print("Enter choice: ");

                    int emergencyChoice = sc.nextInt();

                    switch (emergencyChoice) {

                        case 1:

                            System.out.print(
                                    "Enter Patient ID: "
                            );

                            int emergencyPatientId =
                                    sc.nextInt();

                            sc.nextLine();

                            System.out.print(
                                    "Enter Patient Name: "
                            );

                            String emergencyName =
                                    sc.nextLine();

                            System.out.print(
                                    "Enter Priority (1-5): "
                            );

                            int priority = sc.nextInt();

                            emergencyQueue.addEmergencyPatient(
                                    emergencyPatientId,
                                    emergencyName,
                                    priority
                            );

                            break;

                        case 2:

                            emergencyQueue
                                    .displayEmergencyPatients();

                            break;

                        case 3:

                            emergencyQueue.treatPatient();

                            break;

                        default:

                            System.out.println(
                                    "Invalid emergency choice."
                            );
                    }

                    break;

                // ==================================
                // CASE 5 - MEDICAL HISTORY
                // ==================================

                case 5:

                    int historyChoice;

                    do {

                        System.out.println(
                                "\n--- MEDICAL HISTORY ---"
                        );

                        System.out.println(
                                "1. Add Medical Record"
                        );

                        System.out.println(
                                "2. View Latest Record"
                        );

                        System.out.println(
                                "3. Remove Latest Record"
                        );

                        System.out.println(
                                "4. Display All Records"
                        );

                        System.out.println(
                                "5. Back"
                        );

                        System.out.print(
                                "Enter your choice: "
                        );

                        historyChoice = sc.nextInt();

                        sc.nextLine();

                        switch (historyChoice) {

                            case 1:

                                System.out.print(
                                        "Enter medical record: "
                                );

                                String record =
                                        sc.nextLine();

                                medicalHistory.addRecord(record);

                                break;

                            case 2:

                                medicalHistory.viewLatestRecord();

                                break;

                            case 3:

                                medicalHistory.removeLatestRecord();

                                break;

                            case 4:

                                medicalHistory.displayHistory();

                                break;

                            case 5:

                                System.out.println(
                                        "Returning to Main Menu..."
                                );

                                break;

                            default:

                                System.out.println(
                                        "Invalid history choice."
                                );
                        }

                    } while (historyChoice != 5);

                    break;

                // ==================================
                // CASE 6 - SEARCH PATIENT
                // ==================================

                case 6:

                    System.out.print(
                            "Enter Patient ID to search: "
                    );

                    int searchId = sc.nextInt();

                    Patient searchedPatient =
                            patientList.searchPatient(searchId);

                    if (searchedPatient != null) {

                        searchedPatient.displayPatient();

                    } else {

                        System.out.println(
                                "Patient not found."
                        );
                    }

                    break;

                // ==================================
                // CASE 7 - SORT PATIENTS
                // ==================================

                case 7:

                    System.out.println(
                            "\n--- SORT PATIENTS ---"
                    );

                    patientList.sortPatients();

                    patientList.displayPatients();

                    break;

                // ==================================
                // CASE 8 - HOSPITAL DEPARTMENTS
                // ==================================

                case 8:

                    System.out.println(
                            "\n--- HOSPITAL DEPARTMENT GRAPH ---"
                    );

                    hospitalGraph.displayGraph();

                    System.out.println("\n1. BFS Traversal");
                    System.out.println("2. DFS Traversal");

                    System.out.print(
                            "Enter your choice: "
                    );

                    int graphChoice = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter starting department: "
                    );

                    String startDepartment =
                            sc.nextLine();

                    if (graphChoice == 1) {

                        hospitalGraph.bfs(startDepartment);

                    } else if (graphChoice == 2) {

                        hospitalGraph.dfs(startDepartment);

                    } else {

                        System.out.println(
                                "Invalid graph choice."
                        );
                    }

                    break;

                // ==================================
                // CASE 9 - EXIT
                // ==================================

                case 9:

                    System.out.println(
                            "\nThank you for using "
                                    + "Hospital Management System."
                    );

                    sc.close();

                    return;

                // ==================================
                // INVALID MAIN MENU CHOICE
                // ==================================

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }
}