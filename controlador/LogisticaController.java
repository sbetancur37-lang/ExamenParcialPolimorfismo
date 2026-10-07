package controlador;

import modelo.Envio;
import servicio.EnvioService;
import java.util.ArrayList;

public class LogisticaController {
    private EnvioService envioService;

    public LogisticaController() {
        this.envioService = new EnvioService();
    }

    public boolean registrarEnvio(int tipo, String codigo, String cliente, double peso, double distancia) {
        return envioService.agregarEnvio(tipo, codigo, cliente, peso, distancia);
    }

    public boolean eliminarEnvio(String codigo) {
        return envioService.retirarEnvio(codigo);
    }

    public ArrayList<Envio> listarEnvios() {
        return envioService.obtenerEnvios();
    }
}