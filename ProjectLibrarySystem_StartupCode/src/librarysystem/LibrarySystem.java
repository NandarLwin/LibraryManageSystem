package librarysystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import business.ControllerInterface;
import business.SystemController;
import librarysystem.Constants.Title;


public class LibrarySystem extends JFrame implements LibWindow {
	ControllerInterface ci = new SystemController();
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JMenuBar menuBar;
    JMenu options, menuBook;
    JMenuItem login, allBookIds, allMemberIds, addNewMember,  addNewBook, checkOutBook; 


    String pathToImage;
    private boolean isInitialized = false;
    
    private static LibWindow[] allWindows = { 
    	LibrarySystem.INSTANCE,
		LoginWindow.INSTANCE,
		AllMemberIdsWindow.INSTANCE,	
		AllBookIdsWindow.INSTANCE,

		AddNewBook.INSTANCE
		//AddMemberWindow.INSTANCE
	};
    	
	public static void hideAllWindows() {		
		for(LibWindow frame: allWindows) {
			frame.setVisible(false);			
		}
	}
     
    private LibrarySystem() {
    	
    }
    
    public void init() {
    	formatContentPane();
    	setPathToImage();
    	insertSplashImage();
		
		createMenus();
		//pack();
		setSize(660,500);
		isInitialized = true;
    }
    
    private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1,2));
		getContentPane().add(mainPanel);	
	}
    
    private void setPathToImage() {
    	String currDirectory = System.getProperty("user.dir");
    	//for Windows file system
//    	pathToImage = currDirectory+"\\src\\librarysystem\\library.jpg";
    	//for unix file system
    	pathToImage = currDirectory+"/src/librarysystem/library.jpg";
    	
    }
    
    private void insertSplashImage() {
        ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));	
    }
    private void createMenus() {
    	menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addMenuItems();
		setJMenuBar(menuBar);		
    }
    
    private void addMenuItems() {
       options = new JMenu("Options");  
       //add book main menu
 	   
       menuBook = new JMenu("Book");
       
 	   menuBar.add(options);
 	   
 	   login = new JMenuItem("Login");
 	   login.addActionListener(new LoginListener());
 	   


 	   allBookIds = new JMenuItem("View Books");
 	   allBookIds.addActionListener(new AllBookIdsListener());
 	   
 	   addNewBook= new JMenuItem("Add New Books");
 	   addNewBook.addActionListener(new AddNewBookListener());
 	   checkOutBook= new JMenuItem("Checkout Books");
 	   
 	   
 	  /* allBookIds = new JMenuItem("All Book Ids");
=======
 	   allBookIds = new JMenuItem("All Book Ids");
>>>>>>> 12eed543c8c7c59058d7c0a8a0c5332c327a40fc
 	   allBookIds.addActionListener(new AllBookIdsListener());
 	   
 	   allMemberIds = new JMenuItem("All Member Ids");
 	   allMemberIds.addActionListener(new AllMemberIdsListener());
 	   
 	   addMember = new JMenuItem(Title.ADD_MEMBER);
 	   addMember.addActionListener(new AddMemberListener());
 	   
 	   options.add(login);
 	   options.add(allBookIds);
<<<<<<< HEAD
 	   options.add(allMemberIds);*/
 	  menuBook.setEnabled(false);
 	  options.add(login);
 	  options.add(menuBook);
 	  menuBook.add(allBookIds);
 	  menuBook.add(addNewBook);
 	  menuBook.add(checkOutBook); 
    }
    class AddNewBookListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		LibrarySystem.hideAllWindows();
			AddNewBook.INSTANCE.init();
			Util.centerFrameOnDesktop(AddNewBook.INSTANCE);
			AddNewBook.INSTANCE.setVisible(true);
			
    	}
    }
    
    class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(!LoginWindow.INSTANCE.IsloggedIn) {
				LibrarySystem.hideAllWindows();
				LoginWindow.INSTANCE.init();
				Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
				LoginWindow.INSTANCE.setVisible(true);
			}
		
			
		}	
    }
    
    class AllBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();
			
			List<String> ids = ci.allBookIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllBookIdsWindow.INSTANCE.setData(sb.toString());
			AllBookIdsWindow.INSTANCE.pack();
			//AllBookIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllBookIdsWindow.INSTANCE);
			AllBookIdsWindow.INSTANCE.setVisible(true);		
		}	
    }
    
    class AllMemberIdsListener implements ActionListener {

    	@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AllMemberIdsWindow.INSTANCE.init();
			AllMemberIdsWindow.INSTANCE.pack();
			AllMemberIdsWindow.INSTANCE.setVisible(true);
			
			
			LibrarySystem.hideAllWindows();
			AllBookIdsWindow.INSTANCE.init();
			
			List<String> ids = ci.allMemberIds();
			Collections.sort(ids);
			StringBuilder sb = new StringBuilder();
			for(String s: ids) {
				sb.append(s + "\n");
			}
			System.out.println(sb.toString());
			AllMemberIdsWindow.INSTANCE.setData(sb.toString());
			AllMemberIdsWindow.INSTANCE.pack();
			//AllMemberIdsWindow.INSTANCE.setSize(660,500);
			Util.centerFrameOnDesktop(AllMemberIdsWindow.INSTANCE);
			AllMemberIdsWindow.INSTANCE.setVisible(true);			
		}  	
    }
    
    class AddMemberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AddMemberWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
			AddMemberWindow.INSTANCE.setVisible(true);
			
		}	
    }

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}


	@Override
	public void isInitialized(boolean val) {
		isInitialized =val;
		
	}
    
}
