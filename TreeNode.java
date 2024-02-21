class TreeNode{
    private String value;
    private TreeNode left;
    private TreeNode right;

    // public constructor for constructing a leaf
    public TreeNode(String value) {
        this.value = value;
    }

    // public constructor for constructing a tree node with left and right children
    public TreeNode(String value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // These are the get methods for each node
    public String getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    // These are the set methods for each node
    public void setValue(String value) {
        this.value = value;
    }
    

    public void setLeft(TreeNode left) {
        this.left = left;
    }
    

    public void setRight(TreeNode right) {
        this.right = right;
    }

    // This is a method to check if the node is a leaf 
    public boolean isLeaf() {
        if ((getLeft() == null && (getRight() == null))) {
            return true;
        }
        return false;
    }
}
