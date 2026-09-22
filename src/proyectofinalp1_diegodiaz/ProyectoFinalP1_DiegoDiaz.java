
package proyectofinalp1_diegodiaz;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author diego
 */
public class ProyectoFinalP1_DiegoDiaz {
    
    //Las hago estaticas para asi poder usarlas y llamarlas donde yo quiera 
    //sin necesidad de instanciar un objeto de la clase ni de estar pasando las variables como parámetros
    
    static ArrayList<Fighter> fighters = new ArrayList<>(); 
    static JFrame GUI; // ventana principal
    static JTextArea ventanaTexto; // area de texto

    
    public static void main(String[] args) {
        // TODO code application logic here

        GUI = new JFrame("Proyecto Final Lab Programacion - Diego Diaz ");
        GUI.setSize(500, 500);
        GUI.setLayout(null);
        GUI.setLocationRelativeTo(null);// centrar pantalla
        GUI.setVisible(true); // mostrar pantalla
        
        
        // Botones que van a aparecer en pantalla gui
        JButton botonAg = new JButton ("Agregar un fighter");
        botonAg.setBounds(20, 50, 185, 30);
        GUI.add(botonAg);

        JButton botonLista = new JButton ("Lstar todos los fighters: ");
        botonLista.setBounds(20, 100, 185, 30);
        GUI.add(botonLista);
        
        JButton botonDelete = new JButton ("Eliminar un Fighter");
        botonDelete.setBounds(20, 150, 185, 30);
        GUI.add(botonDelete);
        
        JButton botonModF = new JButton ("Modificar un fighter");
        botonModF.setBounds(20,200, 185, 30);
        GUI.add(botonModF);
        
        JButton botonID = new JButton ("Buscar por id");
        botonID.setBounds(20, 250, 185, 30);
        GUI.add(botonID);
       
        ventanaTexto = new JTextArea();
        ventanaTexto.setEditable(false); // para que la ventana el usuario no la pueda editar 
        ventanaTexto.setBounds(300, 100, 460, 300);
        GUI.add(ventanaTexto);
        
        
        
        
    
    }
    // El metodo validNumero lo estoy creando para validar que el revise si un numero se puede convertir en un entero ya que
    // el JOPtion Pane siempre devuelve texto no numeros enteros que es lo que ocupo para que la vida, defensa, etc.
    public static boolean validNumero(String texto){
        
        if (texto == null || texto.length() == 0) {
            return false;
        }
        int num1 = 0;
        if (texto.charAt(0) == '-') { // si el primer caracter es negativo pasa al siguiente 
            if (texto.length() == 1) {
                return false;
            }
            num1 = 1;
        }
        for (int i = num1; i < texto.length(); i++) {
            char carac = texto.charAt(i);
            if (carac <'0' || carac > '9') { // reccore todos los caracters y si no esta entre 0 y 9 ya sabemos que no es un numero
                return false;
            }
        }
        
        // pasando la revision ya se que es valido
        return true;
        
    }
    
    
    public static void agregarFighter(){
        
    }
    public static void ListaFighters(){
        
    }
    public static void EliminarFighter(){
        
    }
    public static void modFighter(){
        
    }
    public static void buscarID(){
        
    }
    
}
