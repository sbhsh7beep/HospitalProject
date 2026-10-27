import java.sql.*;
import java.util.Scanner;

public class PatientManagement {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/hospital2",
            "root", "sk@1234"
        );

        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter contact: ");
        String contact = sc.nextLine();

        System.out.print("Enter doctor name: ");
        String doctor = sc.nextLine();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        String sql = "INSERT INTO patients VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setString(4, contact);
        ps.setString(5, doctor);
        ps.setDate(6, Date.valueOf(date));

        ps.executeUpdate();
        System.out.println("Patient registered successfully!");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patients");

        while (rs.next()) {
            System.out.println(
                rs.getInt("patient_id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("doctor")
            );
        }

        con.close();
        sc.close();
    }
}