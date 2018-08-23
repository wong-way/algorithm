package arrayList;

/**
 * Created by DELL on 2018-05-28.
 */
public class AList<T> {
    private int maxSize;
    private int listSize;
    private int cur;
    private Object[] arr;

    public AList(int maxSize) {
        this.maxSize = maxSize;
        arr = new Object[this.maxSize];
    }

    public void clear() {
        arr = null;
        listSize=0;
        arr = new Object[this.maxSize];
    }

    public T get() {
        return (T) arr[cur];
    }

    public void set(T value) {
        arr[cur] = value;
    }

    public void insert(T value) {
        assert listSize < maxSize : "List capacity exceeded";
        for (int i = listSize; i > cur; i--) {
            arr[i] = arr[i - 1];
        }
        arr[cur] = value;
        listSize++;
    }

    public T remove() {
        assert (cur >= 0) && (cur < listSize) : "List empty";
        T value = (T) arr[cur];
        for (int i = cur; i < listSize - 1; i++) {
            arr[i] = arr[i + 1];
        }
        listSize--;
        return value;
    }

    public void moveToStart() {
        cur = 0;
    }

    public void moveToEnd() {
        cur = listSize - 1;
    }

    public int size() {
        return listSize;
    }
    public int curPos(){
        return cur;
    }

    public void moveToPos(int pos) {
        assert pos < 0 && pos > listSize : "Pos out of range";
        cur=pos;
    }
    public void next(){
        if (cur < listSize ) {
            cur ++;
        }
    }

    public void prev() {
        if(cur>0) cur--;
    }
    public void append(T value){
        assert listSize < maxSize : "List capacity exceeded";
        arr[listSize++] = value;
    }
    public String toString(){
        String str = "[ ";
        for (Object o : arr) {
            if (o != null) {
                str += o + " ";
            }
        }
        str += "]";
        return str;
    }





}
