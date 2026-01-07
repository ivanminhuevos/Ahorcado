package paneles;

import javax.swing.*;
import java.awt.*;

public class AhorcadoPanel extends JPanel {
    private int estado = 0;
    public void setEstado(int estado) {
        this.estado = estado;
    }

    private final BasicStroke str = new BasicStroke(4.0f);
    private final Color COLOR_AHORCADO = new Color(0, 0, 0);
    private final Color[] COLOR_FONDO_ESTADO = {
            new Color(196, 196, 220),
            new Color(196, 196, 220),
            new Color(196, 196, 220),
            new Color(196, 196, 220),
            new Color(196, 196, 220),
            new Color(196, 196, 220),
            new Color(196, 196, 220),
    };

    private void dibujarAhorcado(Graphics2D g) {
        Rectangle size = g.getClipBounds();
        int x = (int) size.getX();
        int y = (int) size.getY();
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();

        int cX = (w / 2) + x;
        int cY = (h / 2) + y;

        int offX = -64;
        int offY = 64;

        // dbuja el sporte
        g.setColor(COLOR_AHORCADO);
        g.setStroke(str);

        // palo suelo
        g.drawLine(cX + offX, cY + offY, cX + 48 + offX, cY + offY);

        // palo vertical
        g.drawLine(cX + 24 + offX, cY + offY, cX + 24 + offX, cY - 144 + offY);

        // palo horiz vert
        g.drawLine(cX + 24 + offX, cY - 144 + offY, cX + 96 + offX, cY - 144 + offY);

        // palo diagonal
        g.drawLine(cX + 24 + offX, cY - 120 + offY, cX + 48 + offX, cY - 144 + offY);

        // cuerda
        g.drawLine(cX + 96 + offX, cY - 144 + offY, cX + 96 + offX, cY - 128 + offY);

        // ahora, a partir del estado:
        if(estado > 0) { // cabeza
            g.drawOval(cX + 96 + offX - 12, cY - 128 + offY, 24, 24);
        }

        if(estado > 1) { // cuerpo
            g.drawLine(cX + 96 + offX, cY - 128 + offY + 24, cX + 96 + offX, cY - 128 + offY + 64);
        }

        if(estado > 2) { // mano izquierda
            g.drawLine(cX + 96 + offX, cY - 128 + offY + 24, cX + 72 + offX, cY - 128 + offY + 48);
        }

        if(estado > 3) { // mano derecha
            g.drawLine(cX + 96 + offX, cY - 128 + offY + 24, cX + 120 + offX, cY - 128 + offY + 48);
        }

        if(estado > 4) { // pierna izquierda
            g.drawLine(cX + 96 + offX, cY - 128 + offY + 64, cX + 72 + offX, cY - 128 + offY + 84);
        }

        if(estado > 5) { // pierna derecha
            g.drawLine(cX + 96 + offX, cY - 128 + offY + 64, cX + 120 + offX, cY - 128 + offY + 84);
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

        g.setColor(COLOR_FONDO_ESTADO[estado]);
        g.fillRect(x, y, w, h);

        g.setColor(COLOR_AHORCADO);
        g.fillRect(x, h - 4, w, 4);

        dibujarAhorcado((Graphics2D) g);
    }
}
