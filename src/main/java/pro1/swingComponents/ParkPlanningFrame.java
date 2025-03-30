package pro1.swingComponents;

import pro1.dravingModel.Drawable;
import pro1.dravingModel.Rectangle;
import pro1.dravingModel.Tree;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class ParkPlanningFrame extends JFrame {
    private int LastX, LastY;
    private ArrayList<Drawable> drawables = new ArrayList<>();      // array na stromy
    DrawingPanel drawingPanel;

    public ParkPlanningFrame(Drawable example) {
        this.setTitle("Park Planning");     // this ukazuje, že to je zděděné
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanel(example);
        add(drawingPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(new Dimension(200, 0));

        JLabel label1 = new JLabel("#123456");
        leftPanel.add(label1);

        JTextField textField = new JTextField(7);    // vytvoří textové pole
        textField.setEditable(true);
        leftPanel.add(textField);

        JButton buttonReset = new JButton("Reset");
        leftPanel.add(buttonReset);
        buttonReset.addActionListener((e)->{
//            drawables.clear();          // vymaže stromy ze seznamu
//            drawingPanel.repaint();     // přebarví
            drawingPanel.setImage(new Rectangle(-1000, -1000, 10000, 10000, "#FFFFFF")); // nabarví bílou barvou
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                LastX = e.getX() - 550;   // uložím si informaci, kde se myš právě nacházela
                LastY = e.getY() - 200;
                try {                                                           // try/catch kvůly textovému poli
                    String color;
                    color = textField.getText();                                // nastaví barvu, která je v poli
                    if (textField.getText().equals("")) {                       // zkontroluju, jestli je pole prázdné
                        drawables.add(new Tree(LastX, LastY, 200, 200, "#000000")); // mělo by přidat strom do Array drawables
//                        drawingPanel.repaint();
                        drawingPanel.setImage(drawables.get(drawables.size() - 1));
                        for (Drawable d : drawables) {
                            drawingPanel.setImage(d); // rezignuju :)
                        }
                    } else {
                        drawables.add(new Tree(LastX, LastY, 200, 200, color));
//                        drawingPanel.repaint();
                        drawingPanel.setImage(drawables.get(drawables.size() - 1));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });

    }




}
