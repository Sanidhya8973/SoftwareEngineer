package _02__Design_Principles._02__open_closed_principle;

import java.math.BigDecimal;

public interface Operation {

    public abstract BigDecimal perform(BigDecimal a, BigDecimal b);

}
