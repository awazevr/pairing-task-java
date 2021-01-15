package area;

public class Rectangle {
	public float x1, x2, y1, y2;
	
	public Rectangle() {
		//null rectangle (contains nothing)
		this(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
	};
	
	public Rectangle(float x1, float y1, float x2, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public boolean contains(DataPoint point){

		return false;
	}


}
