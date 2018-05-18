
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
