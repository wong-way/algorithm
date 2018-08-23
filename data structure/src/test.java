import arrayList.AList;
import linkList.LList;

/**
 * Created by DELL on 2018-05-29.
 */
public class test {
    public static void main(String[] args) {
        // array list
//        AList list = new AList(10);
//        list.append("first");
//        list.append("second");
//        list.append("third");
//        list.append("fourth");
//        list.append("fifth");
//        list.append("first");
//        list.append("second");
//        list.append("third");
//        list.append("fourth");
//        list.append("fifth");
//        list.append("s");
//        System.out.println(list.toString());
        //link list
        LList<Integer> lList = new LList();
        lList.append(1);
        lList.append(2);
        lList.moveToStart();
        lList.insert(3);
        lList.moveToEnd();
        System.out.println(lList.curPos());
        System.out.println(lList.toString());
        lList.moveToPos(2);
        lList.insert(4);
        System.out.println(lList.toString());

    }

}
