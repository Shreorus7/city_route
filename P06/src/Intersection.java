
/**
 * This class represents a single intersection point where
 *   two streets cross at specified x and y coordinate positions.
 * @author Shreyas Reddy
 *
 */
public class Intersection {
private final int x;
private final int y;

     /**
      * Constructor for Intersection class. Intializes all fields.
      * @param x
      * @param y
      */
	public Intersection(int x, int y) {
      
		this.x = x;
		this.y = y;
	
	}
	
	@Override
	public boolean equals(Object o) {
	
		if (o instanceof Intersection)
		{
			Intersection other = (Intersection)o;
			return (this.getX() == other.getX() && this.getY() == other.getY());
		}
		return false;
		
		
	}
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public Intersection goNorth(){
		Intersection i = new Intersection(x, y + 1);
		return i;
	}
	
	public Intersection goSouth(){
		Intersection i = new Intersection(x, y - 1);
		return i;
	}
	
	public Intersection goEast() {
	      Intersection i = new Intersection(x+1, y);
	      return i;
	}
	
	public Intersection goWest() {
	      Intersection i = new Intersection(x-1, y);
	      return i;
	}
	
	public String toString() {
	
		return "(" + getX() + "," + getY() + ")";
	}
	
	
}
