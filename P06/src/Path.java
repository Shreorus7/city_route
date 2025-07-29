import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Path {
    private ArrayList<Intersection> intersections;
    public Path(){
    	intersections = new ArrayList<Intersection>();
    }
    
    public int length() {
    	return intersections.size();
    }
    public Intersection getHead() throws NoSuchElementException{
    	if (intersections.size() <= 0)
    		throw new NoSuchElementException("No element in Path");
    	else
    		return intersections.get(0);
    }
    public Intersection getTail() throws NoSuchElementException{
    	if (intersections.size() <= 0)
    		throw new NoSuchElementException("No element in Path");
    	else
    		return intersections.get(intersections.size() - 1);
    }
    //there might be an error here
    public void addTail(Intersection toAdd) throws IllegalArgumentException {
    	if (intersections.size() != 0 && !(intersections.get(length() - 1).goEast().equals(toAdd)) 
    			&& !(intersections.get(length() - 1).goNorth().equals(toAdd)))
            throw new IllegalArgumentException("intersection cannot be added to tail");
    	
    	intersections.add(toAdd);
    }
  //there might be an error here
    public void addHead(Intersection toAdd) {

        boolean a = false;

        if (intersections.isEmpty() || intersections.get(0) == null) { 
          intersections.add(toAdd);
          a = true;
        }


        else if (intersections.get(0).goWest().equals(toAdd)) { 
          intersections.add(0, toAdd);
          a = true;
        }

        else if (intersections.get(0).goSouth().equals(toAdd)) { 
          intersections.add(0, toAdd);
          a = true;
        }

       if (!a) { // checks if intersection is not a valid addition
          throw new IllegalArgumentException("this intersection is not valid"); 
        }



      }
  //there might be an error here
    public String toString() {
    	String result = "";
    	if (length() == 0)
    		return "Empty";
    	for (int i = 0; i < length(); i++) {
    		result += intersections.get(i).toString();
    		if (i != length() - 1)
    			result += "->";
    	}
    	
    	return result;
    		 
    }
}
