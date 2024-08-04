
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Resort extends JFrame implements ItemListener{
	   final int BASE_PRICE = 200;
	   final int WEEKEND_PREMIUM = 100;
	   final int BREAKFAST_PREMIUM = 20;
	   final int GOLF_PREMIUM = 75;
	   int totalPrice = BASE_PRICE;
	   
	   JCheckBox weekendBox = new JCheckBox
	   ("Weekend Premium $"+ WEEKEND_PREMIUM, false);
	   
	   JCheckBox breakfast = new JCheckBox
			   ("Breakfast $"+ BREAKFAST_PREMIUM, false);
	   
	   JCheckBox golf = new JCheckBox
			   ("Weekend Premium $"+ GOLF_PREMIUM, false);
	   
	   JLabel resortLabel = new JLabel
			   
			      ("Resort Price Calculator");
			   JLabel priceLabel = new JLabel
			      ("The price for your stay is");
			   JTextField totPrice = new JTextField(4);
			   JLabel optionExplainLabel = new JLabel
			       ("Base price for a room is $" +
			       BASE_PRICE + ".");
			   JLabel optionExplainLabel2 = new JLabel
			       ("Check the options you want."); 
	   
	   
	   Resort(){
		   super("Resort Price Estimator");
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setLayout(new FlowLayout());
		      this.add(resortLabel);
		      add(resortLabel);
		      add(optionExplainLabel);
		      add(optionExplainLabel2);
		      add(weekendBox);
		      add(breakfast);
		      add(golf);
		      add(priceLabel);
		      add(totPrice);
		      totPrice.setText("$" + totalPrice);
		      weekendBox.addItemListener(this);
		      breakfast.addItemListener(this);
		      golf.addItemListener(this);
		      
		      
	   }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
	      int select = e.getStateChange();
	      if(source == weekendBox) {
	    	  if(select == ItemEvent.SELECTED) {
	    		  totalPrice += WEEKEND_PREMIUM;
	    	  }
	    	  else {
	    		  totalPrice -= WEEKEND_PREMIUM;
	    	  }
	    	  totPrice.setText("$" + totalPrice);
	      }
	      
	      if (source== breakfast) {
	    	  if(select == ItemEvent.SELECTED) {
	    		  totalPrice += BREAKFAST_PREMIUM;
	    	  }
	    	  else {
	    		  totalPrice-=BREAKFAST_PREMIUM;
	    	  }
	    	  totPrice.setText("$" + totalPrice);
	      }
	      if(source== golf) {
	    	  if(select == ItemEvent.SELECTED) {
	    		  totalPrice += GOLF_PREMIUM;
	    	  }
	    	  else {
	    		  totalPrice -= GOLF_PREMIUM;
	    	  }
	    	  totPrice.setText("$" + totalPrice);
	      }
	      
	      
	}
	
}
