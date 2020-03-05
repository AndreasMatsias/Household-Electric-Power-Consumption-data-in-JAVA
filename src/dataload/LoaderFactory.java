package dataload;

public class LoaderFactory<E> 
{
	public ILoader<E> createLoader(String className)
	{
		if(className.equals("Loader"))
			return new Loader<E>();
		
		System.out.println("If the code got up to here, you passed a wrong argument to the FullDataLoader Factory");
		return null;
	}
}
