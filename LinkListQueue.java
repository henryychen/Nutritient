
public class LinkListQueue {

    //instance variables
    Node head;
    int length;

    //Set default characteristics
    public LinkListQueue() {
        this.head = null;
        this.length = 0;
    }

    // initializing head
    public LinkListQueue(Node head) {
        this.head = head;
    }

    //find node at given index (p)
    public Node findNode(int p) {
        Node current = head;

        //loop until reaches index
        for (int i = 1; i < p; i++) {

            //go to next node until index is reached
            current = current.next;
        }
        //return the node at index
        return current;
    }

    //removes a node from queue
    public void remove(){
        //find node that is second last of the queue
        Node current = findNode(this.length-1);

        //make the next last node the last node
        current.next = null;

        //shorten length by one
        this.length--;
    }


    //adding nodes to Queue at head
    public void add(Node c){

        //add node infront of original head
        c.next = this.head;

        //added node is now first in queue
        this.head = c;

        //added one to length
        this.length++;

    }
}
