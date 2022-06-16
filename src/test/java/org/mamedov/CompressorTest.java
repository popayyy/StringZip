package org.mamedov;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

class CompressorTest {

    public final static String NORMAL_STR = "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
    public final static String COMPRESS_STR = "A\u0005N\u0003M\u0004Y\u0004u\u0004U\u0004a\u0004r\u0001W\u0002L\u0004J\u00018\u0003D\u0009";

    @org.junit.jupiter.api.Test
    void compress() {

        String compressStrAct = Compressor.compress(NORMAL_STR);

        Assertions.assertEquals(COMPRESS_STR, compressStrAct);
        Assertions.assertTrue(compressStrAct.length() < NORMAL_STR.length());
    }

    @org.junit.jupiter.api.Test
    void deCompress() {

        String normalStrAct = Compressor.deCompress(COMPRESS_STR);

        Assertions.assertEquals(NORMAL_STR, normalStrAct);

    }
}
