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
public class SLListNode {
    
    public MyBinaryTreeNode data;
    public SLListNode next;
    
    public SLListNode(MyBinaryTreeNode d, SLListNode n){
        data = d;
        next = n;
    }
}
