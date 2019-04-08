package AVLTree;

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
        // 查询是否平衡
        // 左边比右边高,右旋转
        if (leftHeight() - rightHeight() >= 2) {
            // 双旋转
            if (left != null && left.leftHeight() < left.rightHeight()) {
                System.out.println("双旋转");
                // 先左子节点左旋转
                left.leftRotate();
                // 整体右旋转
                rightRotate();
            } else {// 单旋转
                rightRotate();
            }
        }
        if (leftHeight() - rightHeight() <= -2) {// 右边比左边高,左旋转
            // 双旋转
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                // 单旋转
                leftRotate();
            }
        }
    }

    private void leftRotate() {
        // 左旋转
        Node newLeft = new Node(value);
        newLeft.left = left;
        newLeft.right = right.left;
        value = right.value;
        right = right.right;
        left = newLeft;
    }

    private void rightRotate() {
        // 1.创建一个新节点,值等于当前节点的值
        Node newRight = new Node(value);
        // 2.把新节点的右子树设置为当前节点的右子树
        newRight.right = right;
        // 3.把新节点的左子树设置为当前节点的左子树的右子树
        newRight.left = left.right;
        // 4.把当前节点的值换成左子节点的值
        value = left.value;
        // 5.把当前节点的左子树设置为左子树的左子树
        left = left.left;
        // 6.把但前节点的右子树设置为新节点
        right = newRight;
    }

    // 返回当前节点的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    // 获取左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    // 获取右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
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