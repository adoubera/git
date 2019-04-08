package Tree;

public class TestBinarySortTree {

    public static void main(String[] args) {

        int[] arr = new int[] { 7, 3, 10, 12, 5, 1, 9 };
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        // 中序遍历 遍历二叉排序树
        // 中序查看
        bst.midShow();

        // 查找节点
        Node n1 = bst.search(12);
        System.out.println("n1 result:" + n1.value);
        // 查找父节点
        Node n2 = bst.searchParent(3);
        System.out.println("3's parent is :" + n2.value);

        // 删除节点有两个子节点的书
        bst.delete(10);
        bst.midShow();
    }

}