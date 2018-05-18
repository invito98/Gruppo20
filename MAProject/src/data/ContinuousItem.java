<<<<<<< HEAD

package data;
//import java.lang.Math.*;

class ContinuousItem extends Item
{
	ContinuousItem(ContinuousAttribute attribute,Double value)
	{
		super(attribute,value);
	}
	
	double distance(Object a)
	{
		double first=((ContinuousAttribute)getAttribute()).getScaledValue((double)getValue());
		double second=((ContinuousAttribute)getAttribute()).getScaledValue((double)a);
		
		double result=Math.abs(first-second);
		return result;
		
	}
}
=======

package data;

class ContinuousItem extends Item {
	
	ContinuousItem(Attribute attribute, Double value)
	{
		super(attribute, value);
	}

	double distance(Object a)
	{
		double first = ((ContinuousAttribute)getAttribute()).getScaledValue((double)getValue());
		double second = ((ContinuousAttribute)getAttribute()).getScaledValue((double)a);
		
		
		return Math.abs(first-second); // valore assoluto
	}
	
}
>>>>>>> 741ff817e60052cb01a51f71b8e37de0b6844fe0
