package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
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

import business.Author;
import business.Book;
import business.CustomTableModel;
import business.SystemController;


public class AddNewBook extends JFrame implements LibWindow{
	public static final AddNewBook INSTANCE = new AddNewBook();
	CustomTableModel model;
	JPanel buttonPanel = new JPanel();
	JTable tblAuthor;
	JScrollPane scrollPane;
	JPanel pnlAddBook, pnlAuthor, pnlMsg;
	JLabel lblAddBookTitle, lblBookTitle, lblISBN, lblAuthorFName, lblAuthorLName, lblTelephone, lblAddress, lblStreet, lblCity, lblState, lblZip ;
	JTextField txtTitle, txtAuthor, txtISBN, txtAuthorFName, txtAuthorLName, txtTelephone, txtStreet, txtCity, txtState, txtZip;
	SystemController control = new SystemController();
	Author author;
	
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
	private void addAuthor() {
		pnlAuthor = new JPanel();
		pnlAuthor.setLayout(new BorderLayout());
		lblAuthorFName  =new JLabel("Author First Name");
		lblAuthorLName  =new JLabel("Author Last Name");
		lblTelephone  =new JLabel("Telephone");
		lblAddress  =new JLabel("Address");
		lblStreet  =new JLabel("Street");
		lblCity  = new JLabel("City");
		lblState = new JLabel("State");
		lblZip = new JLabel("Zip");
		
		txtAuthorFName = new JTextField(11);
		txtAuthorLName = new JTextField(11);
		txtTelephone = new JTextField(11);
		txtStreet = new JTextField(11);
		txtCity = new JTextField(11);
		txtState = new JTextField(11);
		txtZip = new JTextField(11);
		
		pnlAuthor.add(lblAuthorFName);
		
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
		btnRemoveAuthor.setBounds(280, 120, 100, 24);
		
		// Create a custom table model
        CustomTableModel model = new CustomTableModel();
        tblAuthor = new JTable(model);
        scrollPane = new JScrollPane();
        scrollPane.add(tblAuthor);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(140, 166, 100, 24);
		
		
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
		
		//Author UI components
		addAuthor();
		pnlAddBook.add(btnAddAuthor);
		pnlAddBook.add(btnRemoveAuthor);
		
		//setBounds for scrollPane
		
		scrollPane.setBounds(40, 160, 300, 100);
		
		//pnlAuthor.setBounds(40, 160, 300, 100);
		//pnlAddBook.add(pnlAuthor);
		pnlAddBook.add(scrollPane);
		
		add(pnlAddBook);
		
		isInitialized(true);
		
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
