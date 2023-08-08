package area;

import java.util.Collection;

public class BruteForceAreaFinder implements AreaFinder {

    Collection<DataPoint> fullDataSet;

    public static BruteForceAreaFinder constructFrom(Collection<DataPoint> dataPoints) {
        return new BruteForceAreaFinder(dataPoints);
    }

    private BruteForceAreaFinder(Collection<DataPoint> dataPoints) {
        fullDataSet = dataPoints;
    }

    @Override
    public void findPointsInside(Rectangle rectangle, PointConsumer consumer) {
        //TODO : implement
    }
}
