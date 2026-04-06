# -_Solucion_Completa_Calculadora_en_Java-Oracle-19C_- :.
✅ Solución Completa: Calculadora en Java + Oracle 19c:

<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/56cf7682-0c21-4b4a-bd90-d1d9de62d81a" />  

```

AplicaciOn desarrollada en Java (IntelliJ) con las siguientes características:

✔ Interfaz gráfica con Swing (GUI)
✔ 4 operaciones básicas: + − × ÷
✔ Arquitectura simple: Vista + Controlador + DAO
✔ Persistencia en Oracle 19c (JDBC).

🧩 1. Modelo de Datos (Oracle 19c)
CREATE TABLE OPERACIONES (
    ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NUM1 NUMBER,
    NUM2 NUMBER,
    OPERACION VARCHAR2(20),
    RESULTADO NUMBER,
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

🧩 2. Conexión JDBC
📄 ConexionOracle.java
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionOracle {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "system";
    private static final String PASS = "1234";

    public static Connection getConexion() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

🧩 3. DAO (Persistencia)
📄 OperacionDAO.java
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
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}

🧩 4. Vista (Interfaz Gráfica)
📄 CalculadoraVista.java
import javax.swing.*;
import java.awt.*;

public class CalculadoraVista extends JFrame {

    public JTextField txtNum1 = new JTextField();
    public JTextField txtNum2 = new JTextField();
    public JLabel lblResultado = new JLabel("Resultado:");

    public JButton btnSumar = new JButton("+");
    public JButton btnRestar = new JButton("-");
    public JButton btnMultiplicar = new JButton("*");
    public JButton btnDividir = new JButton("/");

    public CalculadoraVista() {

        setTitle("Calculadora con Oracle");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Número 1:"));
        add(txtNum1);

        add(new JLabel("Número 2:"));
        add(txtNum2);

        add(btnSumar);
        add(btnRestar);

        add(btnMultiplicar);
        add(btnDividir);

        add(lblResultado);

        setVisible(true);
    }
}

🧩 5. Controlador (Lógica + Eventos)
📄 CalculadoraControlador.java
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraControlador {

    private CalculadoraVista vista;
    private OperacionDAO dao;

    public CalculadoraControlador(CalculadoraVista vista, OperacionDAO dao) {
        this.vista = vista;
        this.dao = dao;

        eventos();
    }

    private void eventos() {

        vista.btnSumar.addActionListener(e -> calcular("+"));
        vista.btnRestar.addActionListener(e -> calcular("-"));
        vista.btnMultiplicar.addActionListener(e -> calcular("*"));
        vista.btnDividir.addActionListener(e -> calcular("/"));
    }

    private void calcular(String op) {
        try {
            double n1 = Double.parseDouble(vista.txtNum1.getText());
            double n2 = Double.parseDouble(vista.txtNum2.getText());
            double resultado = 0;

            switch (op) {
                case "+":
                    resultado = n1 + n2;
                    break;
                case "-":
                    resultado = n1 - n2;
                    break;
                case "*":
                    resultado = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0) {
                        vista.lblResultado.setText("Error: División por 0");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
            }

            vista.lblResultado.setText("Resultado: " + resultado);

            // Guardar en BD
            dao.guardar(n1, n2, op, resultado);

        } catch (Exception e) {
            vista.lblResultado.setText("Error: Datos inválidos");
        }
    }
}

🧩 6. Main (Ejecución)
📄 Main.java
public class Main {

    public static void main(String[] args) {

        CalculadoraVista vista = new CalculadoraVista();
        OperacionDAO dao = new OperacionDAO();

        new CalculadoraControlador(vista, dao);
    }
}

⚙️ 7. Dependencia Necesaria

Debes agregar el driver JDBC de Oracle:

ojdbc8.jar
ojdbc11.jar
📌 En IntelliJ:
File → Project Structure → Libraries → Add JAR .

✅ Resultado Final

La aplicación permite:

Ingresar 2 números
Ejecutar 4 operaciones ( + − × ÷ )
Mostrar el resultado en pantalla
Guardar automáticamente cada operación en Oracle.

🚀 Mejoras Opcionales:
Para escalar el proyecto:

📊 Implementar JTable con historial de operaciones
🔢 Usar BigDecimal para precisión financiera
🧱 Migrar a arquitectura MVC completa
⚡ Implementar pool de conexiones (HikariCP)
📤 Exportar resultados a Excel :. / .  
