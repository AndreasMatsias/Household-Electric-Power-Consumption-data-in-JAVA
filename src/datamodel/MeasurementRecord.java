package datamodel;

import java.util.ArrayList;
import java.util.HashMap;

public class MeasurementRecord implements IResult 
{
	public MeasurementRecord() 
	{
		
	}
	public MeasurementRecord(String fdate,String ftime,String fm1,String fm2,String fm3,String fm4,String fm5,String fm6,String fm7) {
		date = fdate;
		time = ftime;
		m1 = fm1;
		m2 = fm2;
		m3 = fm3;
		m4 = fm4;
		m5 = fm5;
		m6 = fm6;
		m7 = fm7;
	}
	
	public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }
    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }
    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }
    public String getM4() {
        return m4;
    }

    public void setM4(String m4) {
        this.m4 = m4;
    }
    public String getM5() {
        return m5;
    }

    public void setM5(String m5) {
        this.m5 = m5;
    }
    public String getM6() {
        return m6;
    }

    public void setM6(String m6) {
        this.m6 = m6;
    }
    public String getM7() {
        return m7;
    }

    public void setM7(String m7) {
        this.m7 = m7;
    }
    private String aggFunction;

	
	public void setAggFunction(String aggFunction)
	{
		this.aggFunction = aggFunction;
	}
	
	private String aggType;

	public String getAggType()
	{
		return aggType;
	}

	public void setAggType(String aggType)
	{
		this.aggType = aggType;
	}
	@Override
	public String getAggregateFunction() {
		return aggFunction;
	}
/////////////////////////////////////////////////////////////////////////////////////
	
	
	ArrayList<MeasurementRecord> MR = new ArrayList<MeasurementRecord>();
	HashMap<String,  ArrayList<MeasurementRecord>> details = new HashMap<String, ArrayList<MeasurementRecord>>();
	HashMap<String, Double> Kitchen = new HashMap<String,Double>();
	HashMap<String, Double> Laundry = new HashMap<String,Double>();
	HashMap<String, Double> AC = new HashMap<String,Double>();
	ArrayList<MeasurementRecord> MR_monday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_tuesday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_wednesday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_thursday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_friday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_saturday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_sunday = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_1 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_2 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_3 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_4 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_5 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_6 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_7 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_8 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_9 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_10 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_11 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_12 = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_1s = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_2s = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_3s= new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_4s = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_1t = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_2t = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_3t = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_4t = new ArrayList<MeasurementRecord>();
	ArrayList<MeasurementRecord> MR_5t = new ArrayList<MeasurementRecord>();
	
	
	public String description;
/////////////////////////////////////////////////////////////////////////////////////
    /**
	 * Adds a new measurement to the result, appropriately placed
	 * 
	 * @param timeUnit a String by which we aggregate measurements
	 * @param record a MeasurementRecord to be added
	 * 
	 * @return the size of the collection of Measurement objects to which record has been added
	 */
	
	@Override
	public int add(String timeUnit, MeasurementRecord record) {
		//System.out.println(timeUnit);
		MR.add(record);
		return MR.size();
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 * Return the textual description for what the result is all about
	 * 
	 * @return A String with the text describing the result
	 */
	
	@Override
	public String getDescription() {
		return description;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	String Zeller(int day, int month,int year) 
	{ 
		String result = null;
		if (month == 1) 
		{ 
			month = 13; 
			year--; 
		} 
		if (month == 2) 
		{ 
			month = 14; 
			year--; 
		} 
		int q = day; 
		int m = month; 
		int k = year % 100; 
		int j = year / 100; 
		int h = q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j; 
		h = h % 7; 
		if(h==0)
		{ 
			result="Saturday"; 
		}
		if(h==1)
		{ 
			result="Sunday"; 
		}
		if(h==2)
		{ 
			result="Monday"; 
		}
		if(h==3)
		{ 
			result="Tuesday"; 
		}
		if(h==4)
		{ 
			result="Wednesday"; 
		}
		if(h==5)
		{ 
			result="Thursday"; 
		}
		if(h==6)
		{ 
			result="Friday"; 
		} 
		return result;
	} 
	/**
	 * Returns the source measurements organized per grouping time unit
	 * 
	 * For example, if the grouping is done per month, for String "January" there is an ArrayList of MeasurementRecord with the 
	 * measurements with their date being in January, String "February" has the respective measurements with date in February, and so on...
	 * 
	 * @return A HashMap<String, ArrayList<MeasurementRecord>> with a ArrayList<MeasurementRecord> for each String representing a time unit 
	 */
	@Override
	public HashMap<String, ArrayList<MeasurementRecord>> getDetailedResults() {
		//int count1=0,count2=0,count3=0,count4=0,count5=0,
				//count6=0,count7=0,count8=0,count9=0,count10=0,count11=0,count12=0;
		String dateParts[];	
		String timeParts[];
		String aggT=getAggType();
		if(aggT=="dayofweek") 
		{
			for (int i = 0; i < MR.size(); i++) 
			{
				String datePart=MR.get(i).getDate();
				dateParts= datePart.split("/");
				String day  = dateParts[0];
				String month  = dateParts[1];
				String year = dateParts[2];
				int r1 = Integer.parseInt(day);
				int r2 = Integer.parseInt(month);
				int r3 = Integer.parseInt(year);
				String day2=Zeller(r1,r2,r3);
				if(day2.equals("Monday")) {
					MR_monday.add(MR.get(i));
				}
				if(day2.equals("Tuesday")) {
					MR_tuesday.add(MR.get(i));	
				}
				if(day2.equals("Wednesday")) {
					MR_wednesday.add(MR.get(i));	
				}
				if(day2.equals("Thursday")) {
					MR_thursday.add(MR.get(i));	
				}
				if(day2.equals("Friday")) {
					MR_friday.add(MR.get(i));
					
				}
				if(day2.equals("Saturday")) {
					MR_saturday.add(MR.get(i));
				}
				if(day2.equals("Sunday")) {
					MR_sunday.add(MR.get(i));
				}
			}
			details.put("01",MR_monday);
			details.put("02",MR_tuesday);
			details.put("03",MR_wednesday);
			details.put("04",MR_thursday);
			details.put("05",MR_friday);
			details.put("06",MR_saturday);
			details.put("07",MR_sunday);
		}
		if(aggT=="month") {
			for (int i = 0; i < MR.size(); i++) 
			{
				String datePart=MR.get(i).getDate();
				dateParts= datePart.split("/");
				String day  = dateParts[0];
				String month  = dateParts[1];
				String year = dateParts[2];
				int r1 = Integer.parseInt(day);
				int r2 = Integer.parseInt(month);
				int r3 = Integer.parseInt(year);
				if(r2==1) {
					MR_1.add(MR.get(i));
				}
				if(r2==2) {
					MR_2.add(MR.get(i));
				}
				if(r2==3) {
					MR_3.add(MR.get(i));
				}
				if(r2==4) {
					MR_4.add(MR.get(i));
				}
				if(r2==5) {
					MR_5.add(MR.get(i));
				}
				if(r2==6) {
					MR_6.add(MR.get(i));
				}
				if(r2==7) {
					MR_7.add(MR.get(i));
				}
				if(r2==8) {
					MR_8.add(MR.get(i));
				}
				if(r2==9) {
					MR_9.add(MR.get(i));
				}
				if(r2==10) {
					MR_10.add(MR.get(i));
				}
				if(r2==11) {
					MR_11.add(MR.get(i));
				}
				if(r2==12) {
					MR_12.add(MR.get(i));
				}
			}
			details.put("01",MR_1);
			details.put("02",MR_2);
			details.put("03",MR_3);
			details.put("04",MR_4);
			details.put("05",MR_5);
			details.put("06",MR_6);
			details.put("07",MR_7);
			details.put("08",MR_8);
			details.put("09",MR_9);
			details.put("10",MR_10);
			details.put("11",MR_11);
			details.put("12",MR_12);
		}
		if(aggT=="season") {
			for (int i = 0; i < MR.size(); i++) 
			{
				String datePart=MR.get(i).getDate();
				dateParts= datePart.split("/");
				String day  = dateParts[0];
				String month  = dateParts[1];
				String year = dateParts[2];
				int r1 = Integer.parseInt(day);
				int r2 = Integer.parseInt(month);
				int r3 = Integer.parseInt(year);
				if(r2==1||r2==2||r2==12) {
					MR_1s.add(MR.get(i));
				}
				if(r2==3||r2==4||r2==5) {
					MR_2s.add(MR.get(i));
				}
				if(r2==6||r2==7||r2==8) {
					MR_3s.add(MR.get(i));
				}
				if(r2==9||r2==10||r2==11) {
					MR_4s.add(MR.get(i));
				}
			}
			details.put("WINTER",MR_1s);
			details.put("SPRING",MR_2s);
			details.put("SUMMER",MR_3s);
			details.put("AUTUMN",MR_4s);
			
		}
		if(aggT=="periodofday") {
			for (int i = 0; i < MR.size(); i++) 
			{
				String timePart=MR.get(i).getTime();
				timeParts= timePart.split(":");
				String p1  = timeParts[0];
				String p2  = timeParts[1];
				String p3 = timeParts[2];
				int r1 = Integer.parseInt(p1);
				int r2 = Integer.parseInt(p2);
				int r3 = Integer.parseInt(p3);
				if(r1==21  || r1==22|| r1==23 || r1==24|| r1==1|| r1==2|| r1==3) {
					MR_1t.add(MR.get(i));
				}
				if(r1==4  && r2<59 && r3<59) {
					MR_1t.add(MR.get(i));
				}
				//
				if(r1==5||r1==6||r1==7) {
					MR_2t.add(MR.get(i));
				}
				if(r1==8&&r2<59&&r3<59) {
					MR_2t.add(MR.get(i));
				}
				//
				if(r1==9||r1==10||r1==11) {
					MR_3t.add(MR.get(i));
				}
				if(r1==12&&r2<59&&r3<59) {
					MR_3t.add(MR.get(i));
				}
				//
				if(r1==13||r1==14||r1==15) {
					MR_4t.add(MR.get(i));
				}
				if(r1==16&&r2<59&&r3==59) {
					MR_4t.add(MR.get(i));
				}
				//
				if(r1==17|r1==18||r1==19) {
					MR_5t.add(MR.get(i));
				}
				if(r1==20&&r2<59&&r3==59) {
					MR_5t.add(MR.get(i));
				}
			}
			details.put("NIGHT",MR_1t);
			details.put("EARLY MORNING",MR_2t);
			details.put("MORNING",MR_3t);
			details.put("AFTERNOON",MR_4t);
			details.put("EVENING",MR_5t);
		}
		return details;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Stores the aggregate measurements for the Kitchen metric, one for each of the grouper time units 
	 * 
	 * @return A HashMap<String, Double>, where the grouping time unit is represented as a String and the aggregate value as a Double
	 */
	@Override
	public HashMap<String, Double> getAggregateMeterKitchen() {
		String aggF=getAggregateFunction();
		for (String i : details.keySet()) {
		      double sum=0;
		      double count =0;
		      for (int j=0; j< details.get(i).size(); j++) 
		      {
		    	  double s = Double.parseDouble(details.get(i).get(j).getM5());
		          sum +=s;
		          count++;
		      }
		      if(aggF.equals("sum")) {
		    	  Kitchen.put(i,sum);
		      }
		      if(aggF.equals("avg")) {
		    	  Kitchen.put(i,sum/count);
		      }
		      
		      
		}
		//System.out.println("01:"+Kitchen.get("01"));
		//System.out.println("02:"+Kitchen.get("02"));
		//System.out.println("03:"+Kitchen.get("03"));
		//System.out.println("04:"+Kitchen.get("04"));
		//System.out.println("05:"+Kitchen.get("05"));
		//System.out.println("06:"+Kitchen.get("06"));
		//System.out.println("07:"+Kitchen.get("07"));
		//System.out.println("WINTER:"+Kitchen.get("WINTER"));
		//System.out.println("SPRING:"+Kitchen.get("SPRING"));
		//System.out.println("SUMMER:"+Kitchen.get("SUMMER"));
		//System.out.println("AUTUMN:"+Kitchen.get("AUTUMN"));
		return Kitchen;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Stores the aggregate measurements for the Laundry metric, one for each of the grouper time units 
	 * 
	 * @return A HashMap<String, Double>, where the grouping time unit is represented as a String and the aggregate value as a Double
	 */
	@Override
	public HashMap<String, Double> getAggregateMeterLaundry() {
		String aggF=getAggregateFunction();
		
		for (String i : details.keySet()) {
		      double sum1=0;
		      double count1=0;
		      for (int j=0; j< details.get(i).size(); j++) {
		    	  double s = Double.parseDouble(details.get(i).get(j).getM6());
		          sum1 +=s;
		          count1++;
		      }
		      if(aggF.equals("sum")) Laundry.put(i,sum1);
		      if(aggF.equals("avg")) Laundry.put(i,sum1/count1);
		}
		//System.out.println(Laundry.get("01"));
		//System.out.println(Laundry.get("02"));
		//System.out.println(Laundry.get("03"));
		//System.out.println(Laundry.get("04"));
		//System.out.println(Laundry.get("05"));
		//System.out.println(Laundry.get("06"));
		//System.out.println(Laundry.get("07"));
		return Laundry;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Stores the aggregate measurements for the air condition metric, one for each of the grouper time units 
	 * 
	 * @return A HashMap<String, Double>, where the grouping time unit is represented as a String and the aggregate value as a Double
	 */
	@Override
	public HashMap<String, Double> getAggregateMeterAC() {
		String aggF=getAggregateFunction();
		
		for (String i : details.keySet()) {
		      double sum2=0;
		      double count2=0;
		      for (int j=0; j< details.get(i).size(); j++) {
		    	  double s = Double.parseDouble(details.get(i).get(j).getM7());
		          sum2 +=s;
		          count2++;
		      }
		      if(aggF.equals("sum")) AC.put(i,sum2);
		      if(aggF.equals("avg")) AC.put(i,sum2/count2);
		}
		//System.out.println(AC.get("01"));
		//System.out.println(AC.get("02"));
		//System.out.println(AC.get("03"));
		//System.out.println(AC.get("04"));
		//System.out.println(AC.get("05"));
		//System.out.println(AC.get("06"));
		//System.out.println(AC.get("07"));
		return AC;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	protected String date;
	protected String time;
	protected String m1;
	protected String m2;
	protected String m3;
	protected String m4;
	protected String m5;
	protected String m6;
	protected String m7;
}
