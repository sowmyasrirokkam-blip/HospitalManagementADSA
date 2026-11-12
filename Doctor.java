package model;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private String phone;
    private String email;
    private String department;

    public Doctor(int doctorId, String name, String specialization,
                  String phone, String email, String department) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.department = department;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public void displayDoctor() {
        System.out.println("-----------------------------");
        System.out.println("Doctor ID    : " + doctorId);
        System.out.println("Name         : " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Phone        : " + phone);
        System.out.println("Email        : " + email);
        System.out.println("Department   : " + department);
        System.out.println("-----------------------------");
    }
}