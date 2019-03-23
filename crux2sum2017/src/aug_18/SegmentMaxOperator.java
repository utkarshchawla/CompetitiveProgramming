package aug_18;

public class SegmentMaxOperator implements ISegmentOperator {

	@Override
	public int operation(int lsv, int rsv) {
		return Integer.max(lsv, rsv);
	}

	@Override
	public int defaultvalue() {
		return Integer.MIN_VALUE;
	}

}
