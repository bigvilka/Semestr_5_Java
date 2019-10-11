package com.Matveev.hash;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.FileInputStream;
import java.io.IOException;

public class CountHash {

    String fileName;

    public CountHash(String str) {

        this.fileName = str;
    }

    String countMd5() throws IOException {

        return DigestUtils.md5Hex(new FileInputStream(fileName));
    }

    String countSha256() throws IOException {

        return DigestUtils.sha256Hex(new FileInputStream(fileName));
    }
}
