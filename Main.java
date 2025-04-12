import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Program> programs = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        // ✅ Load clients.csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader("clients.csv"));
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                clients.add(new Client(id, name, email));
            }
            reader.close();
            System.out.println("✅ Clients loaded: " + clients.size());
        } catch (IOException e) {
            System.out.println("Error reading clients.csv");
        }

        // ✅ Load programs.csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader("programs.csv"));
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                programs.add(new Program(id, name));
            }
            reader.close();
            System.out.println("✅ Programs loaded: " + programs.size());
        } catch (IOException e) {
            System.out.println("Error reading programs.csv");
        }

        // ✅ Load enrollments.csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader("enrollments.csv"));
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int clientId = Integer.parseInt(parts[0]);
                int programId = Integer.parseInt(parts[1]);
                enrollments.add(new Enrollment(clientId, programId));
            }
            reader.close();
            System.out.println("✅ Enrollments loaded: " + enrollments.size());
        } catch (IOException e) {
            System.out.println("Error reading enrollments.csv");
        }

        // ✅ Print Enrollments with full info
        System.out.println("\n--- Client Enrollments ---");
        for (Enrollment e : enrollments) {
            String clientName = "";
            String programName = "";

            for (Client c : clients) {
                if (c.id == e.clientId) {
                    clientName = c.name;
                    break;
                }
            }

            for (Program p : programs) {
                if (p.id == e.programId) {
                    programName = p.name;
                    break;
                }
            }

            System.out.println(clientName + " is enrolled in " + programName);
        }
    }
}
