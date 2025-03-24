package pro1.swingComponents;

import pro1.dravingModel.Drawable;
import pro1.dravingModel.Ellipse;
import pro1.dravingModel.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    DrawingPanel drawingPanel;
    private int LastX;
    private int LastY;

    public MainFrame(Drawable example) {
        this.setTitle("PRO1 Graphics");     // this ukazuje, že to je zděděné
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(example);
        add(drawingPanel, BorderLayout.CENTER); // border layout center říká, že má být panel v prostřed

        JPanel leftPanel = new JPanel();    // JPanel - šedivý prázdný panel, co nic neumí (musím ještě specifikovat)
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(new Dimension(100, 0)); // nastaví šířku

        JButton button1 = new JButton("Draw rectangle"); // přídá tlačítko
        leftPanel.add(button1);

        JCheckBox checkBox1 = new JCheckBox("Random color"); // přidá zaškrtávací políčko
        leftPanel.add(checkBox1);

        Random random = new Random();

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                LastX = e.getX() - 550;   // uložím si informaci, kde se myš právě nacházela
                LastY = e.getY() - 200;
            }
        });

        button1.addActionListener((e)->{
            String color;
            if (checkBox1.isSelected()) {
                String r = Integer.toHexString(random.nextInt(256));
                String g = Integer.toHexString(random.nextInt(256));
                String b = Integer.toHexString(random.nextInt(256));
                color = "#" + r + b + g;
            } else {
                color = "#000000";
            }
            drawingPanel.setImage(new Rectangle(LastX, LastY, 100, 100, color));
        });  // tenhle lambda výraz má 2 části
    }
}
