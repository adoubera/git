package AVLTree;

public class BinarySortTree {
    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);

        }

    }

    // ok?
    // 中序遍历
    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
    }

    // 节点查找
    public Node search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    // 删除节点
    public void delete(int val) {
        if (root == null) {
            return;
        } else {
            // 找到这个结点
            Node target = search(val);
            if (target == null) {
                return;
            }
            // 找到其父节点
            Node parent = searchParent(val);
            // 1.删除节点为叶子结点(后面没有节点了)
            if (target.left == null && target.right == null) {
                // 删除的是父节点的左节点
                if (parent.left.value == val) {
                    parent.left = null;
                } else {// 删除的是父节点的右节点
                    parent.right = null;
                }
            }

            // 2. 要删除的结点有两个结点
            else if (target.left != null && target.right != null) {
                // 删除右子树中最小的结点。获取其值替换到要删除的结点上
                int min = deleteMin(target.right);
                // 替换，目标结点中的值
                target.value = min;

            }
            // 3. 删除只有一个叶子结点的结点,左或右
            else {
                // 有左子节点
                if (target.left != null) {
                    if (parent.left.value == val) {
                        parent.left = target.left;
                    } else {// 删除的是父节点的右节点
                        parent.right = target.left;
                    }
                } // 有右子节点
                else {
                    if (parent.left.value == val) {
                        parent.left = target.right;
                    } else {// 删除的是父节点的右节点
                        parent.right = target.right;
                    }

                }
            }
        }
    }

    // 删除当前树中的最小节点
    public int deleteMin(Node node) {
        Node target = node;
        // 找到最小左节点
        while (target.left != null) {
            target = target.left;
        }
        int val = target.value;
        delete(target.value);// delete中已经考虑到了当前节点有子节点的情况，当前节点不可能有右子节点
        return val;
    }

    // 找到其父节点
    public Node searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);

        }
    }

}