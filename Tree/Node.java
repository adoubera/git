package Tree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判读当前值得大小是往左子节点放还是右边放
        if (node.value < this.value) {
            // 如果左节点为空
            if (this.left == null) {
                this.left = node;
            } // 不为空则递归添加
            else {
                this.left.add(node);
            }

        } else {
            // 如果右边节点为空
            if (this.right == null) {
                this.right = node;
            } // 不为空则递归添加
            else {
                this.right.add(node);
            }

        }

    }

    // 中序遍历 正好从小到大
    public void midShow(Node node) {
        if (node == null) {
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    // 查找节点
    public Node search(int val) {

        if (this.value == val) {
            return this;
        } else if (val < this.value) {
            if (left == null) {
                return null;
            }
            return left.search(val);

        } else {
            if (right == null) {
                return null;
            }
            return right.search(val);
        }

    }

    // 查找父节点
    public Node searchParent(int val) {

        if ((this.left != null && this.left.value == val) || (this.right != null && this.right.value == val)) {
            return this;
        } else {
            if (this.value > val && this.left != null) {

                return this.left.searchParent(val);
            } else if (this.value < val && this.right != null) {

                return this.right.searchParent(val);
            }
            return null;
        }
    }

}