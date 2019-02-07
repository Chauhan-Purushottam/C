/* Sorting the stack using a temporary stack 
###########################################
Input:
2
3
3 2 1
5
11 2 32 3 41

Output:
3 2 1
41 32 11 3 2
###############################################*/
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			sortingStack st=new sortingStack();
			Stack<Integer> a=st.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}

class sortingStack{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		Stack<Integer> tmpStack = new Stack<Integer>();
		 while(!s.isEmpty()) {
            int tmp = s.pop();
            
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                s.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        
        }
        return tmpStack;
		
	}
}