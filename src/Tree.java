class Tree {
    Integer data;
    Tree left;
    Tree right;

    Tree() {
    }

    Tree(Integer data) {
        this.data = data;
    }

    Tree(Integer data, Tree left, Tree right) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}