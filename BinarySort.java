//U10416030 陳子勤

import java.security.SecureRandom;
import static java.lang.Math.abs;

public class BinarySort {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        Integer number[] = new Integer[20];
        int randomPlace;
        int hold;
        
        for(int i = 0; i < 20; i++) {
            number[i] = i + 1;
        }
        
        for(int i = 0;i<20;i++){
            randomPlace = abs(random.nextInt() )% 10;
            hold = number[randomPlace];
            number[randomPlace] = number[i];
            number[i] = hold;
        }
        
        BinaryTree binaryTree = new BinaryTree(number);
        
        System.out.print("Array at first: ");
        for(int i =0;i <20; i++) {
            System.out.print(number[i]+" ");
        }

        System.out.println("\n---------------------------------------------------------------");
        
        System.out.println(" Binary sort  : " + binaryTree.toString());
    }
}

class BinaryTree <E extends Comparable<E>> {
    TreeNode<E> node;
    int size=0;
    String print = "";
    
    public BinaryTree(){        
    }
    
    public BinaryTree(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            Number(objects[i]);
        }
    }
    
    public void Number(E e) {
        if (node == null) {
            node = new TreeNode(e);
        }
        else {
            TreeNode<E> first = null;
            TreeNode<E> Node = node;
            while (Node != null) {
            	if (e.compareTo(Node.element) > 0){
                    first = Node;
                    Node = Node.big;
                }
            	else if (e.compareTo(Node.element) < 0){
                    first = Node;
                    Node = Node.small;
                }
            }
            if (e.compareTo(first.element) < 0) {
                first.small = new TreeNode(e);
            }
            else {
                first.big = new TreeNode(e);
            }
        }
        size++;        
    }    
    
    public String toString() {
        numberInside(node);        
        return print;
    }
    
    public void numberInside(TreeNode<E> e){
        if (e != null) {
            numberInside(e.small);
            print = print + e.element + " ";            
            numberInside(e.big);
        }
    }
}

class TreeNode<E extends Comparable<E>> {
    E element;
    TreeNode<E> big;
    TreeNode<E> small;

    public TreeNode(E e){
        element = e;
    }
}
