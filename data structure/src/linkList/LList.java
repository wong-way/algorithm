package linkList;

/**
 * Created by DELL on 2018-06-02.
 */
public class LList<T> {
    LinkNode head;
    LinkNode cur;
    LinkNode tail;
    int listSize;

    public LList() {
        head = new LinkNode();
        cur = head;
        tail = head;
        listSize = 0;
    }

    public void append(T value) {
        tail.next = new LinkNode<>(value);
        tail = tail.next;
        listSize++;

    }

    public void insert(T value) {
        cur.next = new LinkNode(value, cur.next);
        if (tail == cur) {
            tail = cur.next;
        }
        listSize++;
    }

    public T remove() {
        LinkNode curNode = cur.next;
        T value = (T) curNode.value;
        cur.next = curNode.next;
        curNode = null;
        listSize--;
        return value;
    }

    public T get() {
        return (T) cur.next.value;
    }

    public int size() {
        return listSize;
    }

    public void moveToStart() {
        cur = head;
    }

    public void moveToEnd() {
        cur = tail;
    }

    public void next() {
        cur = cur.next;
    }

    public void prev() {
        if (cur == head) return;
        LinkNode temp = head;
        while (temp.next != cur) {
            temp = temp.next;
        }
        cur = temp;
    }

    public int curPos() {
        LinkNode temp = head;
        int i = 0;
        while (temp != cur) {
            temp=temp.next;
            i++;
        }
        return i;
    }

    public void moveToPos(int pos) {
        int i = 1;
        cur = head;
        while (i < pos) {
            cur = cur.next;
            i++;
        }
    }
    public void clear(){
        while(head!=null){
            LinkNode temp = head;
            head = head.next;
            temp = null;
        }
    }
    public String toString(){
        String str ="";
        LinkNode temp = head.next;

        str+="{";
        while(temp.next!=null){
            str+=temp.value+", ";
            temp = temp.next;
        }
        str+=temp.value;
        str+="}";
        return str;
    }


}
