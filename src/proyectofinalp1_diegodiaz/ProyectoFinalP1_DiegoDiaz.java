
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

        GUI = new JFrame("Proyedto Final Lab Programacion - Diego Diaz ");
        GUI.setSize(500, 500);
        GUI.setLayout(null);
        GUI.setLocationRelativeTo(null);// centrar pantalla
        GUI.setVisible(true); // mostrar pantalla
        
        
        // Botones que van a aparecer en pantalla gui
        JButton botonAg = new JButton ("Agregar un fighter");
        botonAg.setBounds(20, 50, 90, 100);
        GUI.add(botonAg);

        JButton botonLista = new JButton ("Lstar todos los fighters: ");
        botonAg.setBounds(20, 90, 90, 100);
        GUI.add(botonAg);
        
        JButton botonDelete = new JButton ("Eliminar un Fighter");
        botonAg.setBounds(20, 150, 90, 100);
        GUI.add(botonAg);
        
        JButton botonModF = new JButton ("Modificar un fighter");
        botonAg.setBounds(20,190, 90, 100);
        GUI.add(botonAg);
        
        JButton botonID = new JButton ("Buscar por id");
        botonAg.setBounds(20, 240, 90, 100);
        GUI.add(botonAg);
        
        
        
        
        
        
        
        
        
        
    }
    
}
