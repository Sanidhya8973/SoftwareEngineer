package _02__Design_Principles._02__open_closed_principle;

import java.math.BigDecimal;

public class GoodCalculator {

    public BigDecimal calculate(BigDecimal a, BigDecimal b, Operation operation) {
        return operation.perform(a, b);
    }

}
