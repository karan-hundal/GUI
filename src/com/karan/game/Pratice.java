package com.karan.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Pratice extends JFrame implements ActionListener {
    final int BOXES = 10;// total number of checkBoxes
    final int MAXCHOICES = 3; // Max turn

    final FlowLayout flow = new FlowLayout(); // layout of the frame
    final JLabel greeting = new JLabel("Select 1, 2 or 3 boxes");// first label in the frame
    final Font serifBold = new Font("Serif", Font.BOLD, 20);// font of the label
    final JCheckBox[] boxes = new JCheckBox[BOXES];// array of the checkboxes and BOXES is the limit of the array
    final JButton button = new JButton("Done"); // created a button

    boolean isComputersTurn = false;

    int numOfChoicesCompleted = 0;
    ArrayList currentBoxes = new ArrayList<Integer>();

    public Pratice(String label) {

        super(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        add(greeting);
        greeting.setFont(serifBold);
        createAllBoxes();
        add(button);
        button.addActionListener(this);
    }

    private void createAllBoxes() {
        for (int x = 0; x < BOXES; ++x) {

            boxes[x] = new JCheckBox();
            add(boxes[x]);
            boxes[x].addActionListener((ActionEvent e) -> {
                if (!isComputersTurn) {
                    JCheckBox source = (JCheckBox) e.getSource();
                    if (source.isSelected() && MAXCHOICES - 1 < numOfChoicesCompleted) {
                        source.setSelected(false);
                    } else if (!source.isSelected()) {
                        if (!currentBoxes.contains(source))
                            source.setSelected(true);

                        else numOfChoicesCompleted--;
                    } else {
                        numOfChoicesCompleted++;
                        currentBoxes.add(source);
                    }
                }
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleDoneEvent(e.getSource());

    }

    private void handleDoneEvent(Object source) {
        if (areAllCheckboxesSelected()) {
            gamesUp("You Win");
        } else {
            currentBoxes.clear();
            isComputersTurn = true;
            int boxesRemaining = howManyFreeBoxes();
            boxesRemaining = boxesRemaining % 4;

            int numOfBoxesToBeChecked = 0;
            if (boxesRemaining == 0)
                numOfBoxesToBeChecked = ((int) (Math.random() * 100) % MAXCHOICES);
            else numOfBoxesToBeChecked = boxesRemaining;

            int x = numOfBoxesToBeChecked;
            for (int y = 0; y < BOXES && x > 0; ++y) {
                if (!boxes[y].isSelected()) {
                    boxes[y].setSelected(true);
                    x--;
                    if (x == 0)
                        break;
                }
            }

            isComputersTurn = false;
            if (areAllCheckboxesSelected()) {
                String winner = "Computer wins";
                gamesUp(winner);

            }
            numOfChoicesCompleted = 0;
        }
    }

    public boolean areAllCheckboxesSelected() {
        boolean isDone = true;
        for (int x = 0; x < BOXES; ++x) {
            if (!boxes[x].isSelected())
                isDone = false;
        }
        return isDone;
    }

    public void gamesUp(String winner) {
        button.setEnabled(false);
        for (int x = 0; x < BOXES; ++x)
            remove(boxes[x]);
        JLabel done = new JLabel("Game over - " + winner);
        add(done);
        validate();
        repaint();
    }

    public int howManyFreeBoxes() {
        int count = 0;
        for (int x = 0; x < BOXES; ++x)
            if (!boxes[x].isSelected())
                ++count;
        return count;
    }


    public static void main(String[] arguments) {
        Pratice frame = new Pratice("Last Man Standing");
        frame.setSize(300, 120);
        frame.setVisible(true);
    }

}
