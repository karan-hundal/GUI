import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyCheckBox extends JFrame implements ActionListener {
	JButton button;
	JCheckBox checkBox;
	

	MyCheckBox(){
		
		
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
                
       
        
        
        checkBox = new JCheckBox();
        checkBox.setText("I'm not robot");
        checkBox.setFocusable(false);
        
         button = new JButton();
        button.setText("Submit");
        button.setFocusable(false);
        button.addActionListener(this);
        
        this.add(checkBox);
        this.add(button);
        this.pack();
        this.setVisible(true);
        
        
        
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			System.out.println(checkBox.isSelected()); 
			
		}
		
	}
	
	
}
