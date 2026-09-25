package proyectofinalp1_diegodiaz;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

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
        JScrollPane sc = new JScrollPane(ventanaTexto); // agrego barra de scroll por si ocupa scrollear por si hay muchos datos por ejmeplo en el ejer de bono q hare
        sc.setBounds(220, 50, 460, 300);
        GUI.add(sc);
        // y elimino la ventana de texto porq es lo mismo que la de scroll, me salian como dos ventanas.

        //Aqui agregamos los ActionListener que son los que hacen que cuando toques el boton el codigo de ese metodo se ejecute.
        botonAg.addActionListener((ActionEvent e) -> {
            agregarFighter();
        });

        botonLista.addActionListener((ActionEvent e) -> {
            ListaFighters();
        });

        botonDelete.addActionListener((ActionEvent e) -> {
            EliminarFighter();
        });
        botonModF.addActionListener((ActionEvent e) ->{
            modFighter();
        });
        botonID.addActionListener((ActionEvent e ) ->{
        buscarID();    
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

        return numero; // ahora pedir numero devuelve el numero que el usuario ingreso

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
                String vidaFigh = JOptionPane.showInputDialog(GUI, "Ingrese la vida del fighter (100 - 200)");
                if (vidaFigh == null) {
                    return;
                }

                if (validNumero(vidaFigh)) {
                    vida = Integer.parseInt(vidaFigh);

                }
                if (vida < 100 || vida > 200) { // validacion que la vida debe estar entre 100 y 200
                    JOptionPane.showMessageDialog(GUI, "La vida tiene estar entre 100 y 200", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }

            // Defensa
            int defensa = 0;
            if (crearFigh) {
                String defensaFigh = JOptionPane.showInputDialog(GUI, "Ingrese la defensa del fighter (5 - 30");
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
                Fighter agFighter = new Fighter(nomFighter, vida, defensa, ataque);
                JOptionPane.showInputDialog(GUI, "Fighter agregado con exito");
                fighters.add(agFighter); // Aqui agrego Fighter a la lista, para que asi cuando le demos click al boton de lista de fighters salgan.
                ventanaTexto.setText(agFighter.toString());
                fighter = true;

            }

        }
    }

    public static void ListaFighters() {

        if (fighters.isEmpty()) {
            ventanaTexto.setText("No hay fighters disponibles"); // validacion por si no se agregan fighters
            return;
        }

        String nomLista = "Fighters disponibles: \n";
        for (int i = 0; i < fighters.size(); i++) {
            nomLista = nomLista + (i + 1) + ". " + fighters.get(i).toString() + "\n"; // recorro la lista con el for y el i + 1 es para que empieze en 1 y no en 0
        }
        ventanaTexto.setText(nomLista);

    }

    public static void EliminarFighter() {

        // Aqui volvemos a solo copiar y pegar el mismo bloque que esta arriba en el metodo lista Fighters porque ocupo la lista de los nombres otra vez aqui
        // para poder eliminarlos.
        String nomLista = "Fighters disponibles: \n";
        for (int i = 0; i < fighters.size(); i++) {
            nomLista = nomLista + (i + 1) + ". " + fighters.get(i).toString() + "\n";

        }
        // Aqui lo que se hace es que se establecen los limites usando el metodo que cree pedirNumero, con los parametros extablescidos, empzando desde 1 hasta fighter.size.
        //String, int, int, String mensaje error, ese orden tiene que llevar.
        int numero = pedirNumero(nomLista + "Seleccione el numero del fighter:", 1, fighters.size(), "Ingrese un número válido");
        if (numero == 0) {
            return;

        }
        fighters.remove(numero - 1);
        JOptionPane.showMessageDialog(ventanaTexto, "Fighter eliminado con exito..");
        ListaFighters();
    }

    public static void modFighter() {
        
        // Aqui vuelvo a copiar el bloque de arriba de eliminar fighter ya que no hice un metodo que arme la lista de fighters y se me hace mas facil 
        // ya solo copiarlo otra vez aqui para tener la lista de los fighters disponible
        String nomLista = "Fighters disponibles: \n";
        for (int i = 0; i < fighters.size(); i++) {
            nomLista = nomLista + (i + 1) + ". " + fighters.get(i).toString() + "\n";

        }
       
        int numero = pedirNumero(nomLista + "\nSeleccione el numero del fighter:", 1, fighters.size(), "Ingrese un número válido");
        if (numero == 0) {
            return;

        }
        
        Fighter modificar = fighters.get(numero - 1);
        String opmod = JOptionPane.showInputDialog(GUI,"que desea modificar del fighter? \n" + modificar.getNombre() + "1. Vida" + "\n 2.Ataque" + "\n3. Defensa");
        
        
        // Aqui mediante if y else if establecemos los limites de vida,defensa ya ataque usando siempre el metodo pedirnumero y el mismo bloque para vida lo copiamos para ataque y defensa
        if (opmod.equals("1")) {
            int nuevaVida = pedirNumero("Nueva vida: ",100,200,"La vida tiene que estar entre 100 y 200");
            if (nuevaVida == 0) {
                return;
            }
            modificar.setVida(nuevaVida); // Aqui arreglamos el error de que cuando ponias el nuevo valor de lo que querias cambiar no actualizaba por que no lo guarde en el objeto en el setter
        }
        else if (opmod.equals("2")) {
            int nuevoAtaque = pedirNumero("Nuevo ataque: ",10,50, "El ataque tiene que estar entre 10 y 50");
            if (nuevoAtaque == 0) {
                return;
            }
            modificar.setAtaque(nuevoAtaque); // lo mismo que set vida
        }
        else if (opmod.equals("3")) {
            int nuevadefensa = pedirNumero("Nueva defensa: ",5,30,"La nueva defensa tiene que estar entre 5 y 30");
            if (nuevadefensa == 0) {
                return;
            }
          modificar.setDefensa(nuevadefensa); // lo mismo que setvida
        }
        JOptionPane.showMessageDialog(GUI, "Fighter modificado con exito!!");
        ventanaTexto.setText("Fighter modificado:\n" + modificar.toString());

    }

    public static void buscarID() {
        
    // En este metodo es el mas corto ya que el metodo pedirnumero me ayuda bastante
        int numero = pedirNumero("\nIngrese el numero del fighter que desea buscar:", 1, fighters.size(), "Ingrese un numero valido");
        if (numero == 0) {
            return;

            
    }
        Fighter modificar = fighters.get(numero - 1);
        ventanaTexto.setText("Fighter encontrado !!: \n" + modificar.getNombre());
    }
    
    public static void bonus(){
        
        if (fighters.size() < 2) {
            ventanaTexto.setText("Se necesitan 2 fighters para iniciar la simulacion"); // validamos la creacion obligatoria de dos fighters si no mo pasa
            return;
        }

        String  disponibles = "Fighters disponibles: "; // como siempre ponemos el bloque del la lista de fifhters
        for (int i = 0; i < fighters.size(); i++) {
          disponibles  = disponibles + (i + 1) + ". " + fighters.get(i).getNombre() + " (vida: )" + fighters.get(i).getVida();
        }

        int numero1 = pedirNumero(disponibles + " Elige el numero de tu fighter:", 1, fighters.size(), "Ingrese un numero valido");
        if (numero1 == 0) {
            return;
        }
        
    }
}
