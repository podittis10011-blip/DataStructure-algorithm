package DataStructure.Array;

class sArrayList{

	//实际存储的元素个数
	
	//初始容量为10
	private int capacity = 10;
	private int size = 0;
	private int[] intArray;
	
	//缺省构造器
	public  sArrayList(){
	}
	
	//有参构造器
	public sArrayList(int capacity){
		this.capacity = capacity;
	}
	
	//为空
	public boolean isEmpty(){
		if(this.size == 0){
			return true;
		}
		return false;
	}
	
	//为满
	public boolean isFull(){
		if(this.size == capacity){
			return true;
		}
		return false;
	}
	
	//初始化数组
	public  void initArray(){
		this.intArray = new int[capacity];
	}
	
	
	//尾插
	public void add(int value){
		if(isFull()){
			this.grow();
		}
		intArray[size] = value;
		size++;
		return;
		
	}
	
	//中间插入
	public void insert(){
		
	}
	
	public void grow(){
		//容量变为原来的1.5倍
		this.capacity = capacity + (capacity >> 1);

		//创建新数组
		int[] newArray = new int[capacity];

		for(int i = 0;i < size;i++){
			newArray[i] = intArray[i];
		}

		this.intArray = newArray;
		return;
	}
	
	//测试程序
	public static void main(String args[]){
		//初始化动态数组
		sArrayList al = new sArrayList();
		
		al.initArray();
		
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);
		al.add(1);

		System.out.println("al:");
		for(int i = 0;i < al.size;i++){
			System.out.println(al.intArray[i]);
		}
		
		al.add(2);
		// System.out.println(al.intArray[10]);

		sArrayList al1 = new sArrayList();

		al1.initArray();

		al1.add(1);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);
		al1.add(2);

		System.out.println("al1");
		for(int i = 0;i < al.size;i++){
			System.out.println(al1.intArray[i]);
		}

		System.out.println("al:");
		for(int i = 0;i < al.size;i++){
			System.out.println(al.intArray[i]);
		}


	}
	
	

}