package operrinterview;

/**
 * Singly Linked List class
 */

public class LinkedList{
        // Keep pointers to both head and tail
        private Node head;
        private Node tail;
        
        // Construct an empty list
        public LinkedList(){
            this.head = null;
            this.tail = null;
        }
        
        // Append current element to the list
        public void append(int data){
            // If the list is empty, 
            if(this.head == null){
                this.head = new Node(data);
                this.tail = this.head;
                return;
            }
            
            // Create a new node for this data
            Node newNode = new Node(data);
            
            // Link the node to the current tail           
            this.tail.setNext(newNode);
            
            // Update what is now the tail
            this.tail = newNode;
        }
         
        // Remove the tail 
        public void removeTail(){
            // If the list is empty
            if(head==null) return;
            
            // If only 1 element
            if(head == tail){
                head = null;
                tail = null;
                return;
            }
            
            // Get the pointer to the element before tail
            Node pointer = head;
            while(pointer.getNext() != tail){
                pointer = pointer.getNext();
            }
            
            // Delete the target by having nothing pointing to it (let the JVM clean it)
             tail = pointer;
             tail.setNext(null);
        }
        
        // Remove all nodes with data that is greater than supplied target
        // Lets try doing this in O(n) time
        public void removeGreaterThan(int target){
            Node pointer = head, previous = null;
            
            // Edge case : The head has to be removed
            while(pointer != null && pointer.getData() > target){
                pointer = pointer.getNext();
            }
            
            // Edge case : all elements were removes
            if(pointer == null) {
                head = null;
                tail = null;
                return;
            }
            
            // We have the pointer to the new head. Now lets try removing the elements in place
            if(head != pointer) head = pointer;
            
            // Keep a track of the last element that was 'clean', since we can't look back
            // Transverse the list, looking for nodes to delete, outerloop is the 'i' index
            while(pointer != null){
                // look ahead in the singly list, until the next node not to remove is found. this is the 'j' index.
                // at i, lookahead until j. then i=i. repeat
                while(pointer != null && pointer.getData() <= target){
                        previous = pointer;
                        pointer = pointer.getNext();
                }
                // Edgecase, there was nothing to delete
                if(previous == null) return;
                
                // Delete the node that caused us to get out of the while loop, unless we are at the end
                if(pointer != null){
                    previous.setNext(pointer.getNext());
                    pointer = previous.getNext();
                }
            }
            // update the tail
            if(tail != previous) tail = previous;
        }
        
        // Testing purposes, print the list
        public void printList()
        {
            System.out.println("---------------");
            Node pointer = head;
            while (pointer != null)
            {
                 System.out.println(pointer.getData());
                pointer = pointer.getNext();
            }
            System.out.println("---------------");
        }

        // Object to define a 'node' in the singly linked list
        private class Node{
            private Node next;
            private int data;
            
            public Node(int data){
                next = null;
                this.data = data;
            }
            public int getData(){
                return this.data;
            }
            public void setData(int data){
                this.data = data;
            }
            public void setNext(Node next){
                this.next = next;
            }
            public Node getNext(){
                return this.next;
            }
        }
    }