package july_17;

public class DynamicQueue extends queue{

	@Override
	public void enqueue(int item)throws Exception{
		if(size == data.length){
			int[] oa = this.data;
			this.data = new int[2 * oa.length];
			
			for(int i = 0; i < size; i++){
				this.data[i] = oa[(front + i) % data.length];
				
			}
			front = 0;
		} 
		
		super.enqueue(item);
	}
}
