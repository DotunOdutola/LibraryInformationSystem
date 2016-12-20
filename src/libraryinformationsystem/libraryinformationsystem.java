package libraryinformationsystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*; //javax.swing.JFrame;

import java.io.*;


import java.util.Date;
public class libraryinformationsystem extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Library L;
	
	JLabel label1 = new JLabel("Welcome to Our Library System!");
	JLabel label2 = new JLabel("Login as?:  ");
        JLabel label3 = new JLabel("Don't have an account?");
	JButton btnPatron = new JButton("Patron");
	JButton btnLibrarian = new JButton("Librarian");
        JButton btnSignUp = new JButton("Sign Up");
	JButton btnExit = new JButton("Exit");
	JButton btnAbout = new JButton("About");
	
	public libraryinformationsystem(){
		
		 L = createDemoLibrary();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setSize(600, 600);
		this.setLocation(350, 50);
		this.setVisible(true);
		this.setTitle("Library");//Optional		
		this.setLayout(null);

		
		label1.setBounds(150, -10, 400, 100);
		label1.setForeground(Color.blue);
		label1.setFont(new Font("", Font.BOLD,20));
		this.add(label1);
		
		label2.setBounds(70, 85, 400, 100);
		this.add(label2);
                
                label3.setBounds(190, 150, 400, 100);
                label3.setForeground(Color.blue);
                label3.setFont(new Font("", Font.BOLD,15));
		this.add(label3);
                
                
                btnSignUp.setVisible(true);
                btnSignUp.setBounds(200, 215, 200, 50);
                this.add(btnSignUp);
                
		btnPatron.setVisible(true);
		btnPatron.setBounds(150, 120, 120, 30);
		this.add(btnPatron);

		btnLibrarian.setVisible(true);
		btnLibrarian.setBounds(290, 120, 120, 30);
		this.add(btnLibrarian);

		btnExit.setVisible(true);
		btnExit.setBounds(450, 520, 120, 30);
		this.add(btnExit);
		
		btnAbout.setVisible(true);
		btnAbout.setBounds(20, 520, 120, 30);
		this.add(btnAbout);
		
                btnLibrarian.addActionListener(new java.awt.event.ActionListener() {
	    
                public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	adminLogin AdministratorLog = new adminLogin(L);
	    	}
		});
		
		btnExit.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       System.exit(0);
		    }
		});	
		
                
		btnPatron.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		       patronLogin patronLogin = new patronLogin(L);
		    }
		});
                

		btnAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt){
				About about = new About();
			}
		});

        }        
	private Library createDemoLibrary() {
		Library library=new Library();
                /*
		Book book1 = new Book();
		book1.setBookName("GVF");
		book1.setAddedDate(new Date());
		book1.setAuthor("XMQ");
		book1.setCategory(Category.CHILDREN);
		book1.setIsbn("2B64B");
		book1.setLastRented(new Date());
		book1.setOwnerId(Library.LIBRARY_OWNER_ID);
		book1.setRented(false);		
		library.addBook(book1);
		
		Book book2 = new Book();
		book2.setBookName("WWII");
		book2.setAddedDate(new Date());
		book2.setAuthor("SomeTwo");
		book2.setCategory(Category.HISTORY);
		book2.setIsbn("SBSBDSB");
		book2.setLastRented(new Date());
		book2.setOwnerId(Library.LIBRARY_OWNER_ID);
		book2.setRented(false);
		library.addBook(book2);
		*/
                
		//------------ users ----------------------
		Patron u1 = new Patron(); //admin
		Patron u2 = new Patron(); //user1
		Patron u3 = new Patron(); //user2

		u1.setUserId(1);
		u1.setPassword("1");
		u1.setUserName("admin");
		u1.setAdmin(true);
		
		u2.setUserId(2);
		u2.setPassword("123");
		u2.setUserName("user");
		u2.setAdmin(false);
		
		u3.setUserId(3);
		u3.setPassword("123");
		u3.setUserName("user2");
		u3.setAdmin(false);
		/*
		//----------- books --------------------
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();
		b1.setIsbn("0778801314");
		b1.setBookName("Ball Complete Book of Home Preserving");
		b1.setAuthor("Judi Kingry");
		b1.setCategory(Category.COOKING);
		b2.setIsbn("0736430512");
		b2.setBookName("Frozen Little Golden Book");
		b2.setAuthor("RH Disney");
		b2.setCategory(Category.CHILDREN);
		b3.setIsbn("1476751447");
		b3.setBookName("Hard Choices");
		b3.setAuthor("Hillary Rodham Clinton");
		b3.setCategory(Category.HISTORY);
		*/
		
		//-------------------------------
		library.addPatron(u1);
		library.addPatron(u2);
		library.addPatron(u3);
		/*
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		library.rentBook(u2.getUserId(), b1.getIsbn());
		*/
		return library;
	}
	
        
	public static void main(String[] a){
		new libraryinformationsystem();
	
        }
}





