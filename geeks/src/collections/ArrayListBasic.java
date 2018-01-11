package collections;

/**
 * 
 * @author PUSHKAR CHAWDA
 *
 */

public class ArrayListBasic {

	int arr[];
	int size;
	int index;
	
	ArrayListBasic()
	{
		this.size = 2;
		this.arr = new int[this.size];
		this.index = 0;
	}
	
	public void growArray(){
		this.size = this.size*2;
		int arrResize[] = new int[this.size];
		int length = this.arr.length;
		for(int i=0;i<length;i++)
		{
			arrResize[i] = this.arr[i];
		}
		this.arr = arrResize;
	}
	
	public void add(int element)
	{
		if(this.index<this.size)
		{
			arr[this.index++] = element;
		}
		else
		{
			growArray();
			arr[this.index++] = element;
		}
	}
	
	public int get(int index)
	{
		if(index<this.size && index >= 0)
			return arr[index];
		else
		{
			return -1;
		}
	}
	
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("[ ");
		int length = this.arr.length;
		for(int i=0;i<length;i++)
		{
			s.append(arr[i]+" ");
		}
		s.append("]");
		return s.toString();
	}

}
