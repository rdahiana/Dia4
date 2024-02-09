public class Jugador {
    String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Jugador "+ this.nombre;
    }
}
