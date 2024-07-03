package _02__Design_Principles._02__open_closed_principle;

import java.math.BigDecimal;

public class OperationMultiply implements Operation {

    @Override
    public BigDecimal perform(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

}