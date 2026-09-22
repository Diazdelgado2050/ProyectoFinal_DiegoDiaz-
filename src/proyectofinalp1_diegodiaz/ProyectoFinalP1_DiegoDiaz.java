package proyectofinalp1_diegodiaz;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;

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
        GUI.setSize(700, 480);
        GUI.setLayout(null);
        GUI.setLocationRelativeTo(null);// centrar pantalla
        GUI.setVisible(true); // mostrar pantalla

        // Botones que van a aparecer en pantalla gui
        JButton botonAg = new JButton("Agregar un fighter");
        botonAg.setBounds(20, 50, 185, 30);
        GUI.add(botonAg);

        JButton botonLista = new JButton("Lstar todos los fighters: ");
        botonLista.setBounds(20, 100, 185, 30);
        GUI.add(botonLista);

        JButton botonDelete = new JButton("Eliminar un Fighter");
        botonDelete.setBounds(20, 150, 185, 30);
        GUI.add(botonDelete);

        JButton botonModF = new JButton("Modificar un fighter");
        botonModF.setBounds(20, 200, 185, 30);
        GUI.add(botonModF);

        JButton botonID = new JButton("Buscar por id");
        botonID.setBounds(20, 250, 185, 30);
        GUI.add(botonID);

        ventanaTexto = new JTextArea();
        ventanaTexto.setEditable(false); // para que la ventana el usuario no la pueda editar 
        ventanaTexto.setBounds(200, 90, 460, 300);
        GUI.add(ventanaTexto);
        

        //Aqui agregamos los ActionListener que son los que hacen que cuando toques el boton el codigo de ese metodo se ejecute.
        botonAg.addActionListener((ActionEvent e) -> {
            agregarFighter();
        });

    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    // El metodo validNumero lo estoy creando para validar que el revise si un numero se puede convertir en un entero ya que
    // el JOPtion Pane siempre devuelve texto no numeros enteros que es lo que ocupo para la vida, defensa, etc.
    public static boolean validNumero(String texto) {

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
            if (carac < '0' || carac > '9') { // reccore todos los caracters y si no esta entre 0 y 9 ya sabemos que no es un numero
                return false;
            }
        }

        // pasando la revision ya se que es valido
        return true;

    }

    public static int pedirNumero(String mensaje, int min, int max, String mensajeError) {

        boolean validNum = false;
        int numero = -1;

        while (!validNum) {
            String texto = JOptionPane.showInputDialog(GUI, mensaje);

            if (texto == null) {
                return 0;
            }

            numero = 0;
            if (validNumero(texto)) {
                numero = Integer.parseInt(texto);
            }

            if (numero >= min && numero <= max) {
                validNum = true;
            } else {
                JOptionPane.showMessageDialog(GUI, mensajeError, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return 0;

    }

    public static void agregarFighter() {

        boolean fighter = false;
        // Nombre
        
        
        while (!fighter) {
            boolean crearFigh = true;

            String nomFighter = JOptionPane.showInputDialog(GUI, "Ingrese el nombre del fighter");
            if (nomFighter == null) {
                return;
            }
            if (nomFighter.trim().isEmpty()) { // validacion que el nombre no puede estar vacio
                JOptionPane.showMessageDialog(GUI, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                crearFigh = false;
            }
            
            

            // Vida
            int vida = 0;
            if (crearFigh) {
                String vidaFigh = JOptionPane.showInputDialog(GUI, "Ingrese la vida del fighter");
                if (vidaFigh == null) {
                    return;
                }

                if (validNumero(vidaFigh)) {
                    vida = Integer.parseInt(vidaFigh);

                }
                if (vida < 100 || vida > 200) { // validacion que la vida debe estar entre 100 y 200
                    JOptionPane.showMessageDialog(GUI, "La vida tiene estar entre 100 y 200", "Error", JOptionPane.ERROR_MESSAGE);
                    fighter = false;
                }
            }
            

            // Defensa
            int defensa = 0;
            if (crearFigh) {
                String defensaFigh = JOptionPane.showInputDialog(GUI, "Ingrese la defensa del fighter (5 - 30)");
                if (defensaFigh == null) {
                    return;
                }
                if (validNumero(defensaFigh)) {
                    defensa = Integer.parseInt(defensaFigh);
                }
                if (defensa < 5 || defensa > 30) { 
                    JOptionPane.showMessageDialog(GUI, "La defensa debe estar entre 5 y 30", "Error", JOptionPane.ERROR_MESSAGE);
                    crearFigh = false;
                }
            }
            

            // Ataque
            int ataque = 0;
            if (crearFigh) {
                String ataqueFigh = JOptionPane.showInputDialog(GUI, "Ingrese el ataque del fighter (10 - 50)");
                if (ataqueFigh == null) {
                    return;
                }
                if (validNumero(ataqueFigh)) {
                    ataque = Integer.parseInt(ataqueFigh);
                }
                if (ataque < 10 || ataque > 50) { // ataque tiene que estar entre 10 y 50 
                    JOptionPane.showMessageDialog(GUI, "El ataque debe estar entre 10 y 50", "Error", JOptionPane.ERROR_MESSAGE);
                    crearFigh = false;
                }
            }
            
            if (crearFigh) {
                Fighter agFighter = new Fighter(nomFighter, vida,defensa,ataque);
                JOptionPane.showInputDialog(GUI,"Fighter agregado con exito");
                ventanaTexto.setText(agFighter.toString());
                fighter = true;

        }

    }
    }
    public static void ListaFighters() {

    }

    public static void EliminarFighter() {

    }

    public static void modFighter() {

    }

    public static void buscarID() {

    }

}
