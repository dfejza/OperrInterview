/*
    Interview question for Operr Technologies
    Created by Dardan Fejza
    Implement a Linked list with the following functionality:
        1. Append an element into the linkedlist
        2. Remove the tail element from a linkedlist
        3. Remove all element in the linkedlist that is great than a target value
 */
package operrinterview;

public class OperrInterview {

    // Run some cases on the linked list. Would be better to create unit tests...
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.removeTail();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(8);
        linkedList.printList(); // 1 2 3 4 5 6 7 8
        linkedList.removeTail();
        linkedList.printList(); // 1 2 3 4 5 6 7
        linkedList.append(8);
        linkedList.append(1);
        linkedList.printList(); // 1 2 3 4 5 6 7 8 1
        linkedList.removeGreaterThan(2);
        linkedList.printList(); // 1 2 1
    }
    
}
