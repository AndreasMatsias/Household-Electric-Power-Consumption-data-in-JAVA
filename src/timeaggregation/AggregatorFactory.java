package timeaggregation;



public class AggregatorFactory 
{
	public IAggregator createAggregator(String className)
	{
		if(className.equals("season") ) 
		{
			return new AggregatorSeason();
		}
		if(className.equals("dayofweek")) 
		{
			return new AggregatorDayofweek();
		}
		if(className.equals("month") ) 
		{
			return new AggregatorMonth();
		}
		if(className.equals("periodofday")) 
		{
			return new AggregatorPeriodofday();
		}
		System.out.println("If the code got up to here, you passed a wrong argument to the AGGREGATOR Factory");
		return null;
	}
}
