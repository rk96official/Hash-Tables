
public class Tester {
	public static void main(String[] args){
		//create a hashTable 
		ourHashTable HT = new ourHashTable(100);
		HT.put("Harry", 12.7);
		HT.put("paul", new Double(-10.9));
		HT.put("Arry", 12.7);
		System.out.println("size: " + HT.size() + " capacity: " + HT.capacity());
		System.out.println(HT.toString());
		System.out.println("Harry: " + HT.hashCode("Harry") + " paul: " + HT.hashCode("paul") + 
				" Arry: " + HT.hashCode("Arry"));
		System.out.println(HT.hashCode("Hargtrv"));
		//Hargtrv will be chained to paul because they will have the same index: 34. 
		HT.put("Hargtrv", -45.7);
		System.out.println(HT.toString());
	}

}