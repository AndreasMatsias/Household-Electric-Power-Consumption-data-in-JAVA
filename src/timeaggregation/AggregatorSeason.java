package timeaggregation;

import java.util.ArrayList;


import datamodel.IResult;
import datamodel.MeasurementRecord;

public class AggregatorSeason implements IAggregator
{
	@Override
	public IResult aggregateByTimeUnit(ArrayList<MeasurementRecord> inputMeasurements, String aggFunction,
			String description) 
	{
		MeasurementRecord result = new MeasurementRecord();
		result.setAggFunction(aggFunction);
		result.setAggType(getTimeUnitType());
		result.setDescription(description);
		for (int i = 0; i <inputMeasurements.size(); i++) {
			result.add("season", inputMeasurements.get(i));
		}
		result.getDetailedResults();
		result.getAggregateMeterKitchen();
		result.getAggregateMeterLaundry();
		result.getAggregateMeterAC();
		return result;
	}

	@Override
	public String getTimeUnitType() {
		
		return "season";
	}

}

		 
