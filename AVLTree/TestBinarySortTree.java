package AVLTree;

public class TestBinarySortTree {

    public static void main(String[] args) {

        // int[] arr = new int[] { 8, 9, 6, 7, 5, 4 };
        int[] arr = new int[] { 8, 9, 5, 4, 6, 7 };
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        // 查看高度
        System.out.println(bst.root.height());
        System.out.println(bst.root.value);
    }

}