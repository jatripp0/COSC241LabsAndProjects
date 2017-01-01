/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyBinarySearchTree extends MyBinaryTree{
    
    public MyBinarySearchTree(){
        root = null;
    }
    
    public void insert (Object newItem){
        root = insertHelper(root, new MyBinaryTreeNode(newItem));
    }
    
    private MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode){
        if(rt == null){
            rt = newNode;
            return rt;
        }
        if(newNode.compareTo(rt) < 0){
            rt.left = insertHelper(rt.left, newNode);
        } else {
            rt.right = insertHelper(rt.right, newNode);
        }
        return rt;
    }
    
    public Object max(){
        if(root == null) return null;
        return maxHelper(root).data;
    }
    
    private MyBinaryTreeNode maxHelper(MyBinaryTreeNode rt){
        return rt.right == null ? rt : maxHelper(rt.right);
    }
    
    public Object min(){
        if(root == null) return null;
        return minHelper(root).data;
    }
    
    private MyBinaryTreeNode minHelper(MyBinaryTreeNode rt){
        return rt.left == null ? rt : minHelper(rt.left);
    }
    
    public MyBinaryTreeNode find(Object target){
        return findHelper(root, new MyBinaryTreeNode(target));
    }
    
    private MyBinaryTreeNode findHelper(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode){
        if(rt == null) return null;
        if(targetNode.compareTo(rt) < 0) return findHelper(rt.left, targetNode);
        if(targetNode.compareTo(rt) > 0) return findHelper(rt.right, targetNode);
        return rt;
    }
    
    private MyBinaryTreeNode findParent(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode){
        if(targetNode.compareTo(rt) < 0){
            if(rt.left == null)
                return null;
            else if(targetNode.compareTo(rt.left) == 0)
                return rt;
            else
                return findParent(rt.left, targetNode);
        }
        else{
            if(rt.right == null)
                return null;
            else if(targetNode.compareTo(rt.right) == 0)
                return rt;
            else
                return findParent(rt.right, targetNode);
        }
    }
    
    private MyBinaryTreeNode successorParent(MyBinaryTreeNode rt){
        if(rt == null) return null;
        if(rt.right == null) return null;
        if(rt.right.left == null){
            return rt;
        }
        MyBinaryTreeNode temp = rt.right;
        while(temp.left.left != null){
            temp = temp.left;
        }
        return temp;
    }
    
    public void remove(Object target){
        if(root == null) return;                                    //Return if there is no root
        MyBinaryTreeNode targetNode = new MyBinaryTreeNode(target); //Create a target node
        if(targetNode.compareTo(root) == 0){                        //If the target node is the root
            MyBinaryTreeNode sp1 = successorParent(root);           //Get the successor parent from the root
            if(sp1 == null){ //root has no right child              //If no successor parent, there is no right child
                root = root.left;                                   //If no right child, move the left child of the root up
            }
            else if(sp1 == root){                                   //If the successor parent is the root itself...
                root.right.left = root.left;                        //Move successor child to the root left child
                root = root.right;                                  //Move the successor to the root
            }
            else{                                                   //Otherwise...
                MyBinaryTreeNode rightChOfSucc = sp1.left.right;    //Get right child of successor
                sp1.left.left = root.left;                          //Move left child of successor to the left of root
                sp1.left.right = root.right;                        //Move right child of successor to the right of root
                root = sp1.left;                                    //Move left of successor parent to root
                sp1.left = rightChOfSucc;                           //Move right child of successor to left of successor parent
            }
        }
        MyBinaryTreeNode targetParent = findParent(root, targetNode); //Find parent of the target
        if(targetParent == null) return;                            //If the target parent is null, return
        if(targetParent.left != null){                              //Assuming target parent is not null...
            if(targetParent.left.compareTo(targetNode) == 0){       //If the left child of the target parent is the target
                MyBinaryTreeNode rNode = targetParent.left;         //Create reference for node to be removed
                MyBinaryTreeNode sp2 = successorParent(rNode);      //Get successor parent of the node to be removed
                if(rNode.left == null && rNode.right == null){      //If that node has no children
                    targetParent.left = null;                       //Set the node to null (removes the node)
                }
                else if(sp2 == null){                               //Target parent has no right child
                    targetParent.left = rNode.left;                 //Place target's left child on target parent's left child
                }
                else if(sp2 == rNode){                              //Right child is the successor
                    sp2.right.left = rNode.left;
                    targetParent.left = rNode.right;
                } else {
                    MyBinaryTreeNode rightChOfSucc = sp2.left.right;
                    sp2.left.left = rNode.left;
                    sp2.left.right = rNode.right;
                    targetParent.left = sp2.left;
                    sp2.left = rightChOfSucc;
                }
                return;
            }
        }
        if(targetParent.right != null){
            if(targetParent.right.compareTo(targetNode) == 0){
                MyBinaryTreeNode rNode = targetParent.right;
                MyBinaryTreeNode sp3 = successorParent(rNode);
                if(rNode.left == null && rNode.right == null){
                    targetParent.right = null;
                }
                else if(sp3 == null){ //target node has no right child
                    targetParent.right = rNode.left;
                }
                else if(sp3 == rNode){
                    sp3.right.left = rNode.left;
                    targetParent.right = rNode.right;
                } else {
                    MyBinaryTreeNode rightChildOfSucc = sp3.left.right;
                    sp3.left.left = rNode.left;
                    sp3.left.right = rNode.right;
                    targetParent.right = sp3.left;
                    sp3.left = rightChildOfSucc;
                }
            }
        }
    }
}
