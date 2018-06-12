package com.hsen.merkleTree;

/**
 * @ProjectName: hsen
 * @Package: com.hsen.utils
 * @Author: sen
 * @CreateDate: 2018/6/12 21:43
 * @Description: java类作用描述
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 **/
public class LeafBlock implements Block{

    String data;

    public LeafBlock(String data) {
        super();
        this.data = data;
    }

    @Override
    public String getHash() {
        return EncryHex.getSHA2Hex(data);
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return new StringBuilder("Hash: ").append(this.getHash()).append(" Data: ").append(this.data).toString();
    }

    public String getId() {
        return null;
    }
}
