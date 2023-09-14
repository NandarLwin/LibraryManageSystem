package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import librarysystem.Constants.Address;
import librarysystem.Constants.Person;
import librarysystem.Constants.Title;

public class AddMemberWindow extends JFrame implements LibWindow {
	
    public static final AddMemberWindow INSTANCE = new AddMemberWindow();
    private ControllerInterface ctlr = new SystemController();
    
    JPanel mainPanel, upperHalf, lowerHalf, topPanel, middlePanel,
    	lowerPanel, leftTextPanel, rightTextPanel, memberIdPanel, streetPanel,
    	cityPanel, statePanel, zipPanel, phonePanel;

    JTextField firstName, lastName, memberId, street, city, state, zip, phone;
    JLabel label;
    JButton addMemberButton, backButton;
    
	@Override
	public void init() {
		mainPanel = new JPanel();
		defineUpperHalf();
		defineLowerHalf();
		
		BorderLayout bl = new BorderLayout();
		bl.setVgap(30);
		mainPanel.setLayout(bl);
					
		mainPanel.add(upperHalf, BorderLayout.NORTH);
		mainPanel.add(lowerHalf, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
//		isInitialized(true);
		setTitle(Title.ADD_MEMBER);
		pack();
		
	}

    private void defineUpperHalf() {
		upperHalf = new JPanel();
		upperHalf.setLayout(new BorderLayout());
		
		defineTopPanel(); // Title
		defineMiddlePanel(); // Member id, first name, last name
		defineLowerPanel(); // Address
		
		upperHalf.add(topPanel, BorderLayout.NORTH);
		upperHalf.add(middlePanel, BorderLayout.CENTER);
		upperHalf.add(lowerPanel, BorderLayout.SOUTH);	
	}
    
    private void defineTopPanel() {
   		topPanel = new JPanel();
		JPanel intPanel = new JPanel(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		JLabel loginLabel = new JLabel(Title.ADD_MEMBER);
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(intPanel);
    }
    
    private void defineMiddlePanel() {
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		defineMemberId();
		defineLeftTextPanel();
		defineRightTextPanel();
		definePhonePanel();
		
		middlePanel.add(memberIdPanel);
		middlePanel.add(leftTextPanel);
		middlePanel.add(rightTextPanel);
		middlePanel.add(phonePanel);
    }
    
    private void defineMemberId() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		memberId = new JTextField(10);
		label = new JLabel(Person.MEMBER_ID);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(memberId);
		bottomText.add(label);
		
		memberIdPanel = new JPanel();
		memberIdPanel.setLayout(new BorderLayout());
		memberIdPanel.add(topText,BorderLayout.NORTH);
		memberIdPanel.add(bottomText,BorderLayout.CENTER);
    }
    
    private void defineLeftTextPanel() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		firstName = new JTextField(10);
		label = new JLabel(Person.FIRST_NAME);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(firstName);
		bottomText.add(label);
		
		leftTextPanel = new JPanel();
		leftTextPanel.setLayout(new BorderLayout());
		leftTextPanel.add(topText,BorderLayout.NORTH);
		leftTextPanel.add(bottomText,BorderLayout.CENTER);
    }
    
    private void defineRightTextPanel() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));		
		
		lastName = new JTextField(10);
		label = new JLabel(Person.LAST_NAME);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(lastName);
		bottomText.add(label);
		
		rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(topText,BorderLayout.NORTH);
		rightTextPanel.add(bottomText,BorderLayout.CENTER);
    }
    
    private void definePhonePanel() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));		
		
		phone = new JTextField(10);
		label = new JLabel(Person.PHONE);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(phone);
		bottomText.add(label);
		
		phonePanel = new JPanel();
		phonePanel.setLayout(new BorderLayout());
		phonePanel.add(topText,BorderLayout.NORTH);
		phonePanel.add(bottomText,BorderLayout.CENTER);
    }
    
    private void defineLowerPanel() {
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
    	defineStreet();
    	defineCity();
    	defineState();
    	defineZip();
		
    	lowerPanel.add(streetPanel);
    	lowerPanel.add(cityPanel);
    	lowerPanel.add(statePanel);
    	lowerPanel.add(zipPanel);
    }
    
    private void defineStreet() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));		
		
		street = new JTextField(10);
		label = new JLabel(Address.STREET);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(street);
		bottomText.add(label);
		
		streetPanel = new JPanel();
		streetPanel.setLayout(new BorderLayout());
		streetPanel.add(topText, BorderLayout.NORTH);
		streetPanel.add(bottomText, BorderLayout.CENTER);
    }
    
    private void defineCity() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));		
		
		city = new JTextField(10);
		label = new JLabel(Address.CITY);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(city);
		bottomText.add(label);
		
		cityPanel = new JPanel();
		cityPanel.setLayout(new BorderLayout());
		cityPanel.add(topText, BorderLayout.NORTH);
		cityPanel.add(bottomText, BorderLayout.CENTER);
    }
    
    private void defineState() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));		
		
		state = new JTextField(10);
		label = new JLabel(Address.STATE);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(state);
		bottomText.add(label);
		
		statePanel = new JPanel();
		statePanel.setLayout(new BorderLayout());
		statePanel.add(topText, BorderLayout.NORTH);
		statePanel.add(bottomText, BorderLayout.CENTER);
    }
    
    private void defineZip() {
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		zip = new JTextField(10);
		label = new JLabel(Address.ZIP);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(zip);
		bottomText.add(label);
		
		zipPanel = new JPanel();
		zipPanel.setLayout(new BorderLayout());
		zipPanel.add(topText,BorderLayout.NORTH);
		zipPanel.add(bottomText,BorderLayout.CENTER);
    }
    
    private void defineLowerHalf() {
		lowerHalf = new JPanel(new FlowLayout(FlowLayout.CENTER,5,0));
		
		addMemberButton = new JButton(Title.ADD_MEMBER);
		setAddMemberBtnListener(addMemberButton);
		
		backButton = new JButton(Constants.BACK_TO_MAIN);
		Util.addBackButtonListener(backButton);
		
		lowerHalf.add(addMemberButton);
		lowerHalf.add(backButton);
    }
    
    private void setAddMemberBtnListener(JButton butn) {
		butn.addActionListener(evt -> {
			if (checkMissingFields()) {
				JOptionPane.showMessageDialog(this, "All fields are mandatory. ");
				return;
			}

			LibraryMember newMember = new LibraryMember(
					memberId.getText(), 
					firstName.getText(), 
					lastName.getText(), 
					phone.getText(), 
					new business.Address(street.getText(), city.getText(), state.getText(), zip.getText()));
			
			ctlr.saveNewMember(newMember);
			System.out.println("member added...");
			JOptionPane.showMessageDialog(this, "Member : " + firstName.getText() 
				+ " " + lastName.getText() + " has been registered.");
		});
    }
    
    private boolean checkMissingFields() {
    	return memberId.getText().isEmpty()
    			|| firstName.getText().isEmpty()
    			|| lastName.getText().isEmpty()
    			|| phone.getText().isEmpty()
    			|| street.getText().isEmpty()
    			|| city.getText().isEmpty()
    			|| state.getText().isEmpty()
    			|| zip.getText().isEmpty();
    }
    
	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		
	}




















}










