package Lab11;

import java.util.Comparator;

public class Komparator implements Comparator<String> {
	
    public int compare(String a, String b)
    {
    	if (a == b) {
            return 0;
        }
    	
    	return a.compareTo(b);    	
    }
}
