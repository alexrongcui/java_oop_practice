package ece325_lab_assignment6;

public class MillisPerformanceMeasurement implements PerformanceMeasurement {
	
	long startTime = 0;
	long endTime = 0;
	long resultTime = 0;

	@Override
	public void start() {
		 startTime = System.currentTimeMillis();
		
	}

	@Override
	public void end() {
		 endTime = System.currentTimeMillis();
		
	}

	@Override
	public void reset() {
		startTime = 0;
		endTime = 0;
		resultTime = 0;
	}

	@Override
	public long getResult() {
		resultTime = endTime - startTime;
		return resultTime;
	}

}
