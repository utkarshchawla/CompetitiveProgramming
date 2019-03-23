package aug_18;

public class SegmentMinOperator implements ISegmentOperator{

	@Override
	public int operation(int lsv, int rsv) {
		// TODO Auto-generated method stub
		return Integer.min(lsv, rsv);
	}

	@Override
	public int defaultvalue() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

}
