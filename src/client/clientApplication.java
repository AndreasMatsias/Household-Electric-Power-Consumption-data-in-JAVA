package client;
//C:\Users\matsi\Desktop\Eclipse_Workspace\2019-2020_3025_4437_4399\Resources\TestInput\2007_sample.tsv
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import datamodel.IResult;
import datamodel.MeasurementRecord;
import mainengine.IMainEngine;
import mainengine.MainEngineFactory;

public class clientApplication
{
private Scanner reader;
	
	public clientApplication(){
		reader = new Scanner(System.in);
	}
	
	public int printMenu(){
		int answerOperation = 0;
		while( answerOperation > 5 || answerOperation <= 0){
			System.out.println("Choose(1 OR 2)\n 1. Provide file\n 2.History\n 3.Exit\n");
			answerOperation = reader.nextInt();
			if(answerOperation <1 || answerOperation > 3)
				System.out.println("Wrong answer! Try again...");
		}
		
		return answerOperation;
	}
	
	public Scanner getReader(){
		return reader;
	}
	
	
	public static void main(String args[])
	{
		clientApplication app = new clientApplication();	
		ArrayList<String> history= new ArrayList<String>();
		HashMap<Integer,  ArrayList<String>> H = new HashMap<Integer, ArrayList<String>>();
		int loadflag;
		//IResult typeflag;
		//history.removeAll(history);

		MainEngineFactory mainEngineFactory = new MainEngineFactory();
		IMainEngine mainEngine = mainEngineFactory.createMainEngine("MainEngine");
		while(true){
			int operation = app.printMenu();
			if(operation == 1)
			{
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Please provide the path of the file:");
				String fileName = keyboard.next();
				history.add(fileName);
				String delimeter="\t";
				Boolean hasHeaderLine=false;
				int numFields=9;
				ArrayList<MeasurementRecord> objCollection = null;
				loadflag=mainEngine.loadData(fileName,delimeter,hasHeaderLine,numFields,objCollection);
				//System.out.println("Loaded  {" + loadflag + "}  rows\n");	
				/////////////////////////////////////////////////////////////////////////////////////////
				Scanner keyboard1 = new Scanner(System.in);
				System.out.println("Please provide the type of the analyzing:");
				String type = keyboard1.next();
				history.add(type);
				Scanner keyboard2 = new Scanner(System.in);
				/////////////////////////////////////////////////////////////////////////////////////////////
				System.out.println("Do you want Sum or Avg to compute?");
				System.out.println("Choose between sum OR avg:");
				String sumoravg = keyboard2.next();
				history.add(sumoravg);
				Scanner keyboard3 = new Scanner(System.in);
				///////////////////////////////////////////////////////////////////////////////////////////////
				System.out.println("Add your description:\n");
				String description = keyboard3.nextLine();
				history.add(description);
				///////////////////////////////////////////////////////////////////////////////////////////
				IResult result=mainEngine.aggregateByTimeUnit(objCollection, type, sumoravg, description);
				System.out.println("Type of the output file:\n");
				Scanner keyboard4 = new Scanner(System.in);
				String typeoffile = keyboard4.next();
				history.add(typeoffile);
				System.out.println("Output file path:\n");
				String outputFilename = keyboard4.next();
				history.add(outputFilename);
				int Outcome = mainEngine.reportResultInFile(result, typeoffile, outputFilename);
				//keyboard.close();
				//keyboard1.close();
				//keyboard2.close();
				//keyboard3.close();
			}
			else if(operation == 2)
			{
				
				
				for (int j=0; j< history.size(); j++) 
				{
				    	
					System.out.println("["+ history.get(j)+"]"); 
				}  
				 
				
			}
			else if(operation == 3)
			{
				break;
			}
		}
			
		
	}
}
