package com.hsen.merkleTree;

/**
 * @ProjectName: hsen
 * @Package: com.hsen.utils
 * @Author: sen
 * @CreateDate: 2018/6/12 22:09
 * @Description: java类作用描述
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 **/
public class NoneLeafBlock implements Block {
    private HashPointer left;

    /**
     * @return the left
     */
    public HashPointer getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public HashPointer getRight() {
        return right;
    }

    private HashPointer right;
    private String hash;
    private String data;

    public NoneLeafBlock(HashPointer left, HashPointer right) {
        super();
        this.left = left;
        this.right = right;
        this.data = new StringBuffer().append(left.hash).append(right.hash).toString();
        this.hash = EncryHex.getSHA2Hex(data);
    }

    public String getHash() {
        return hash;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append("Hash: ").append(hash).append(System.getProperty("line.separator")).append("LeftChild:").append(left)
                .append(System.getProperty("line.separator")).append("RightChild:").append(right);
        return bf.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.zhaohuabing.merkletree.Block#getData()
     */
    public String getData() {
        return data;
    }
}
