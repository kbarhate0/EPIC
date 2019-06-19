package reusables;

public class testing {

	public static void main(String[] args) {
		String s1 = "2.27 GB";
				String s2 = "2.29 GB";
				System.out.println(s1.substring(0,s1.indexOf(" ")));
				
		double i = Double.parseDouble(s1.substring(0,s1.indexOf(" ")));
    	double j = Double.parseDouble(s2.substring(0,s2.indexOf(" ")));
    	System.out.println(j-i);
		// TODO Auto-generated method stub
    	
    	CommonFunctions2.getDifference(s1, s2, "TCIP");

	}

}
