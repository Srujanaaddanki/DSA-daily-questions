public class ReverseLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to reverse linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next; // store next
            curr.next = prev;          // reverse link
            prev = curr;               // move prev
            curr = nextNode;           // move curr
        }
        return prev; // new head
    }

    // Method to print linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list: 10 -> 20 -> 30 -> null
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.print("Original List: ");
        printList(head);

        head = reverse(head);

        System.out.print("Reversed List: ");
        printList(head);
    }
}

