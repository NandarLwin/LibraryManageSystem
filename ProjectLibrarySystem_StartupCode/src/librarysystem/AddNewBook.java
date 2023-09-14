package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import business.Address;
import business.Author;
import business.Book;
import business.CustomTableModel;
import business.SystemController;
import librarysystem.LibrarySystem.AllBookIdsListener;


public class AddNewBook extends JFrame implements LibWindow{
	public static final AddNewBook INSTANCE = new AddNewBook();
	JPanel buttonPanel = new JPanel();
	JTable tblAuthor;
	JScrollPane scrollPane;
	JPanel pnlAddBook, pnlAuthor, pnlMsg;
	JLabel lblAddBookTitle, lblBookTitle, lblISBN, lblAuthorFName, lblAuthorLName, lblTelephone, lblAddress, lblStreet, lblCity, lblState, lblZip,lblBio,lblMsg;
	JTextField txtTitle, txtAuthor, txtISBN, txtAuthorFName, txtAuthorLName, txtTelephone, txtStreet, txtCity, txtState, txtZip, txtBio;
	SystemController control = new SystemController();
	List<Author> lstAuth = new ArrayList<>();
	Address address;
	String strAuthorFName, strAuthorLName, strAddress, strTele, strBio, strStreet, strCity,strState,strZip, strISBN, strTitle;
	Author author;
	DefaultTableModel model;
	
	private boolean isInitialized = false;
	private AddNewBook() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
			}
		});
	}
	
	
	private void addBook() {
		pnlAddBook = new JPanel();
		
		pnlAddBook.setLayout(null);
		
		lblAddBookTitle= new JLabel("Add New Book");
		lblAddBookTitle.setBounds(10, 10, 200, 24);
		
		lblISBN = new JLabel("ISBN");
		lblBookTitle = new JLabel("Book Title");
		lblISBN.setBounds(40, 40, 200, 24);
		lblBookTitle.setBounds(40, 80, 200, 24);
		
		txtISBN = new JTextField(11);
		txtTitle= new JTextField(11);

		txtISBN.setBounds(150, 40, 200, 24);
		txtTitle.setBounds(150, 80, 200, 24);
		JButton btnAddAuthor = new JButton("Add");
		JButton btnRemoveAuthor = new JButton("Remove");
		btnAddAuthor.setBounds(140, 120, 100, 24);
		addNewAuthorButtonActionListener(btnAddAuthor);
		
		btnRemoveAuthor.setBounds(280, 120, 100, 24);
		
		// Create a  table model
        model = new DefaultTableModel(
				new String[][] {},
				new String[] {
						"Author First Name","Author Last Name","Telephone", "Address" , "Bio"
				}
		);

        tblAuthor = new JTable(model);
        scrollPane = new JScrollPane(tblAuthor);
		
		
		
		
		lblAddBookTitle.setForeground(Color.BLUE.darker());
		lblAddBookTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//Book Related UI Components
		pnlAddBook.add(lblAddBookTitle);
		pnlAddBook.add(lblISBN);
		//pnlAddBook.add(lblAuthor);
		pnlAddBook.add(lblBookTitle);
		pnlAddBook.add(txtISBN);
		//pnlAddBook.add(txtAuthor);		
		pnlAddBook.add(txtTitle);
		
		
		pnlAddBook.add(btnAddAuthor);
		pnlAddBook.add(btnRemoveAuthor);
		scrollPane.setBounds(40, 160, 400, 100);
		pnlAddBook.add(scrollPane);
		
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(220, 300, 100, 24);
		pnlAddBook.add(btnAddBook);
		//message panel
		pnlMsg = new JPanel(null);
		lblMsg = new JLabel("");
		lblMsg.setBounds(20,40,200,24);
		btnAddBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Book newBook = new Book(txtISBN.getText(),txtTitle.getText(),0,lstAuth);
				if(newBook != null) {
					control.addNewBook(newBook);
					lblMsg.setText("New Book is added to the library collection!");
				}
				
			}
		});
		pnlAddBook.add(pnlMsg);
		add(pnlAddBook);
		isInitialized(true);
		
	}
	
	private void addNewAuthorButtonActionListener(JButton butn) {
		butn.addActionListener(evt -> {
			JFrame newWindow= new JFrame("Enter data to insert");
			newWindow.setVisible(true);
			JPanel mainPanel = new JPanel(null);
			// add UI component to the new window
			lblAuthorFName  =new JLabel("Author First Name");
			lblAuthorFName.setBounds(20,40,200,24);
			lblAuthorLName  =new JLabel("Author Last Name");
			lblAuthorLName.setBounds(20,80,200,24);
			lblTelephone  =new JLabel("Telephone");
			lblTelephone.setBounds(20,120,200,24);
			lblAddress  =new JLabel("Address");
			lblAddress.setBounds(20,160,200,24);
			lblStreet  =new JLabel("Street");
			lblStreet.setBounds(20,200,200,24);
			lblCity  = new JLabel("City");
			lblCity.setBounds(20,240,200,24);
			lblState = new JLabel("State");
			lblState.setBounds(20,280,200,24);
			lblZip = new JLabel("Zip");
			lblZip.setBounds(20,320,200,24);
			lblBio = new JLabel("Bio");
			lblBio.setBounds(20,360,200,24);
			
			
			txtAuthorFName = new JTextField(11);
			txtAuthorFName.setBounds(150,40,200,24);
			txtAuthorLName = new JTextField(11);
			txtAuthorLName.setBounds(150,80,200,24);
			txtTelephone = new JTextField(11);
			txtTelephone.setBounds(150,120,200,24);
			txtStreet = new JTextField(11);
			txtStreet.setBounds(150,200,200,24);
			txtCity = new JTextField(11);
			txtCity.setBounds(150,240,200,24);
			txtState = new JTextField(11);
			txtState.setBounds(150,280,200,24);
			txtZip = new JTextField(11);
			txtZip.setBounds(150,320,200,24);
			txtBio = new JTextField(11);
			txtBio.setBounds(150,360,200,24);
			
			JButton submitButton = new JButton("Add");
			submitButton.setBounds(200,400,100,24);
			
			
			mainPanel.add(lblAuthorFName);
			mainPanel.add(txtAuthorFName);
			mainPanel.add(lblAuthorLName);
			mainPanel.add(txtAuthorLName);
			mainPanel.add(lblTelephone);
			mainPanel.add(txtTelephone);
			mainPanel.add(lblAddress);
			mainPanel.add(lblStreet);
			mainPanel.add(txtStreet);
			mainPanel.add(lblCity);
			mainPanel.add(txtCity);
			mainPanel.add(lblState);
			mainPanel.add(txtState);
			mainPanel.add(lblZip);
			mainPanel.add(txtZip);
			mainPanel.add(lblBio);
			mainPanel.add(txtBio);
			mainPanel.add(submitButton);
			
			
			newWindow.setLayout(new BorderLayout());
			newWindow.add(mainPanel);
			submitButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					strAuthorFName = txtAuthorFName.getText();
					strAuthorLName = txtAuthorLName.getText();
					strTele = txtTelephone.getText();
					strStreet = txtStreet.getText() ;
					strCity= txtCity.getText();
					strState = txtState.getText();
					strZip = txtZip.getText();
					strAddress = strStreet+ "," + strCity+ "," + strState+ ","+ strZip;
					strBio = txtBio.getText();
					address = new Address(strStreet,strCity,strState,strZip);
    				Author anAuthor = new Author(strAuthorFName,strAuthorLName,strTele,address,strBio);
    				lstAuth.add(anAuthor);
					model.addRow(new String[] {strAuthorFName,strAuthorLName,strTele,strAddress,strBio});
					newWindow.dispose();
				}
			});
			newWindow.setSize(500,450);
			//newWindow.pack();
			});
		}

	@SuppressWarnings("unused")
	private void addNewBookButtonActionListener(JButton butn) {
		butn.addActionListener(evt -> {
			String isbn = txtISBN.getText();
			String author = txtAuthor.getText();
			String title= txtTitle.getText();
			// Step 1: Get the comma-separated string
	        String authorNames = author;

	        // Step 2: Split the string using a comma as a delimiter
	        String[] arrAuthor = authorNames.split(",");
	        
	        //Author author = new Author();

	        // Step 3: Add each part to a List<String>
	        List<String> stringList = new ArrayList<>();
	        for (String anAuthor : arrAuthor) {
	            stringList.add(anAuthor);
	        }
	        //control.addNewBook(new Book(isbn,title,0,stringList));
		});
	}

	@Override
	public void init() {
		setSize(400,300);
		addBook();
	}

	@Override
	public boolean isInitialized() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;
		
	}
}
