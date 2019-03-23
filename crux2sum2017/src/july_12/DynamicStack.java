package july_12;

public class DynamicStack extends stack {

	@Override
	public void push(int item)throws Exception{
		if (tos + 1 >= data.length) {
			int[] oa = this.data;
			this.data = new int[2 * oa.length];
			for(int i = 0 ; i < oa.length; i++){
				this.data[i] = oa[i];
			}
		}
		super.push(item);
	}
}
