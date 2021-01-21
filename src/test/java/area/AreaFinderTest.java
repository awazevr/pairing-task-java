package area;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AreaFinderTest {
	private static final String DATASET_CSV = "dataset.csv";
	private static final String EXPECTED_DATASET_CSV = "expected_dataset.csv";

	private static List<DataPoint> dataset;
	private static List<DataPoint> expectedResult;
	private static Rectangle rect;

	@BeforeClass
	public static void loadData() throws Exception{
		dataset = DataSet.readDataPoints(DATASET_CSV);
		expectedResult = DataSet.readDataPoints(EXPECTED_DATASET_CSV);
		rect = new Rectangle(-0.1f, -0.1f, 0.1f, 0.1f);
	}

	@Test
	public void testBruteForceAreaFinder() throws Exception {
		loadDataset(BruteForceAreaFinder.constructFrom(dataset));
	}

	private void loadDataset(AreaFinder finder){
		PointCollector collector = new PointCollector();
		finder.findPointsInside(rect, collector);
		List<DataPoint> actualResult = collector.getConsumedPoints();
		assertTrue(areIdentical(actualResult, expectedResult));
	}

	private boolean areIdentical(List<DataPoint> actualResults, List<DataPoint> expectedResults) {
		return   actualResults.size() == expectedResults.size()
				&& actualResults.containsAll(expectedResults)
				&& expectedResults.containsAll(actualResults);
	}

	private class PointCollector implements PointConsumer {

		List <DataPoint> results = new ArrayList<DataPoint>();

		@Override
		public void consumePoint(DataPoint point) {
			//todo : implement
		}

		public List<DataPoint> getConsumedPoints(){
			return  results;
		}
	}

}
