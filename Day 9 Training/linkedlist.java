class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", next=" + next + "]";
    }

    // Method to add a node at the end
    public void addNode(int data) {
        Node end = new Node(data);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    // Method to delete a node by value
    public void deleteNode(int data) {
        Node n = this;
        if (n.data == data) {
            if (n.next != null) {
                n.data = n.next.data;
                n.next = n.next.next;
            } else {
                System.out.println("Can't delete the only node in the list");
            }
            return;
        }
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
        System.out.println("Node with data " + data + " not found");
    }

    // Method to update a node by value
    public void updateNode(int oldData, int newData) {
        Node n = this;
        while (n != null) {
            if (n.data == oldData) {
                n.data = newData;
                return;
            }
            n = n.next;
        }
        System.out.println("Node with data " + oldData + " not found");
    }
}

public class linkedlist {
    public static void main(String[] args) {
        Node head = new Node(20);
        head.addNode(23);
        head.addNode(45);

        // printing nodes
        Node mynode = head;
        while (mynode != null) {
            System.out.println(mynode.data);
            mynode = mynode.next;
        }

        // Add a new node
        head.addNode(30);
        System.out.println("After adding node with data 30:");
        mynode = head;
        while (mynode != null) {
            System.out.println(mynode.data);
            mynode = mynode.next;
        }

        // Delete a node
        head.deleteNode(23);
        System.out.println("After deleting node with data 23:");
        mynode = head;
        while (mynode != null) {
            System.out.println(mynode.data);
            mynode = mynode.next;
        }

        // Update a node
        head.updateNode(45, 50);
        System.out.println("After updating node with data 45 to 50:");
        mynode = head;
        while (mynode != null) {
            System.out.println(mynode.data);
            mynode = mynode.next;
        }
    }
}
