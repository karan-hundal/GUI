import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Label {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Border border=BorderFactory.createLineBorder(Color.green);
		
		JLabel label=new JLabel();
		label.setText("My name is Karan");
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setForeground(new Color(0,0,200));
		label.setFont(new Font("MV Boli", Font.BOLD, 100));
		label.setIconTextGap(-25);
		label.setBackground(Color.pink);
		label.setOpaque(true);
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
//		label.setBounds(0,0, 250,250);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.add(label);
		frame.pack();
	}

}
