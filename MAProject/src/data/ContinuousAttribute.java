package data;
class ContinuousAttribute extends Attribute {
	
	private double max;
	private double min;
	
	ContinuousAttribute (String name, int index, double min, double max)
	{
		super (name, index); // stiamo invocando il costruttore della classe padre
		min = 0;
		max = 100;
	}
	
	double getScaledValue (double v)
	{
		v = (1 - min) / (max - min);
		return v;
	}

}