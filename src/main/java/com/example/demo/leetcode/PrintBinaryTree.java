package com.example.demo.leetcode;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuj42 on 8/8/2017.
 */

public class PrintBinaryTree {


    public static TreeNode initTree() {
        TreeNode tree = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode llr = new TreeNode(5);

        tree.left = left;
        tree.right = right;
        tree.left.left = ll;
        tree.left.left.right = llr;
        return tree;
    }

    public static List<List<String>> initConvertedTree(int height, int width){
        List<List<String>> convertedTree = new ArrayList<>();
        for(int i=0; i<height; i++){
            String[] row = new String[width];
            Arrays.fill(row,"*");
            convertedTree.add(Arrays.asList(row));
        }
        return convertedTree;
    }


    public static void print(List<List<String>> convertedTree){
        for(List<String> l : convertedTree){
            for(String s: l){
                System.out.print(s);
            }
            System.out.print("\n");
        }
    }

    public int getHeight(TreeNode tree){
        if(tree == null){
            return 0;
        }

        return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
    }

    public void fill(TreeNode root, List<List<String>> convertedTree, int row, int left, int right){
        if (root == null)
            return;
        convertedTree.get(row).set((left+right)/2,"" + root.val);
        fill(root.left, convertedTree, row + 1, left, (left + right) / 2);
        fill(root.right, convertedTree,  row + 1, (left + right + 1) / 2, right);
    }

    public static void main(String [] args){

        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        TreeNode tree = initTree();

        int height = printBinaryTree.getHeight(tree);
        int width = (1 << height) -1;
        System.out.println("height:"+height);
        System.out.println("width:"+width);

        List<List<String>> convertedTree = initConvertedTree(height, width);

        printBinaryTree.fill(tree, convertedTree, 0, 0 , width);
        print(convertedTree);
    }



}
