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
import java.util.regex.Pattern;

public class ParkPlanningFrame extends JFrame {
    private int LastX, LastY;
    DrawingPanelArray drawingPanel;

    public ParkPlanningFrame(Tree example) {

        this.setTitle("Park Planning");     // this ukazuje, že to je zděděné
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        drawingPanel = new DrawingPanelArray(example);
        add(drawingPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setPreferredSize(new Dimension(200, 0));

        JLabel label1 = new JLabel("#:");
        leftPanel.add(label1);

        JTextField textField = new JTextField(7);    // vytvoří textové pole
        textField.setEditable(true);
        leftPanel.add(textField);

        JButton buttonReset = new JButton("Reset");
        leftPanel.add(buttonReset);
        buttonReset.addActionListener((e)->{
            drawingPanel.clear();
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                LastX = e.getX();   // uložím si informaci, kde se myš právě nacházela
                LastY = e.getY();

                try {                                                           // try/catch kvůly textovému poli
                    String color;
                    color = textField.getText();                                // nastaví barvu, která je v poli
                    String regex = "(#[0-9a-fA-F]{6})";
                    if (!textField.getText().isEmpty() && Pattern.matches(regex, "#" + color)) {                        // zkontroluju, jestli je pole prázdné
                        color = "#" + color;
                        drawingPanel.setImage(new Tree(LastX, LastY, 200, 200, color));
                    } else {
                        drawingPanel.setImage(new Tree(LastX, LastY, 200, 200, "#000000"));
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });

    }




}
