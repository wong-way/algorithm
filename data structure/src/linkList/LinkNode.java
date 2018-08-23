package linkList;

/**
 * Created by DELL on 2018-06-02.
 */
public class  LinkNode<T> {
    public T value;
    public LinkNode next;

    public LinkNode(T value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public LinkNode(T value) {
        this.value = value;
        this.next = null;
    }

    public LinkNode() {
    }


}
