package vista;

import controlador.LogisticaController;
import modelo.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogisticaController controller = new LogisticaController();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- OPERADOR LOGÍSTICO (MVC + Service) ---");
            System.out.println("1. Agregar envío");
            System.out.println("2. Retirar envío");
            System.out.println("3. Listar envíos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n1. Terrestre | 2. Aéreo | 3. Marítimo");
                    System.out.print("Seleccione tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Peso (Kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Distancia (Km): ");
                    double distancia = scanner.nextDouble();
                    scanner.nextLine();

                    boolean guardado = controller.registrarEnvio(tipo, codigo, cliente, peso, distancia);
                    if (guardado) System.out.println("¡Envío agregado con éxito!");
                    else System.out.println("Error al agregar el tipo de envío.");
                    break;

                case 2:
                    System.out.print("\nIngrese el código a retirar: ");
                    String codRetiro = scanner.nextLine();
                    boolean eliminado = controller.eliminarEnvio(codRetiro);
                    if (eliminado) System.out.println("¡Envío retirado con éxito!");
                    else System.out.println("No se encontró el código.");
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE ENVÍOS ---");
                    var lista = controller.listarEnvios();
                    if (lista.isEmpty()) {
                        System.out.println("No hay registros.");
                    } else {
                        System.out.printf("%-12s %-10s %-20s %-10s %-12s %-12s\n", "Tipo", "Código", "Cliente", "Peso", "Distancia", "Costo");
                        System.out.println("----------------------------------------------------------------------------------");
                        for (Envio e : lista) {
                            String tipoStr = (e instanceof Terrestre) ? "Terrestre" : (e instanceof Aereo) ? "Aéreo" : "Marítimo";
                            System.out.printf("%-12s %-10s %-20s %-10.1f %-12.1f $%-10.1f\n",
                                    tipoStr, e.getCodigo(), e.getCliente(), e.getPeso(), e.getDistancia(), e.calcularTarifa());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
        scanner.close();
    }
}
