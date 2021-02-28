package Deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Deque_a {

	public static void main(String[] args) {
		
		Deque<Integer> LinkedDeque  = new LinkedList<Integer>();
		Deque<Integer> ArrayDeque = new ArrayDeque<Integer>();
		
		// Add at the last 
		LinkedDeque.add(1); 
        // Add at the first 
		LinkedDeque.addFirst(2); 
        // Add at the last 
		LinkedDeque.addLast(3); 
        // Add at the first 
		LinkedDeque.push(4); 
        // Add at the last 
		LinkedDeque.offer(5); 
        // Add at the first 
		LinkedDeque.offerFirst(6); 
        System.out.println(LinkedDeque + "\n"); 
  
        LinkedDeque.removeFirst(); 
        LinkedDeque.removeLast(); 
        System.out.println(LinkedDeque); 
        
        
		ArrayDeque.add(1); 
		ArrayDeque.addFirst(2); 
		ArrayDeque.addLast(3); 
		System.out.println(ArrayDeque);
        System.out.println(ArrayDeque.pop()); 
        System.out.println(ArrayDeque.poll()); 
        System.out.println(ArrayDeque.pollFirst()); 
        System.out.println(ArrayDeque.pollLast());
	}

}
