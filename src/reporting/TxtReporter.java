package reporting;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import datamodel.IResult;

public class TxtReporter implements IResultReporter {

	@Override
	public int reportResultInFile(IResult result, String filename) {
		String description=result.getDescription();
		String aggF=result.getAggregateFunction();
		System.out.println("op:"+filename);
		File f=new File(filename);
		try {
			PrintWriter b = new PrintWriter(new FileOutputStream(f));
			b.write(description);
			b.write("\n");
			b.write("=======================================\n");
			b.write(aggF+"  consumption(watt-hours) over (a)Kitchen (b)Laundry (c)A/C");
			b.write("\n");
			b.write("\n");
			b.write("Kitchen");
			b.write("\n");
			b.write("--------------\n");
			b.write("\n");
			for (String i : result.getAggregateMeterKitchen().keySet()) {
					b.write("* "+i+":\t"+result.getAggregateMeterKitchen().get(i));
					b.write("\n");
			}
			b.write("\n");
			b.write("Laundry");
			b.write("\n");
			b.write("--------------\n");
			b.write("\n");
			for (String i : result.getAggregateMeterLaundry().keySet()) {
					b.write("* "+i+":\t"+result.getAggregateMeterLaundry().get(i));
					b.write("\n");
			}
			b.write("\n");
			b.write("A/C");
			b.write("\n");
			b.write("--------------\n");
			b.write("\n");
			for (String i : result.getAggregateMeterAC().keySet()) {
					b.write("* "+i+":\t"+result.getAggregateMeterAC().get(i));
					b.write("\n");
			}
			b.write("\n");
			b.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(-1);
		}
		return 0;
	}

}
