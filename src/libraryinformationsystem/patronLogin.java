package libraryinformationsystem;

import javax.swing.*;

import java.awt.event.*;

/**
 * Frame for the patron to login
 * @author Adedotun Odutola
 * add dec 6, 2016
 */

public class patronLogin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Library library;
	private Patron currentUser;
	
	private JLabel lblUserName, lblPassWord;
	private JTextField txtUserName;
	private JPasswordField pwdPassWord;
	private JButton btnLogin, btnClose;
	private String pwd, user;
	
	private patronLogin(){
		this(null);
	}
	
	patronLogin(Library l){
		this.library=l;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patron Login");
		this.setLayout(null);
		this.setLocation(250, 40);
		
		lblUserName = new JLabel();
		lblUserName.setText("Username:");
		lblUserName.setBounds(170, 40, 70, 30);
		
		lblPassWord = new JLabel();
		lblPassWord.setText("Password:");
		lblPassWord.setBounds(170, 100, 70, 30);
		
		txtUserName = new JTextField(20);
		txtUserName.setBounds(240, 40, 200, 30);
		
		pwdPassWord = new JPasswordField(20);
		pwdPassWord.setBounds(240, 100, 200, 30);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(230, 160, 75, 30);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(340, 160, 75, 30);
		
		this.add(lblUserName);
		this.add(txtUserName);
		this.add(lblPassWord);
		this.add(pwdPassWord);
		this.add(btnLogin);
		this.add(btnClose);
		this.setResizable(false);
		this.setSize(600, 280);
		this.setVisible(true);
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				pwd = new String(pwdPassWord.getPassword());
				user = txtUserName.getText();
				if(user.length() == 0){
					JOptionPane.showMessageDialog(patronLogin.this, "Please enter your username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
				} else{
					if(pwd.length() == 0){
						JOptionPane.showMessageDialog(patronLogin.this, "Please enter your password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
					} else{
						currentUser = library.login(user, pwd);
						if(currentUser != null){
							if(!currentUser.isAdmin()){
								JOptionPane.showMessageDialog(patronLogin.this, "Welcome, " + currentUser.getUserName() + "!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
								patronLogin.this.dispose();
								new patronInterface(library, currentUser);
							} else{
								JOptionPane.showMessageDialog(patronLogin.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
								pwdPassWord.setText("");
							}
						} else{
							JOptionPane.showMessageDialog(patronLogin.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
							pwdPassWord.setText("");
						}
					}
				}
			}
		});   
		
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				patronLogin.this.dispose();
			}
		});
	}
	
	public static void test(String[] args){
		Library l = new Library();
		Patron u1 = new Patron();
		Patron u2 = new Patron();
		//Book b1 = new Book();
		//Book b2 = new Book();
		//Book b3 = new Book();
		//b1.setIsbn("0778801314");
		//b1.setBookName("Ball Complete Book of Home Preserving");
		//b1.setAuthor("Judi Kingry");
		//b1.setCategory(Category.COOKING);
		//b2.setIsbn("0736430512");
		//b2.setBookName("Frozen Little Golden Book");
		//b2.setAuthor("RH Disney");
		//b2.setCategory(Category.CHILDREN);
		//b3.setIsbn("1476751447");
		//b3.setBookName("Hard Choices");
		//b3.setAuthor("Hillary Rodham Clinton");
		//b3.setCategory(Category.HISTORY);
		u1.setUserId(1);
		u1.setPassword("123");
		u1.setUserName("patron");
		u1.setAdmin(false);
		
		u2.setUserId(2);
		u2.setPassword("123");
		u2.setUserName("admin");
		u2.setAdmin(true);
		
		l.addPatron(u1);
		l.addPatron(u2);
		//l.addBook(b1);
		//l.addBook(b2);
		//l.addBook(b3);
		//l.rentBook(u1.getUserId(), b1.getIsbn());
		
		new patronLogin(l);
	}
}
