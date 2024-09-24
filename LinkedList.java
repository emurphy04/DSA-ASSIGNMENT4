package Assignment_4;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    //Create a linked List
    public Node createLinkedList(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if (head == null){
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = node;
            node.next = nextNode;
        }
        size++;

    }
    //Traverse a Linked List
    public void traverseLinkedList(){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i !=size -1 ){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    //Search for a Node
    public boolean searchNode(int nodeValue) {
        if (head != null){
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                if (tempNode.value == nodeValue){
                    System.out.print(" Found the node: " + tempNode.value + " at location: " + i + "\n");
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println(" Node not found");
        return false;
    }

    public void deleteNode(int nodeValue) {
        if (head == null) {
            System.out.println("The linked list does not exist.");
            return;
        }
    
        if (head.value == nodeValue) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            System.out.println("Node with value " + nodeValue + " deleted.");
            return;
        }
    
        Node tempNode = head;
        Node prevNode = null;
        
        while (tempNode != null && tempNode.value != nodeValue) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }
    
        if (tempNode == null) {
            System.out.println("Node with value " + nodeValue + " not found.");
            return;
        }
    
        if (tempNode == tail) {
            tail = prevNode;
            tail.next = null;
        } else {
            prevNode.next = tempNode.next;
        }
    
        size--;
        System.out.println("Node with value " + nodeValue + " deleted.");
    }
    
}
