package com.karan.game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Pratice extends JFrame implements ItemListener, ActionListener
{
   final int BOXES = 10;// total number of checkBoxes
   final int MAXCHOICES = 3; // Max turn

   final FlowLayout flow = new FlowLayout(); // layout of the frame
   final JLabel greeting = new JLabel("Select 1, 2 or 3 boxes");// first label in the frame
   final Font serifBold = new Font("Serif", Font.BOLD, 20);// font of the label
   final JCheckBox[] boxes = new JCheckBox[BOXES];// array of the checkboxes and BOXES is the limit of the array
   final JButton button = new JButton("Done"); // created a button

   boolean[] isChosen = new boolean[BOXES];// 
   boolean computersTurn = false;
   boolean allDone = false;
   int ran;
   int numChosen = 0;
   public Pratice(String label)
   {

      super(label);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLayout(flow);
      add(greeting);
      greeting.setFont(serifBold);
      for(int x = 0; x < BOXES; ++x)
      {
         boxes[x] = new JCheckBox();
         add(boxes[x]);
         boxes[x].addItemListener(this);
      }
      add(button);
      button.addActionListener(this);
   }
   public static void main(String[] arguments)
   {
      Pratice frame = new Pratice("Last Man Standing");
      frame.setSize(300,120);
      frame.setVisible(true);
   }
   @Override
   public void itemStateChanged(ItemEvent check)
   {
      if(!computersTurn)
      {
         JCheckBox source = (JCheckBox) check.getItem();
         if(source.isSelected() && MAXCHOICES-1<numChosen){
             check.
           //  numChosen++;
         }
         else if((!source.isSelected()) && MAXCHOICES-1 < numChosen){
             numChosen--;
         }
         else{
             numChosen++;
         }


//          for(int x = 0; x < BOXES; ++x)
//         {
//             if(source == boxes[x])
//             {
//                  boxes[x].setSelected(true);
//                  if(numChosen < MAXCHOICES)
//                  {
//                      isChosen[x] = true;
//                      ++numChosen;
//                  }
//                  else
//                      boxes[x].setSelected(false);
//                  x = BOXES;
//               }
//          }
       }
   }
   @Override
   public void actionPerformed(ActionEvent e)
   {
         if(allDone())
         { 
                String winner = "You win";
                finishUp(winner);
         }
         else
         {
             computersTurn = true;
             int boxesRemaining = howManyFreeBoxes();
             boxesRemaining = boxesRemaining % 4;
             if(boxesRemaining == 1)
                ran = 0;
             else if(boxesRemaining == 2)
                     ran = 1;
             else if(boxesRemaining == 3)
                           ran = 2;
             else
              ran = ((int)(Math.random() * 100) % MAXCHOICES);
             for(int x = 0; x <= ran; ++x)
             {
                  for(int y = 0; y < BOXES; ++y)
                  {
                      if(!isChosen[y])
                      {
                         isChosen[y] = true;
                         boxes[y].setSelected(true);
                         y = BOXES;
                      }
                  }
             }
             computersTurn = false;
             if(allDone())
             { 
                String winner = "Computer wins";
                finishUp(winner);    
                
             }
             numChosen = 0;
         }
    }
    public boolean allDone()
    {
         boolean isDone = true;
         for(int x = 0; x < BOXES; ++x)
         {
               if(!isChosen[x])
                  isDone = false;
         }
         return isDone;
    }
    public void finishUp(String winner)
    {
         button.setEnabled(false);
         for(int x = 0; x < BOXES; ++x)
               remove(boxes[x]);
         JLabel done = new JLabel("Game over - " + winner);
         add(done);
         validate();
         repaint();
    }
    public int howManyFreeBoxes()
    {
       int count = 0;
       for(int x = 0; x < BOXES; ++x)
            if(!isChosen[x])
               ++count;
       return count;
    }

}
