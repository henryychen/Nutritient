
public class Node {
    Object cargo;
    Node next;
    public Node(Object c, Node n) {
        this.cargo=c;
        this.next=n;
    }

    public Node(){
        cargo = null;
        next=null;
    }

    public String toString(){
        return cargo + "";
    }
}

