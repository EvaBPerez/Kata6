package kata6.apps.swing;

import kata6.model.Block;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kata6.view.BlockDisplay;

public class BlockPanel extends JPanel implements BlockDisplay {
    private static final int SIZE = 100;
    private Block block;
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.black);
        int size = SIZE*Block.MAX;
        for (int i = 0; i < size; i+=SIZE) {
        // Lineas verticales
            g.drawLine(i, 0, i, size);
        // Lineas horizontales
            g.drawLine(0, i, size, i);
        }
        
        if (block == null) return;
        g.setColor(Color.red);
        g.fillRect((block.X()-1)*SIZE, (Block.MAX - block.Y())*SIZE, SIZE, SIZE); // un cuadrado
    }

    @Override
    public void display(Block block) {
        this.block = block;
        this.block.register(this);
        repaint();
    }

    @Override
    public Block block() {
        return block;
    }

    @Override
    public void changed() {
        repaint();
    }
}
