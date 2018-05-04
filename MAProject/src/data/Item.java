package data;

import utility.ArraySet;

public abstract class Item {
	
	private Attribute attribute; // Classe Attribute da ereditare
	private Object value; // oggetto valore

	public Item(Attribute attributo, Object valore)
	{
		attribute = attributo;
		value = valore;
	}

	Attribute getAttribute()
	{
		return attribute;
	}

	Object getValue()
	{
		return value;
	}

	public String toString()
	{
		return (String)value; // cast a string
	}

	abstract double distance(Object a); // da implementare per ogni Attribute

	public void update(Data data, ArraySet clusteredData)
	{
		value = data.computePrototype(clusteredData,attribute);
	}

}
