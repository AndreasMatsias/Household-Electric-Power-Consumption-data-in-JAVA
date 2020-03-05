package datamodel;



public class MeasurementRecordFactory 
{
	public MeasurementRecordFactory() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public MeasurementRecord createMeasurementRecord(String fdate,String ftime,String fm1,String fm2,String fm3,String fm4,String fm5,String fm6,String fm7)
	{
		jdate=fdate;
		jtime=ftime;
		jm1=fm1;
		jm2=fm2;
		jm3=fm3;
		jm4=fm4;
		jm5=fm5;
		jm6=fm6;
		jm7=fm7;
		return new MeasurementRecord(jdate,jtime,jm1,jm2,jm3,jm4,jm5,jm6,jm7);
		
	}
	public String jdate;
	public String jtime;
	public String jm1;
	public String jm2;
	public String jm3;
	public String jm4;
	public String jm5;
	public String jm6;
	public String jm7;
	
}
