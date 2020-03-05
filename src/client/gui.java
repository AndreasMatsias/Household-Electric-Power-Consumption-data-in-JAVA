package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import mainengine.IMainEngine;
import mainengine.MainEngineFactory;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.JSlider;
import java.awt.Choice;
import java.awt.Component;
import java.awt.List;

public class gui {

	private JFrame frame;
	private Object controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> history= new ArrayList<String>();
		MainEngineFactory mainEngineFactory = new MainEngineFactory();
		IMainEngine mainEngine = mainEngineFactory.createMainEngine("MainEngine");
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(100, 100, 700, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.setToolTipText("Load Data from a file.");
		btnNewButton.addActionListener(new ActionListener() {
			private File selectedFile;
			
			public void actionPerformed(ActionEvent arg0) {			
				int loadflag;		
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					String fileName =selectedFile.getAbsolutePath();
					System.out.println(fileName);
				}
				String[] options = {"month", "dayofweek", "season", "periodofday"};
		        String n = (String)JOptionPane.showInputDialog(null, "Please provide the type of the analyzing", 
		                "", JOptionPane.QUESTION_MESSAGE,null, options, options[2]);
		        //System.out.println(n);
				String fileName =selectedFile.getAbsolutePath();
				history.add(fileName);
				String delimeter="\t";
				Boolean hasHeaderLine=false;
				int numFields=9;
				ArrayList<MeasurementRecord> objCollection = null;
				loadflag=mainEngine.loadData(fileName,delimeter,hasHeaderLine,numFields,objCollection);
				String type = n;
				history.add(type);
				String[] options1 = {"avg", "sum"};
		        String n1 = (String)JOptionPane.showInputDialog(null, "Please provide the type of the analyzing", 
		                "", JOptionPane.QUESTION_MESSAGE,null, options1, options1[1]);
				String sumoravg = n1;
				history.add(sumoravg);
				String m = JOptionPane.showInputDialog(null, "Add your Description ", 
		                "", JOptionPane.INFORMATION_MESSAGE);
				String description = m;
				history.add(description);
				IResult result=mainEngine.aggregateByTimeUnit(objCollection, type, sumoravg, description);
				JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc1.setDialogTitle("Choose a directory to save your file: ");
				jfc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int returnValue1 = jfc1.showSaveDialog(null);
				if (returnValue1 == JFileChooser.APPROVE_OPTION) {
					if (jfc1.getSelectedFile().isDirectory()) {
						System.out.println("You selected the directory: " + jfc1.getSelectedFile());
					}
				}
				String[] options2= {"md", "html", "txt"};
		        String typeoffile = (String)JOptionPane.showInputDialog(null, "Please provide the type of the analyzing", 
		                "", JOptionPane.QUESTION_MESSAGE,null, options2, options2[2]);
				
		        String n2 = JOptionPane.showInputDialog(null, "Choose name for the output file ", 
		                "", JOptionPane.INFORMATION_MESSAGE);
		        String name= "/"+n2;
		        
		        if(typeoffile.equals("md")){
		        	String path =jfc1.getSelectedFile()+ name + ".md";
		        	System.out.println(path);
		        	history.add(path);
		        	int Outcome = mainEngine.reportResultInFile(result, typeoffile, path);
		        }
		        if(typeoffile.equals("txt")){
		        	String path =jfc1.getSelectedFile()+ name + ".txt";
		        	System.out.println(path);
		        	history.add(path);
		        	int Outcome = mainEngine.reportResultInFile(result, typeoffile, path);
		        }
		        if(typeoffile.equals("html")){
		        	String path =jfc1.getSelectedFile()+ name + ".html";
		        	System.out.println(path);
		        	history.add(path);
		        	
		        	int Outcome = mainEngine.reportResultInFile(result, typeoffile, path);
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(244, 0, 197, 88);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show History");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayGuiHelp gui = new DisplayGuiHelp(history);	

			}
		});
		btnNewButton_1.setBounds(244, 183, 197, 88);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
