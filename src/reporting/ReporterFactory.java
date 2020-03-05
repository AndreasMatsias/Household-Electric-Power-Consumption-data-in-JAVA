package reporting;

public class ReporterFactory 
{
	public IResultReporter createReporter(String filetype)
	{
		if(filetype.equals("md")) 
		{
			return new MarkdownReporter();
		}
		if(filetype.equals("html")) 
		{
			return new HtmlReporter();
		}
		if(filetype.equals("txt")) 
		{
			return new TxtReporter();
		}
		
		System.out.println("If the code got up to here, you passed a wrong argument to the Reporter Factory");
		return null;
	}
}
