package practise;

public class MinimumSwapToMakeParenthesisValid {

	public static void main(String[] args) {
		
		System.out.println(minimumSwap("][]["));
	}
	
	 private static int minimumSwap(String s) {
		   
		  int close=0,max=0;
		  for(char c:s.toCharArray()) {
			  
			  if(c=='('||c=='{'||c=='[')
				  close+=-1;
			  else
				  close+=1;
			  max=Math.max(max, close);
		  }
		  return max;
	   }
}
