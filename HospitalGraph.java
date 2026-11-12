package datastructures;

import java.util.*;

public class HospitalGraph {

    private Map<String, List<String>> graph;

    public HospitalGraph() {
        graph = new HashMap<>();
    }

    // Add a department
    public void addDepartment(String department) {
        if (!graph.containsKey(department)) {
            graph.put(department, new ArrayList<>());
        }
    }

    // Connect two departments
    public void addConnection(String department1, String department2) {

        addDepartment(department1);
        addDepartment(department2);

        graph.get(department1).add(department2);
        graph.get(department2).add(department1);
    }

    // Display the graph
    public void displayGraph() {

        System.out.println("\n--- HOSPITAL DEPARTMENTS ---");

        for (String department : graph.keySet()) {

            System.out.print(department + " -> ");

            for (String connection : graph.get(department)) {
                System.out.print(connection + " ");
            }

            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(String start) {

        if (!graph.containsKey(start)) {
            System.out.println("Department not found.");
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        System.out.println("\nBFS Traversal:");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (String neighbour : graph.get(current)) {

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    public void dfs(String start) {

        if (!graph.containsKey(start)) {
            System.out.println("Department not found.");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.println("\nDFS Traversal:");

        dfsRecursive(start, visited);

        System.out.println();
    }

    private void dfsRecursive(String department,
                               Set<String> visited) {

        visited.add(department);

        System.out.print(department + " ");

        for (String neighbour : graph.get(department)) {

            if (!visited.contains(neighbour)) {
                dfsRecursive(neighbour, visited);
            }
        }
    }
}