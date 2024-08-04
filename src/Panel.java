import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JLabel label= new JLabel();
		label.setText("Karan");
		label.setVerticalAlignment(JLabel.CENTER);
		
		JPanel redpanel = new JPanel();
		redpanel.setBackground(Color.red);
		redpanel.setBounds(0,0,250,250);
		redpanel.setLayout(new BorderLayout());
		
		JPanel bluepanel = new JPanel();
		bluepanel.setBackground(Color.blue);
		bluepanel.setBounds(250,0,250,250);
		
		JPanel greenpanel = new JPanel();
		greenpanel.setBackground(Color.green);
		greenpanel.setBounds(0,250,500,250);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(500,500);
		frame.setVisible(true);	
		redpanel.add(label);
		frame.add(redpanel);
		frame.add(greenpanel);
		frame.add(bluepanel);
	}

}
