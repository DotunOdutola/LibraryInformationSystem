package libraryinformationsystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Frame to guide customer
 * @author Adedotun Odutola
 * add Dec 6, 2016
 */

public class patronInterface extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Library library;
	private Patron user;
	
	private JButton btnBorrow, btnReturn, btnClose, btnViewReport;
	
	patronInterface(){
		this(null, null);
	}
	patronInterface(Library l, Patron u){
		this.library = l;
		this.user = u;
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Patron Interface");
		this.setLocation(350, 50);
		
		btnBorrow = new JButton("Reserve Item");
		btnBorrow.setBounds(20, 20, 130, 30);
		
		//btnReturn = new JButton("Return Book");
		//btnReturn.setBounds(230, 20, 130, 30);
		
		btnClose = new JButton("Logout");
		btnClose.setBounds(125, 80, 130, 30);
		
                btnViewReport = new JButton("View Report");
                btnViewReport.setBounds(230, 20, 130, 30);
                
		this.setLayout(null);
		this.add(btnBorrow);
		//this.add(btnReturn);
		this.add(btnClose);
                this.add(btnViewReport);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setVisible(true);
		
                /*
		btnReturn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				new FrmCustomerReturnBook(library, user);
			}
		});
		*/
		btnClose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				patronInterface.this.dispose();
				new patronLogin(library);
			}
		});
		
		
                btnBorrow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
				reserveItem borrow = new reserveItem(library, user);
				borrow.setVisible(true);
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				patronInterface.this.dispose();
				new patronLogin(library);
			}
		});
	}
}
