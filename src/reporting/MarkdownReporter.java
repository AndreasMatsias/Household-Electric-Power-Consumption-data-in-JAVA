package reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


import datamodel.IResult;


public class MarkdownReporter implements IResultReporter {

	@Override
	public int reportResultInFile(IResult result, String filename) {
		String description=result.getDescription();
		String aggF=result.getAggregateFunction();
		File f=new File(filename);
		try {
			PrintWriter b = new PrintWriter(new FileOutputStream(filename));
			b.println("##"+description);
			b.println(aggF+" consumption (watt-hours) over (a)Kitchen (b)Laundry (c)A/C");
			b.println("##Kitchen");
			for (String i : result.getAggregateMeterKitchen().keySet()) {
					b.println("* "+i+"\t"+result.getAggregateMeterKitchen().get(i));
					b.println("\n");
			}
			b.println("##Laundry");
			for (String i : result.getAggregateMeterLaundry().keySet()) {
					b.println("* "+i+"\t"+result.getAggregateMeterLaundry().get(i));
					b.println("\n");
			}
			b.println("\n");
			b.println("##A/C");
			for (String i : result.getAggregateMeterAC().keySet()) {
					b.println("* "+i+"\t"+result.getAggregateMeterAC().get(i));
					b.println("\n");
			}
			b.println("\n");
			b.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(-1);
		}
		return 0;
	}

}
