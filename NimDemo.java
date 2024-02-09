import java.util.Scanner;

public class NimDemo {
    public static void main(String[] args) {

        Nim A = new Nim(1);
        Nim B = new Nim(2);
        Nim C = new Nim(3);

        Scanner read = new Scanner(System.in);
        String nombre;

        Jugador[] jugadores = new Jugador[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese el nombre del Jugador " + (i + 1) + ": ");
            nombre = read.nextLine();
            jugadores[i] = new Jugador(nombre);
        }

        do {
            for (int i = 0; i < 2; i++) {
                imprimirPilas(A, B, C);
                System.out.println(jugadores[i].toString() + ", elija una pila (A, B o C):");
                String eleccion = read.nextLine();

                while (!eleccion.equals("A") && !eleccion.equals("B") && !eleccion.equals("C")) {
                    System.out.println("Opción incorrecta. Por favor, elija una pila válida (A, B o C):");
                    eleccion = read.nextLine();
                }

                Nim pilaSeleccionada = null;
                if (eleccion.equals("A")) {
                    pilaSeleccionada = A;
                } else if (eleccion.equals("B")) {
                    pilaSeleccionada = B;
                } else if (eleccion.equals("C")) {
                    pilaSeleccionada = C;
                }

                // Verificar si la pila seleccionada está vacía
                while (pilaSeleccionada.isEmpty()) {
                    // Verificar si todas las pilas están vacías
                    if (A.isEmpty() && B.isEmpty() && C.isEmpty()) {
                        System.out.println(jugadores[i].toString() + ", no hay mas contadores ,así que... ¡Ganaste!");
                        return; // Terminar el programa
                    }

                    System.out.println("La pila seleccionada está vacía. Por favor, elija otra pila.");


                    System.out.println("Elija una pila no vacía (A, B o C):");
                    eleccion = read.nextLine();

                    // Actualizar la pila seleccionada
                    if (eleccion.equals("A")) {
                        pilaSeleccionada = A;
                    } else if (eleccion.equals("B")) {
                        pilaSeleccionada = B;
                    } else if (eleccion.equals("C")) {
                        pilaSeleccionada = C;
                    }
                }

                int opcion;
                do {
                    System.out.println("¿Cuántos elementos quitará de la pila?");
                    opcion = read.nextInt();

                    if (opcion <= 0 || opcion > pilaSeleccionada.pilaSize()) {
                        if (opcion ==1 || pilaSeleccionada.pilaSize() == 1 ){
                            System.out.println("Cantidad inválida.Solo existe un elemento");
                        }else {
                            System.out.println("Cantidad inválida. Debe ser un valor entre 1 y " + pilaSeleccionada.pilaSize());
                        }
                    }


                } while (opcion <= 0 || opcion > pilaSeleccionada.pilaSize());

                // Desapilar la cantidad de elementos de la pila seleccionada
                pilaSeleccionada.desapilarElementos(opcion);
                read.nextLine(); // Consumir el salto de línea pendiente
            }
        } while (!A.isEmpty() || !B.isEmpty() || !C.isEmpty());

    }

    static public void imprimirPilas(Nim A, Nim B, Nim C) {
        System.out.println("A: " + A.toString());
        System.out.println("B: " + B.toString());
        System.out.println("C: " + C.toString());
    }
}

