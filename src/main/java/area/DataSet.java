package area;

import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class DataSet {

	public static List<DataPoint> readDataPoints(String fileName) throws DataException {
		class DataPointEntryParser implements CSVEntryParser<DataPoint> {
			@Override
			public DataPoint parseEntry(String... data) {
				float x = Float.parseFloat(data[0]);
				float y = Float.parseFloat(data[1]);
				return new DataPoint(x, y);
			}
		}
		try {
			Reader csvFile = new InputStreamReader(new FileInputStream(fileName));

			CSVReader<DataPoint> points_Reader = new CSVReaderBuilder<DataPoint>(csvFile).entryParser(new DataPointEntryParser()).build();
			return points_Reader.readAll();
		} catch (IOException e) {
			throw new DataException(e);
		}
	}

}
