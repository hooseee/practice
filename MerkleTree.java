package com.hsen.merkleTree;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: hsen
 * @Package: com.hsen.utils
 * @ClassName: MerkleTrees
 * @Author: sen
 * @CreateDate: 2018/6/12 21:24
 * @Description: java类作用描述
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 **/
public class MerkleTree {

    Block root;

    public Block getRoot() {
        return root;
    }

    public MerkleTree(List<String> data) {

        List<Block> thisLevel = buildLeaves(data);

        while (thisLevel.size() > 1) {
            thisLevel = buildUpperLevel(thisLevel);
        }

        root = thisLevel.get(0);
    }



    /**
     * Create a leaf the same as the last one and append it to list if the number is odd
     */
    private void fixOddNumberLeaf(List<String> leaves) {
        if (leaves.size() % 2 == 1) {
            leaves.add(leaves.get(leaves.size() - 1));
        }
    }

    /**
     * Create a block the same as the last one and append it to list if the number is odd
     */
    private void fixOddNumberBlock(List<Block> blocks) {
        if (blocks.size() % 2 == 1) {
            blocks.add(blocks.get(blocks.size() - 1));
        }
    }

    /**
     * @param block
     * @return
     */
    private HashPointer createHashPointer(Block block) {
        HashPointer pointer = new HashPointer();
        pointer.ref = block;
        pointer.hash = block.getHash();
        return pointer;
    }


    public List<Block> buildLeaves(List<String> data) {
        data.sort(Collator.getInstance());
        fixOddNumberLeaf(data);
        
        List<Block> leaves = new ArrayList<Block>();
        for (int i = 0; i < data.size(); i++) {
            leaves.add(new LeafBlock(data.get(i)));
        }
        return leaves;
    }

    public List<Block> buildUpperLevel(List<Block> lowerLevel) {
        fixOddNumberBlock(lowerLevel);

        List<Block> upperLevel = new ArrayList<Block>();

        int index = 0;

        while (index < lowerLevel.size()) {
            HashPointer leftPointer = createHashPointer(lowerLevel.get(index));
            HashPointer rightPointer = createHashPointer(lowerLevel.get(++ index));
            NoneLeafBlock upperBlock = new NoneLeafBlock(leftPointer, rightPointer);
            upperLevel.add(upperBlock);

            index ++;
        }
        return upperLevel;
    }

    public List<String> getLevels() {
        List<String> result = new ArrayList<String>();
        if(root instanceof LeafBlock) {
            result.add(((LeafBlock) root).getData());
            return result;
        }

        traverse(result, root);
        return result;
    }


    public void traverse(List<String> result, Block block) {
        if (block instanceof LeafBlock) {
            result.add(((LeafBlock) block).getData());
            return;
        }
        traverse(result, ((NoneLeafBlock) block).getLeft().ref);
        traverse(result, ((NoneLeafBlock) block).getRight().ref);
    }


    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        data.add("block 0");
        data.add("block 1");
        data.add("block 32");
        data.add("block 3");
        data.add("block 4");
        data.add("block 5");
        MerkleTree merkleTree = new MerkleTree(data);
        System.out.println(merkleTree.getRoot());


        List<String> leaves = merkleTree.getLevels();
        for (int i = 0; i < leaves.size(); i++) {
            System.out.println(leaves.get(i));
        }
    }


}
