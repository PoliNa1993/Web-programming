//------------------------------------------
// Assignment 3
// Written by: Polina Anis'kina 26991092
// For COMP249 Section: S
//------------------------------------------
// GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class OrderCreatorGUI {
	public static void main(String[] args){
		GUI gui = new GUI();
	}
}

class GUI extends JFrame{
	private JFrame frame;
	private JButton submitBtn, ResetBtn;
	private JPanel textPanel, btnPanel, statusPanel;
	private JTextField priceBox, volumeBox, nameBox;
	private JTextPane orderStatus;

	private  String name;
	private double price;
	private int volume;

	//setters and getters
	public String getaName() {
		return name; }

	public void setaName(String aName) {
		this.name = aName; }

	public double getaPrice() {
		return price; }

	public void setaPrice(double price) {
		this.price = price; }

	public int getaVolume() {
		return volume; }

	public void setaVolume(int aVolume) {
		this.volume = aVolume; }

	//Frame 
	GUI(){
		frame = new JFrame("Order Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		textPanel = new JPanel();
		textPanel.setBackground(Color.PINK);


		priceBox = new JTextField("Enter price here");
		volumeBox = new JTextField("Enter volume here");
		nameBox = new JTextField("Enter name here");
		
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

		textPanel.add(priceBox);
		textPanel.add(volumeBox);
		textPanel.add(nameBox);

		textPanel.setPreferredSize(new Dimension(100, 90));

		frame.getContentPane().add(textPanel, BorderLayout.NORTH);

		btnPanel = new JPanel();
		frame.getContentPane().add(btnPanel, BorderLayout.CENTER);
		btnPanel.setBackground(Color.PINK);

		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new submit());
		btnPanel.add(submitBtn);

		ResetBtn = new JButton("Reset");
		ResetBtn.addActionListener(new Reset());
		btnPanel.add(ResetBtn);

		statusPanel = new JPanel();
		statusPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(statusPanel, BorderLayout.SOUTH);

		orderStatus = new JTextPane();
		orderStatus.setText("Last Order: none");
		statusPanel.add(orderStatus);


		frame.setSize(400, 200);
		frame.setVisible(true);
	}

	private class submit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				String tempP, tempV;
				tempP = priceBox.getText();
				setaPrice(Double.parseDouble(tempP));

				tempV = volumeBox.getText();
				setaVolume(Integer.parseInt(tempV));
			} catch (NumberFormatException err){
				orderStatus.setText(status());
			}

			setaName(nameBox.getText());

			orderStatus.setText(status());
		}
	}
//listener
	private class Reset implements ActionListener{
		public void actionPerformed(ActionEvent e){
			priceBox.setText("Enter price here.");
			volumeBox.setText("Enter volume here.");
			nameBox.setText("Enter name here.");
			orderStatus.setText(status());
		}
	}


	public String status(){
		if(getaPrice()>0 && getaVolume()>0)
			return ("Last Order: " + getaVolume() + " shares at $" + getaPrice());
		else
			return ("Error!");
	}

}

