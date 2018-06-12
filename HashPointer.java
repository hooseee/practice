package com.hsen.merkleTree;

/**
 * @ProjectName: hsen
 * @Package: com.hsen.utils
 * @Author: sen
 * @CreateDate: 2018/6/12 22:07
 * @Description: java类作用描述
 * @Version: 1.0
 * Copyright: Copyright (c) 2018
 **/
public class HashPointer {

    Block ref;
    String hash;


    @Override
    public String toString() {
        StringBuffer bf = new StringBuffer();
        bf.append("Hash: ").append(hash);
        return bf.toString();
    }
}
