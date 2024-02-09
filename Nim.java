
import java.util.Stack;
public class Nim {
    private Stack<Character> pila;

    // Constructor para inicializar la pila
    public Nim() {
        this.pila = new Stack<>();
    }

    // Constructor para cargar la pila
    public Nim(int cantidad) {
        this.pila = new Stack<>();
        for (int i = 0; i < cantidad; i++) {
            this.pila.push('*');
        }
    }
    public Stack<Character> getPila() {
        return this.pila;
    }


    // Método para desapilar una cantidad específica de elementos
    public void desapilarElementos(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            if (!this.pila.isEmpty()) {
                this.pila.pop();
            }
            else if (pilaSize()<cantidad){
                System.out.println("Esa cantidad supera la existencia");
            }else {
                System.out.println("No existen elementos en esta pila");
            }

        }
    }

    public int pilaSize (){
        return this.pila.size();
    }

    public boolean isEmpty() {
        return this.pila.isEmpty();
    }

    @Override
    public String toString() {
        return "" + this.pila ;
    }
}

