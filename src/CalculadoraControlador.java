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

    private void calcular(String s) {
    }

}
