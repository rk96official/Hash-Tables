
public class ourHashTable {
	private class Node{
		Object key;
		Object value;
		Node next;
		public Node(){
			key = null;
			value = null;
		}
		public Node(Object k, Object v){
			key = k;
			value = v;
		}
		public void setNext(Node n){
			next = n;
		}
		public Node getNext() {
			return next;
		}
		public String toString() {
			String st = "k: " + key.toString() + "  v: " + value.toString();
			return st;
		}
		public Object getValue() {
			return value;
		}
		public Object getKey() {
			return key;
		}
	}
	
	Node[] list;
	int capacity, size;
	float loadFactor; // 0.8 when the table reaches 80% full, we resize, we increase capacity and 
	//we rehash: compute new indexes for all entries and update accordingly
	public ourHashTable() {
		list = new Node[1000];
		capacity = 1000;
		size = 0;
		loadFactor = 1;
	}
	public ourHashTable(int c) {
		list = new Node[c];
		capacity = c;
		size = 0;
		loadFactor = 1;
	}
	public ourHashTable(int c, float l) {
		list = new Node[c];
		capacity = c;
		size = 0;
		loadFactor = l;
	}
	//Hash function  
	public long hashCode(String s) {
		long code = 0;
		for (int i = 0; i <Math.min(s.length(), 57); i++){
			code = code*26 + (int) s.charAt(i);
		}
		return code;
	}
	//put allows to add an element to the hash table
	public void put(Object k, Object v) {
		Node temp = new Node(k, v);
		size++;
		//compute the index
		int ind = (int)hashCode(k.toString())%capacity;
		if(list[ind]==null){
			//just add the node to that entry, the entry if free
			list[ind] = temp;
		} else {
			//chain temp, insert it at the head of the linked list
			temp.setNext(list[ind]);
			list[ind] = temp;
		}
	}
	public int size() {return size;}
	public int capacity() {return capacity;}
	public String toString() {
		String st="";
		for (int i = 0; i<capacity; i++){
			Node temp = list[i];
			while(temp!=null) {
				st = st+" " + temp.toString();
				temp = temp.next;
			}
		}
		return st;
	}
	public Object get(Object k) {
		//create an index
		int ind = (int)hashCode(k.toString())%capacity;
		if(list[ind] == null) 
			return null;
		Node temp = list[ind];
		while(temp != null) {
			if(temp.getKey().equals(k))
				return temp.getValue();
		}
		//the key is not there
		return null;
	}
	public Object remove(Object key) {
		//DO IT
		return null;
	}
}