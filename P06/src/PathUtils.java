import java.util.ArrayList;


public class PathUtils {
	
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int countPaths(Intersection start, Intersection end) {
		int result = 0;
		
		if (start.equals(end))
			return 1;
		if (start.getX() < end.getX())
		{
			
			result += countPaths(start.goEast(), end);
		}
		if (start.getY() < end.getY())
		{
			
			result += countPaths(start.goNorth(), end);
		}
		return result;
	}
	
	
	
	
		public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
			ArrayList<Path> result = new ArrayList<Path>();
			
			ArrayList<Intersection> intersections = new ArrayList<Intersection>();
			if (start.equals(end)) {
				Path path = new Path();
		        path.addTail(start);
		        result.add(path);
		        return result;
			}
			
			if (start.getX() < end.getX())
			{
				
				ArrayList<Path> result1 = new ArrayList<Path>();
				result1 = findAllPaths(start.goEast(), end);
				for (int i = 0; i < result1.size();i++)
				{
					result1.get(i).addHead(start);
					result.add(result1.get(i));
				}
				
			}
			if (start.getY() < end.getY())
			{
				//intersections.add(start);
				
				
				ArrayList<Path> result1 = new ArrayList<Path>();
				result1 = findAllPaths(start.goNorth(), end);
				
				for (int i = 0; i < result1.size();i++)
				{
					result1.get(i).addHead(start);
					result.add(result1.get(i));
				}
			}
			
			
			
			return result;
		  }

	
	
	 public static void main(String[]args) {
	     int count = countPaths(new Intersection(0,1) , new Intersection(3, 2));
	  ArrayList<Path> path = findAllPaths(new Intersection(0,0) , new Intersection(2, 2));
		    System.out.println(count);
		    System.out.println(path);
	 }

}
