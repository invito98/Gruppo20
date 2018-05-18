<<<<<<< HEAD

package data;

abstract class Attribute {
	
	private String name; // nome simbolico attributo
	private int index; // identificativo attributo
	
	Attribute(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	
	String getName()
	{
		return name;
	}
	
	int getIndex()
	{
		return index;
	}
	
	public String toString()
	{
		return name;
	}

}
=======

package data;

abstract class Attribute {
	
	private String name; // nome simbolico attributo
	private int index; // identificativo attributo
	
	Attribute(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	
	String getName()
	{
		return name;
	}
	
	int getIndex()
	{
		return index;
	}
	
	public String toString()
	{
		return name;
	}

}
>>>>>>> 741ff817e60052cb01a51f71b8e37de0b6844fe0
