package dataload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import dataload.ILoader;
import datamodel.MeasurementRecord;
import datamodel.MeasurementRecordFactory;

public  class  Loader<E>  implements ILoader<E>
{
	public int constructObjectFromRow(String[] tokens, ArrayList<E> objCollection) {
		String date = null;
		String time = null;
		String m1= null;
		String m2= null;
		String m3= null;
		String m4= null;
		String m5= null;
		String m6= null;
		String m7= null;
		MeasurementRecordFactory measurementRecordFactory = new MeasurementRecordFactory();


		date = tokens[0];
		time = tokens[1];
		m1 = tokens[2];
		m2 = tokens[3];
		m3 = tokens[4];
		m4 = tokens[5];
		m5 = tokens[6];
		m6 = tokens[7];
		m7 = tokens[8];
		//Float result = Float.valueOf(m2);
		//Float result1 = Float.valueOf(m3);
		//float sum =result1+result;
		MeasurementRecord mr = measurementRecordFactory.createMeasurementRecord(date,time,m1,m2,m3,m4,m5,m6,m7);		
		objCollection.add((E) mr);
		//System.out.println("DATE=["+ objCollection.get(0)+"]");	
		//for(int i=0;i<9;i++)
		//{
			//System.out.println("["+tokens[i]+"]");		
		//}
		//System.out.println("\n");
		//System.out.println("["+sum+"]");
		//System.out.println("\n");
		return 0;
	}
	@Override
	public
	int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList<E> objCollection) {
		if (numFields < 1)
		{
			System.out.println("Wrong number of fields, less than 1!");
			System.exit(0);		
		}
		//Opening files for read and write, checking exception
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + fileName);
			System.exit(0);
		}

		int count = 0;

		//process the title of the tsv
		if(hasHeaderLine){
			String titleLine = inputStream.nextLine();
			count++;
		}
		String line = "";
		//process the actual rows one by one
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			count++;

			StringTokenizer tokenizer = new StringTokenizer(line, delimeter);
			if(tokenizer.countTokens() != numFields){
				System.out.println("Wrong Input format in file " + fileName +". I found " + tokenizer.countTokens() + " values, but I expect " + numFields + " values per row!");
				//				System.exit(0);				
			}

			String[] tokens =  new String[numFields];
			for (int i=0; i< numFields;i++){
				tokens[i] = tokenizer.nextToken();
			}

			//ToDo: here add the method that takes the token and forms the object and puts it in the resultList			
			int objConstructionErrorCode;
			objConstructionErrorCode = constructObjectFromRow(tokens, objCollection);
			
			if (objConstructionErrorCode !=0)
			{
				System.out.println("ObjParsingError. I found a problem at line " + count + " of file " + fileName);
				System.exit(0);
			}
			
			
		}		
		inputStream.close();
		System.out.println("Processed " + count + " rows and loaded " + objCollection.size() + " objects.");
		return count;
	}

	

	

}
