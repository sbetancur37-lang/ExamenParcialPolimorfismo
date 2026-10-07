package servicio;

import modelo.*;
import java.util.ArrayList;

public class EnvioService {
    private ArrayList<Envio> listaEnvios;

    public EnvioService() {
        this.listaEnvios = new ArrayList<>();
    }

    public boolean agregarEnvio(int tipo, String codigo, String cliente, double peso, double distancia) {
        Envio nuevo = null;
        switch (tipo) {
            case 1: nuevo = new Terrestre(codigo, cliente, peso, distancia); break;
            case 2: nuevo = new Aereo(codigo, cliente, peso, distancia); break;
            case 3: nuevo = new Maritimo(codigo, cliente, peso, distancia); break;
            default: return false;
        }
        listaEnvios.add(nuevo);
        return true;
    }

    public boolean retirarEnvio(String codigo) {
        for (int i = 0; i < listaEnvios.size(); i++) {
            if (listaEnvios.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                listaEnvios.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Envio> obtenerEnvios() {
        return listaEnvios;
    }
}