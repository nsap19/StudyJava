package jiyeop;
import java.util.ArrayList;

public class NewsClustering {

	static class newsclustering {
	    public int solution(String str1, String str2) {
	    	ArrayList<String> arr1 = new ArrayList<>();
	    	ArrayList<String> arr2 = new ArrayList<>();
	    	ArrayList<String> union = new ArrayList<>();
	    	ArrayList<String> intersection = new ArrayList<>();
	    	int answer = 0;
	    	
	    	str1 = str1.toLowerCase();
	    	str2 = str2.toLowerCase();
	    	
	    	for (int i = 0; i < str1.length()-1; i++) {
				char c1 = str1.charAt(i);
				char c2 = str1.charAt(i + 1);
				if(c1>='a'&& c1<='z' && c2>='a' && c2<='z') {
					arr1.add(str1.substring(i,i+2));
				}
			}
	    	//System.out.println(arr1.toString());
	    	for (int i = 0; i < str2.length()-1; i++) {
	    		char c1 = str2.charAt(i);
				char c2 = str2.charAt(i+1);
				if(c1>='a'&& c1<='z' && c2>='a' && c2<='z') {
					arr2.add(str2.substring(i,i+2));
				}
			}
	    	//System.out.println(arr2.toString());
	    	
	    	for (int i = 0; i < arr1.size(); i++) {
				String a1 = arr1.get(i);
				if(arr2.remove(a1)) {
					intersection.add(a1);
				}
				union.add(a1);
			}
	    	for (int i = 0; i < arr2.size(); i++) {
				union.add(arr2.get(i));
			}
	    	//System.out.println(intersection.toString());
	    	//System.out.println(union.toString());
	    	double num = 0;
	    	if(union.size() == 0) {
	    		num = 65536;
	    	}else {
	    		num = (double)intersection.size() / (double)union.size()*65536;
	    	}
	    	
	    	answer = (int)(num);
	    	//System.out.println(answer);
	        return answer;
	    }
	}
	public static void main(String[] args) {
		newsclustering sol = new newsclustering();
		String str1= "e=m*c^2";
		String str2= "E=M*C^2";
		sol.solution(str1, str2);
	}
}
