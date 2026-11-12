package datastructures;

import java.util.Stack;

public class MedicalHistoryStack {

    private Stack<String> history;

    public MedicalHistoryStack() {
        history = new Stack<>();
    }

    // Add a medical record
    public void addRecord(String record) {
        history.push(record);
        System.out.println("Medical record added successfully.");
    }

    // View the latest record
    public void viewLatestRecord() {

        if (history.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }

        System.out.println("\nLatest Medical Record:");
        System.out.println(history.peek());
    }

    // Remove the latest record
    public void removeLatestRecord() {

        if (history.isEmpty()) {
            System.out.println("No medical records to remove.");
            return;
        }

        String record = history.pop();

        System.out.println("\nRemoved Medical Record:");
        System.out.println(record);
    }

    // Display complete medical history
    public void displayHistory() {

        if (history.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }

        System.out.println("\n--- MEDICAL HISTORY ---");

        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}