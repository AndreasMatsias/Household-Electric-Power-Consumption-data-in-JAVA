package reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import datamodel.IResult;

public class HtmlReporter implements IResultReporter {

	@Override
	public int reportResultInFile(IResult result, String filename) {
		String description=result.getDescription();
		String aggF=result.getAggregateFunction();
		String header = new String("");
		header.concat("<!doctype html>");
		header.concat("\n");
		header.concat("<html>");
		header.concat("\n");
		header.concat("<head>");
		header.concat("\n");
		header.concat("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
		header.concat("\n");
		header.concat(description);
		header.concat("\n");
		header.concat("</head>");
		header.concat("\n");
		header.concat("<body>");
		header.concat("\n");
		try {
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename)); // APPEND would be .... (new FileOutputStream(outputFileName, true));
			outputStream.println(header);
			
			outputStream.println("<table>");
			outputStream.println("<h1><strong>"+result.getDescription()+"</strong></h1>");
			outputStream.println("<td>"+aggF+" consumption (watt-hours) over (a) Kitchen, (b) Laundry, (c) A/C"+"</tr>");
			outputStream.println("<td>");
			outputStream.println("<h2><strong>"+"Kitchen");
			outputStream.println("\n</strong></h2>");
			for (String i : result.getAggregateMeterKitchen().keySet()) {
				outputStream.println("<li>"+i+"\t"+result.getAggregateMeterKitchen().get(i)+"</li>");
			}
			outputStream.println("</tr>");
			outputStream.println("<td>");
			outputStream.println("<h2><strong>"+"Laundry");
			outputStream.println("\n</strong></h2>");
			for (String i : result.getAggregateMeterLaundry().keySet()) {
				outputStream.println("<li>"+i+"\t"+result.getAggregateMeterLaundry().get(i)+"</li>");
			}
			outputStream.println("\n</tr>");
			outputStream.println("<td>");
			outputStream.println("<h2><strong>"+"A/C");
			outputStream.println("\n</strong></h2>");
			for (String i : result.getAggregateMeterAC().keySet()) {
				outputStream.println("<li>"+i+"\t"+result.getAggregateMeterAC().get(i)+"</li>");
			}
			outputStream.println("\n</tr>");
			outputStream.println("</table>");
			outputStream.println("</body>\n</html>");
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files.");
			System.exit(-1);
		}
		return 0;
	}

}
