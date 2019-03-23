package aug_18;

public class SegmentProductOperator implements ISegmentOperator {

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return lsv * rsv;
	}

	@Override
	public int defaultvalue() {
		// TODO Auto-generated method stub
		return 1;
	}

}
