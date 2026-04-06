import java.sql.Connection;
import java.sql.PreparedStatement;

public class OperacionDAO {

    public void guardar(double num1, double num2, String operacion, double resultado) {

        String sql = "INSERT INTO OPERACIONES (NUM1, NUM2, OPERACION, RESULTADO) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionOracle.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, num1);
            ps.setDouble(2, num2);
            ps.setString(3, operacion);
            ps.setDouble(4, resultado);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al guardar: " + e.getMessage());
        }
    }
}
