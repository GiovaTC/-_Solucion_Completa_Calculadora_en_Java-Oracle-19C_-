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
                        vista.lblResultado.setText("error: division por 0");
                        return;
                    }
                    resultado = n1 / n2;
                    break;
            }

            vista.lblResultado.setText("Resultado: " + resultado);

            // guardar en BD
            dao.guardar(n1, n2, op, resultado);

        } catch (Exception e) {
            vista.lblResultado.setText("error: datos invalidos" + e.getMessage());
        }
    }
}
