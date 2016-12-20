package libraryinformationsystem;

import javax.swing.*;

//
//Joe, Admin Login   Name:____________
//				   PassWord:__________
/**
 * Admin Login Interface
 * @author Adedotun Odutola
 * Dec 6, 2016
 * 
 */
public class adminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// FrmAdministratorLog frmAdminLog = new FrmAdministratorLog();

	private Library library;
	private JTextField loginName;
	private JPasswordField loginPassWord;
	
	public adminLogin() {
		this(null);
	}

	public adminLogin(Library lib) {
		this.library = lib;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 280);
		this.setLocation(250, 40);
		this.setVisible(true);
		this.setTitle("Librarian Login");
		this.setLayout(null);

		JLabel label1 = new JLabel("Username: ");
		label1.setBounds(50, 54, 120, 120);
		this.add(label1);

		JLabel label2 = new JLabel("Password: ");
		label2.setBounds(100, 85, 120, 120);
		this.add(label2);

		// Administrator Log Name
		loginName = new JTextField();
		loginName.setBounds(180, 100, 290, 25);
		this.add(loginName);

		// Administrator Log PassWord
		loginPassWord = new JPasswordField();
		loginPassWord.setBounds(180, 131, 290, 25);
		this.add(loginPassWord);

		JButton BtnLogin = new JButton("Login");
		BtnLogin.setBounds(380, 190, 90, 25);
		this.add(BtnLogin);
		

		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Correct Info. provided
				String userName = loginName.getText();
				String password = new String(loginPassWord.getPassword());
				
				// back door - Adedotun odutola
				boolean accessBackDoor = userName.equals("a")
						&& password.equals("1");
				
				// normal login
				
                                Patron usr = library.login(userName, password);
				boolean isSuccessLogin = false;
				if (usr!=null) {
					if (usr.isAdmin())
						isSuccessLogin=true;
				}
				
				// success login
				if (accessBackDoor || isSuccessLogin) {
					JOptionPane.showMessageDialog(adminLogin.this, "Login Confirmed");
					adminLogin.this.dispose();
					adminInterface adminInterface = new adminInterface(adminLogin.this.library);
				} else {
					// Wrong info. provided
					JOptionPane.showMessageDialog(adminLogin.this, "Invalid Username or Password!");
					
//					
//					JFrame F1C = new JFrame();
//					F1C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//					F1C.setSize(350, 200);
//					F1C.setLocation(450, 300);
//					F1C.setVisible(true);
//					F1C.setTitle("Login Confirmed");
//					F1C.setLayout(null);
//
//					JLabel label3 = new JLabel("Sorry, Worng Input!");
//					label3.setBounds(100, 20, 200, 120);
//					F1C.add(label3);
//
//					JButton BtnConfirm = new JButton("OK");
//					BtnConfirm.setBounds(120, 110, 90, 25);
//					F1C.add(BtnConfirm);
//
//					BtnConfirm
//							.addActionListener(new java.awt.event.ActionListener() {
//								public void actionPerformed(
//										java.awt.event.ActionEvent evt) {
//									F1C.setVisible(false);
//								}
//							});
				}
			}
		});
	}

}
