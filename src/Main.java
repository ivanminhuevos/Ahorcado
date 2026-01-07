import palabras.CategoriasPalabras;
import palabras.FabricaCategoriaPalabras;
import paneles.AhorcadoPanel;
import paneles.WordGuessPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static int estado = 0;
    private static String palabraSecreta;

    private static void mensajeGanado() {
        System.out.println("Has ganado!");
        System.out.printf("La palabra era: %s\n", palabraSecreta);
    }

    private static void mensajePerdido() {
        System.out.println("Has perdido!");
        System.out.printf("La palabra era: %s\n", palabraSecreta);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();

        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();

        CategoriasPalabras seleccion = (CategoriasPalabras) JOptionPane.showInputDialog(
                window,
                "Seleccione la categoria de palabras",
                "Tipo de ahorcado",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new CategoriasPalabras[] {CategoriasPalabras.PAISES, CategoriasPalabras.JUGADORES, CategoriasPalabras.IDIOMAS_PROGRAMACION},
                CategoriasPalabras.PAISES);

        if(seleccion == null) {
            System.out.println("Ninguna opcion escogida, parando!");
            window.dispose();
            return;
        }

        System.out.printf("La categoria es: %s\n", seleccion);

        FabricaCategoriaPalabras fab = new FabricaCategoriaPalabras();


        palabraSecreta = fab.obtenerPalabra(seleccion);


        window.setSize(600, 400);
        window.setTitle("Ahorcado");
        window.setLocation(scrSize.width / 2 - (window.getWidth() / 2), scrSize.height / 2 - (window.getHeight() / 2));
        window.setResizable(false);

        AhorcadoPanel ahorcado = new AhorcadoPanel();
        ahorcado.setLocation(0, 0);
        ahorcado.setSize(600, 250 - 32);

        window.add(ahorcado);

        WordGuessPanel adivinanza = new WordGuessPanel();
        adivinanza.setLocation(0, 250 - 32);
        adivinanza.setSize(600, 64);
        adivinanza.setPalabra(palabraSecreta);
        window.add(adivinanza);


        JTextField entrada = new JTextField();
        entrada.setLocation(50 - 8, 250 - 32 + 64 + 24);
        entrada.setSize(500, 32);
        window.add(entrada);


        entrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estado > 5) {
                    return;
                }

                String msg = entrada.getText();

                if(msg.length() > 1) {
                    if(msg.equalsIgnoreCase(palabraSecreta)) {
                        adivinanza.revelarTodo();
                        adivinanza.repaint();
                    } else {
                        estado++;
                    }
                } else {
                    char letra = msg.toLowerCase().charAt(0);

                    boolean found = false;
                    String secretaLower = palabraSecreta.toLowerCase();
                    for(int i = 0; i < palabraSecreta.length(); i++) {
                        if(secretaLower.charAt(i) == letra) {
                            adivinanza.revelarCaracter(i);
                            found = true;
                        }
                    }

                    if(found) {
                        adivinanza.repaint();
                    } else {
                        estado++;
                    }
                }

                ahorcado.setEstado(estado);
                ahorcado.repaint();

                if(adivinanza.getTodoRevelado()) {
                    mensajeGanado();
                }

                // chequea si emos perdido
                if(estado > 5) {
                    mensajePerdido();
                }

                entrada.setText("");
            }
        });


        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window.dispose();
            }
        });

        window.setLayout(null);
        window.setVisible(true);
    }
}
