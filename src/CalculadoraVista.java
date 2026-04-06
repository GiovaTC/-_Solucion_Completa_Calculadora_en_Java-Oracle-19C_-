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
