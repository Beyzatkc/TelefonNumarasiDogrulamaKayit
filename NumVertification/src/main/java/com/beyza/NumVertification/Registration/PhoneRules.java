package com.beyza.NumVertification.Registration;

public class PhoneRules {
    private boolean hasNonZeroDigit;
    private boolean sumFirstEqualsLast;
    private boolean sumOddEqualsEven;

    public PhoneRules() {}
    public PhoneRules(boolean hasNonZeroDigit, boolean sumFirstEqualsLast, boolean sumOddEqualsEven) {
        this.hasNonZeroDigit = hasNonZeroDigit;
        this.sumFirstEqualsLast = sumFirstEqualsLast;
        this.sumOddEqualsEven = sumOddEqualsEven;
    }

    public boolean isHasNonZeroDigit() {
        return hasNonZeroDigit;
    }

    public void setHasNonZeroDigit(boolean hasNonZeroDigit) {
        this.hasNonZeroDigit = hasNonZeroDigit;
    }

    public boolean isSumFirstEqualsLast() {
        return sumFirstEqualsLast;
    }

    public void setSumFirstEqualsLast(boolean sumFirstEqualsLast) {
        this.sumFirstEqualsLast = sumFirstEqualsLast;
    }

    public boolean isSumOddEqualsEven() {
        return sumOddEqualsEven;
    }

    public void setSumOddEqualsEven(boolean sumOddEqualsEven) {
        this.sumOddEqualsEven = sumOddEqualsEven;
    }
}
