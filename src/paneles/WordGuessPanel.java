package paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Arrays;

public class WordGuessPanel extends JPanel {
    private final Color COLOR_LINEAS = new Color(0, 0, 0);
    private final Color COLOR_TEXTO = new Color(128, 128, 255);
    private final Color COLOR_TEXTO_SHADOW = new Color(48, 64, 96);
    private final BasicStroke str = new BasicStroke(4.0f);

    private String palabra = "Invalida";
    private Boolean[] encontradas;
    public void setPalabra(String palabra) {
        this.palabra = palabra;
        this.encontradas = new Boolean[palabra.length()];

        Arrays.fill(encontradas, false);
    }

    public void revelarCaracter(int i) {
        encontradas[i] = true;
    }

    public void revelarTodo() {
        Arrays.fill(encontradas, true);
    }

    public boolean getTodoRevelado() {
        for(int i = 0; i < encontradas.length; i++) {
            if(!encontradas[i]) {
                return false;
            }
        }

        return true;
    }

    private void dibujarPalabra(Graphics2D g) {
        Rectangle size = g.getClipBounds();
        int x = (int) size.getX();
        int y = (int) size.getY();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        int cX = (w / 2) + x;
        int cY = (h / 2) + y;

        g.setColor(COLOR_LINEAS);
        g.setStroke(str);

        int palabraLen = this.palabra.length();

        int anchoPalabra = 32;

        int pasoSz = w / (palabraLen);

        AffineTransform identity = g.getTransform();

        AffineTransform at = new AffineTransform();

        //FontMetrics fntMetrics = g.getFontMetrics();
        //int anchoLetra;

        for(int i = 0; i < palabraLen; i++) {
            int xC = i * pasoSz + (pasoSz / 4);

            g.setColor(COLOR_LINEAS);
            g.drawLine(xC, h - 8, xC + anchoPalabra, h - 8);

            String letra = palabra.substring(i, i + 1);
            //anchoLetra = fntMetrics.stringWidth(letra);

            at.setTransform(identity);
            at.translate(xC, h - 12);
            at.scale(4, 4);

            if(encontradas[i]) {
                g.setTransform(at);
                g.setColor(COLOR_TEXTO_SHADOW);
                g.drawString(letra, 0.25f, 0.25f);
                g.setColor(COLOR_TEXTO);
                g.drawString(letra, 0, 0);
                g.setTransform(identity);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle size = g.getClipBounds();
        int x = (int) size.getX();
        int y = (int) size.getY();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        //g.setColor(new Color(0, 255, 0));
        //g.fillRect(x, y, w, h);

        dibujarPalabra((Graphics2D) g);
    }
}
