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
public class DLListNode {
    
    public MyBinaryTreeNode data;
    public DLListNode next;
    public DLListNode prev;
    
    public DLListNode(MyBinaryTreeNode d, DLListNode p, DLListNode n){
        
        data = d;
        prev = p;
        next = n;
    }
}
