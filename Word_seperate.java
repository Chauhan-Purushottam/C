/*Given an input string and a dictionary of words,
 find out if the input string can be segmented into
  a space-separated sequence of dictionary words.
  ############################################
Input:
2
12
i like sam sung samsung mobile ice cream icecream man go mango
ilike
12
i like sam sung samsung mobile ice cream icecream man go mango
idontlike
Output:
1
0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class Word_seperate
 {
     static boolean func(HashSet<String> h, String s, int start){
         
         if(s.length()==start){
             return true;
         }
         
         for(int i=start; i<s.length(); i++){
             
             String sub = s.substring(start, i+1);
             
             if(h.contains(sub)){
                 
                 System.out.print(sub+" ");
                 
                 if( func(h, s, i+1))
                 return true;
             }
         }
         
         return false;
     }
	public static void main (String[] args)
	 {
	 //code
	    Scanner s = new Scanner(System.in);
	    int j=s.nextInt();
	    for(int i=0; i<j; i++){
	        int len=s.nextInt();
	        HashSet<String> h = new HashSet<>();
	        for(int z=0;z<len;z++){
	            h.add(s.next());
	        }
	        
	        String f=s.next();
	        
	        System.out.println(func(h, f, 0)==true?1:0);
	    }
	 }
}