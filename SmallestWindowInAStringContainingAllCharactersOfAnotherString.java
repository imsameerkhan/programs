import java.util.HashMap;
import java.util.Map;

public class SmallestWindowInAStringContainingAllCharactersOfAnotherString{

public static void main(String[] args) {
		
		String a = "ADOBECODEBANC", b = "ABC";
		//output=BANC
		//ADOBEC
		System.out.println(helper(a,b));
		
	}


	private static String helper(String a,String b) {
		
		Map<Character,Integer> map1=new HashMap<>();
		Map<Character,Integer> map2=new HashMap<>();
		for(char c:b.toCharArray())
			map2.put(c, map2.getOrDefault(c, 0)+1);
		int i=-1,j=-1;
		int count=0;
		int mat=b.length();
		String ans="";
		while(true) {
			boolean f1=false;
			boolean f2=false;
			while(i<a.length()-1&&count<mat) {
				i++;
				char c=a.charAt(i);
				map1.put(c, map1.getOrDefault(c, 0)+1);
				if(map1.getOrDefault(c,0)<=map2.getOrDefault(c,0))
					count++;
				f1=true;
			}
			while(j<i&&count==mat) {
				String res=a.substring(j+1,i+1);
				if(ans.length()==0||ans.length()>res.length())
					ans=res;
				j++;
				char c=a.charAt(j);
				if(map1.get(c)==1)
					map1.remove(c);
				else
					map1.put(c, map1.get(c)-1);
				if(map1.getOrDefault(c, 0)<map2.getOrDefault(c, 0))
					count--;
				f2=true;
			}
			if(!f1&&!f2)
				break;
		}
		
		return ans;
	}
}