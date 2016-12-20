package libraryinformationsystem;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class addPatron extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private JButton addUser, close;
	private patronInfo infoPanel;
	private boolean bool_isActionAdd;

	addPatron() {
		
		this.setTitle("Add Users");

		addUser = new JButton("Add");
		addUser.setBounds(75, 500, 100, 30);
		close = new JButton("Cancel");
		close.setBounds(325, 500, 100, 30);
		infoPanel = new patronInfo();
		infoPanel.setBounds(20, 20, 400, 400);
	
		this.add(addUser);
		this.add(close);
		this.add(infoPanel);

		this.setSize(500, 600);
		this.setLayout(null);

		addUser.addActionListener(new ActionListener() // add new user
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				Validator validator = new Validator();
				if (validator.isUserIdValid(infoPanel.getIdText())
						&& validator.isUserNameValid(infoPanel.getNameText())
						&& validator.isUserPasswordValid(infoPanel.getPasswordText())
						&& validator.isUserPhoneNoValid(infoPanel.getPhoneNoText())

				) {
					bool_isActionAdd = true;
					JOptionPane.showMessageDialog(addPatron.this,
							"New user added.", "OK", JOptionPane.PLAIN_MESSAGE);
					addPatron.this.dispose();

				}

				else {
					JOptionPane.showMessageDialog(addPatron.this,
							"Invaild user information!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		close.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				bool_isActionAdd = false;
				addPatron.this.dispose();
			}
		});
	}

	public boolean isActionAdd() {

		return bool_isActionAdd;

	}

	public Patron getUser() { //return a user with info in the panel.
		Patron tempUser = new Patron();
		infoPanel.WriteTo(tempUser);
		return tempUser;
	}


	public static void test(String[] args) {
		new addPatron();
	}

}
