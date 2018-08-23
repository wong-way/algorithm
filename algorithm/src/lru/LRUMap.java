public class LRUMap<K, V> {
    //当前缓存的节点数
    private int currentSize;
    //最多缓存的节点数
    private int maxSize;
    //头节点
    private Node<K, V> header;
    //尾节点
    private Node<K, V> tailer;


    public LRUMap(int size) {
        header = new Node<>();
        tailer = header;
        this.maxSize = size;
        this.currentSize = 0;

    }

    public void put(K key, V value) {
        if (currentSize < maxSize) {
            currentSize++;
            Node<K, V> newNode = new Node<>(key, value);
            tailer.next = newNode;
            tailer = newNode;
        } else {
            //替换节点
            System.out.println("替换:" + header.next.getValue());
            header = header.next;
            tailer.next = new Node<>(key, value);
            tailer = tailer.next;
        }
    }

    public Node<K, V> get(K key) throws Exception {
        Node<K, V> node = getNode(key);
        if (node != null) {
            moveToTail(node);
        } else {
            throw new Exception("没有键值为：" + key + "的缓存节点");
        }
        return node;
    }

    private void moveToTail(Node<K, V> node) {

        Node<K, V> steper = header;
        Node<K, V> prev = header;
        while (steper.next != null) {
            if (steper.next.getKey() == node.getKey()) {
                prev.next = steper.next.next;
            } else {
                prev = prev.next;
            }
            steper = steper.next;
        }
        steper.next = node;
        tailer = node;
        tailer.next = null;

    }

    /**
     * 得到键为key的节点
     *
     * @param key 键值
     * @return 如果存在则返回节点，如果不存在则返回null
     */
    private Node<K, V> getNode(K key) {

        Node<K, V> node = header.next;
        while (node != tailer) {
            if (node.getKey() == key) break;
            node = node.next;
        }
        if (node == tailer) {
            return null;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K, V> node = header.next;
        while (node != null) {
            sb.append(node.getKey()).append(":")
                    .append(node.getValue())
                    .append("-->");

            node = node.next;
        }

        return sb.toString();

    }

    public void useChache(K k, V v) {
        try {
            //缓存命中
            get(k);
            System.out.println("缓存命中");
        } catch (Exception e) {
            //缓存未命中
            System.out.println("缓存未命中");

            put(k, v);
        }
    }
    public static void main(String[] args) {
        LRUMap<Integer, String> map = new LRUMap<>(4);
        map.useChache(4, "cache4");
        map.useChache(3, "cache3");
        map.useChache(4, "cache4");
        map.useChache(1, "cache1");
        map.useChache(5, "cache5");
        map.useChache(2, "cache2");
        map.useChache(4, "cache4");
        map.useChache(1, "cache1");
        map.useChache(2, "cache2");
        map.useChache(6, "cache6");
        System.out.println(map.toString());

    }
}
