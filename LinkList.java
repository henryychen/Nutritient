
public class LinkList {
    Node head;
    int length;

    public LinkList(Node n, int l){
        head = n;
        length = l;
    }

    public void add(Object c){
        Node current = findNode(0);
        Node temp = new Node(c,current);
        this.head=temp;
        this.length++;
    }

    public void remove(){
        Node current = findNode(0);
        head=current.next;
        this.length--;
    }

    public Node findNode(int p){
        Node current = head;
        for(int i = 1;i<p;i++){
            current=current.next;
        }
        return current;
    }


    public String toString(){
        String list = "";
        Node temp = head;
        for(int i = 0;i<length;i++){
            list+= temp.toString();
            temp=temp.next;
        }
        return list;
    }


}
