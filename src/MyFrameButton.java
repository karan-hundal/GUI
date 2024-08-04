import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrameButton extends JFrame implements ActionListener {
	JButton button;
	JLabel label;
	MyFrameButton(){
		
		label= new JLabel();
		label.setText("YOU HAVE CLICKED ON BUTTON");
		label.setBounds(150,150,150,150);
		label.setVisible(false);
		
		 button=new JButton();
		button.setBounds(100, 100, 100, 50);
		button.addActionListener(this);
		button.setText("Yo");
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.TOP);
		button.setFont(new Font("Comic Sans", Font.BOLD, 25));
		button.setForeground(Color.cyan);
		
		
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==button) {
			System.out.println("Karan");
			label.setVisible(true);
			button.setEnabled(false);
		}
		
	}
}
