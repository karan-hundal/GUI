import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class PComboBox extends JFrame implements ActionListener {
	JComboBox comboBox;

	PComboBox(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		String[]animals = {"dog","cat","bird"};
		 comboBox= new JComboBox(animals);
		 comboBox.addActionListener(this);
		 comboBox.addItem("Horse");
		this.add(comboBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox) {
			System.out.println(comboBox.getSelectedItem() +" "+ comboBox.getSelectedIndex());
		}
	}
}
