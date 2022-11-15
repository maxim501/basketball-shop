package com.am.basketballshop.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VendorCodeGenerator {

    private static final Integer min = 10000000;
    private static final Integer max = 99999999;

    public String generateVendorCode() {
        int num = (int) ((Math.random() * (max - min)) + min);
        return Integer.toString(num);
    }
}
