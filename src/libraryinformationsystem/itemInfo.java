package libraryinformationsystem;


import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import javax.swing.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import javax.swing.border.*;


/**
 * Panel to show Book Info
 * @author Adedotun Odutola
 *
 */
public class itemInfo extends JPanel {

	private final String[] cmbStatusStrs = {"Available","Rented Out"}; 
	private final String[] cmbCategoryStrs = {"Children", "Cooking", "History","Travel"};
	
	private JLabel lblBookImg;
	private JLabel lblStatus;
	private JTextField txtStatus;
	private JLabel lblIsbn;
	private JTextField txtIsbn;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblAuthor;
	private JTextField txtAuthor;
	private JLabel lblCategory;
	private JComboBox cmbCategory;
	
	private Library library;
	
	/**
	 * Create the panel.
	 */
	public itemInfo() {
		setBorder(new TitledBorder(null, "BookInfo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		lblBookImg = new JLabel("No Image");
		lblBookImg.setBorder(new LineBorder(Color.black));
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblIsbn = new JLabel("ISBN");
		panel_1.add(lblIsbn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblName = new JLabel("Name");
		panel_2.add(lblName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblAuthor = new JLabel("Author");
		panel_3.add(lblAuthor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblCategory = new JLabel("Category");
		panel_4.add(lblCategory);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(lblBookImg, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(lblBookImg, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		cmbCategory = new JComboBox(cmbCategoryStrs);
		panel_4.add(cmbCategory);
		
		txtAuthor = new JTextField();
		panel_3.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtName = new JTextField();
		panel_2.add(txtName);
		txtName.setColumns(10);
		
		txtIsbn = new JTextField();
		panel_1.add(txtIsbn);
		txtIsbn.setColumns(10);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblStatus = new JLabel("Status");
		panel.add(lblStatus);
		setLayout(groupLayout);
		
		txtStatus = new JTextField();
		txtStatus.setForeground(Color.RED);
		txtStatus.setEditable(false);
		panel.add(txtStatus);
		txtStatus.setColumns(10);
	}
	
	
	public itemInfo(Library library) {
		this();
		this.library=library;
	}
	
	/**
	 * Set whether this panel information is editable or read only
	 */
	public void setEditable(boolean editable) {
		//cmbStatus.setEditable(editable); //default cannot editable
		txtIsbn.setEditable(editable);
		txtName.setEditable(editable);
		txtAuthor.setEditable(editable);
		cmbCategory.setEnabled(editable);
	}
	
	/**
	 * Clear the entries of the book info
	 */
	public void clear() {
		this.lblBookImg.setIcon(null);
		this.txtStatus.setText("");
		this.txtIsbn.setText("");
		this.txtName.setText("");
		this.txtAuthor.setText("");
		this.cmbCategory.setSelectedIndex(0);
	}
	
	/**
	 * Load information from book, fill the attribute boxes.
	 * @param book
	 */
	public void ReadFrom(Item item) {
		if (item==null)
			return;
		
		//update book img
		String bookImgPath = null;
		if (this.library!=null) {
			bookImgPath = this.library.getBookImgFileFullName(item.getIsbn());
		} else {
			bookImgPath = "D:/images.jpg";
		}
		
		ImageIcon bookImgIcon = CreateStretchImageIcon(bookImgPath,lblBookImg.getWidth(),lblBookImg.getHeight());
		this.lblBookImg.setIcon(bookImgIcon);
		
		this.txtStatus.setText(getTxtStatusString(item.isRented()));
		this.txtIsbn.setText(item.getIsbn());
		this.txtName.setText(item.getBookName());
		this.txtAuthor.setText(item.getAuthor());
		this.cmbCategory.setSelectedIndex(getCmbCategoryIndex(item.getCategory()));
	}
	
	/**
	 * Write back the attributes from this panel to the book object
	 * @param book
	 */
	public void WriteTo(Item item) {
		if (item==null)
			return;
		
		item.setIsbn(txtIsbn.getText());
		item.setBookName(txtName.getText());
		item.setAuthor(txtAuthor.getText());
		item.setCategory(getCategoryFromCmbIndex(cmbCategory.getSelectedIndex()));
	}
	
	
	
	private String getTxtStatusString(boolean isRented) {
		if (isRented)
			return cmbStatusStrs[1]; //available
		else
			return cmbStatusStrs[0]; //rent out
	}
	
	private ImageIcon CreateStretchImageIcon(String imgPath,
			int width, int height) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(imgPath));
		} catch (IOException e) {
		    //e.printStackTrace();
		    return null;
		}
		
		Image scaledImg = img.getScaledInstance(width, height,
		        java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(scaledImg);
		return imageIcon;
	}
	

	private int getCmbCategoryIndex(Category cat) {
		if (cat==null)
			return 0;
		
		switch (cat)
		{
		case CHILDREN:
			return 0;
			//break;
		case COOKING:
			return 1;
			//break;
		case HISTORY:
			return 2;
			//break;
		case TRAVEL:
			return 3;
			//break;
		}
		
		return 0;
	}
	
	private Category getCategoryFromCmbIndex(int cmbCategoryIndex) {
		switch (cmbCategoryIndex)
		{
		case 0:
			return Category.CHILDREN;
			//break;
		case 1:
			return Category.COOKING;
			//break;
		case 2:
			return Category.HISTORY;
			//break;
		case 3:
			return Category.TRAVEL;
			//break;
		}
		
		return Category.CHILDREN;
	}


}
