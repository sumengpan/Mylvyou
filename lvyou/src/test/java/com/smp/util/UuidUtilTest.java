package com.smp.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class UuidUtilTest {

    @Test
    public void getUuid() {
        for (int i = 0; i < 10; i++) {
            String code  = UuidUtil.getUuid();
            System.out.println(code);
        }

    }
}