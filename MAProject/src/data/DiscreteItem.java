package data;

class DiscreteItem extends Item {
	
	DiscreteItem(DiscreteAttribute attribute, String value)
	{
		super(attribute, value);
	}

	double distance(Object a) // per stabilire la distanza di un valore dall'altro
	{
		if (this.getValue().equals(a))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}	

}
