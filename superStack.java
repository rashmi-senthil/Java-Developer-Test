import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class superStack {
	static void superStackImpl(String[] operations) {
        if (operations == null || operations.length == 0) {
            System.out.println("EMPTY");
            return;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (String op : operations) {
            if (op.equalsIgnoreCase("pop")) {
                stack.removeLast();
            } else if (op.startsWith("push")) {
                    stack.addLast(Integer.parseInt(op.split(" ")[1]));
            } else {
                    int e = Integer.parseInt(op.split(" ")[1]);
                    int k = Integer.parseInt(op.split(" ")[2]);
                    ListIterator<Integer> itr = stack.listIterator();
                    int j = 1;
                    while (itr.hasNext()) {
                        if (j > e)
                            break;
                        itr.set(itr.next() + k);
                        j++;
                  }
             }
            if (stack.isEmpty())
                System.out.println("EMPTY");
            else
                System.out.println(stack.getLast());
        }
    }
	
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
	    int a=Integer.parseInt(in.nextLine());
	    String op[]=new String[a];
	    for(int i=0;i<a;i++){
	      op[i]=in.nextLine();
	    }
	    superStackImpl(op); 
	}
}
