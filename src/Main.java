public class Main {

    public static void main(String[] args) {

        CalculadoraVista vista = new CalculadoraVista();
        OperacionDAO dao = new OperacionDAO();

        new CalculadoraControlador(vista, dao);
    }
}
