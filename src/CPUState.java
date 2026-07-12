public class CPUState {
    int PC;
    int AC;
    int X,Y;
    //byte SR;//Status register
    int SP;//Stack pointer

    boolean Negative;
    boolean Overflow;
    boolean Break;
    boolean Decimal;
    boolean Interrupt;
    boolean Zero;
    boolean Carry;

    int clock;
    public CPUState(AddressBus addressBus)
    {

        PC = (addressBus.readByte(0xfffd)<<8) | addressBus.readByte(0xfffc);
        AC = 0;
        X = 0;
        Y = 0;
        //SR = 0;
        SP = 0;
        clock = 0;
    }
    public void setCPUStateBasedOnTestState(TestState testState)
    {
        PC = testState.PC;;
        AC = testState.AC;
        X = testState.X;
        Y = testState.Y;
        SP = testState.SP;
        Negative = testState.Negative;
        Overflow = testState.Overflow;
        Break = testState.Break;
        Decimal = testState.Decimal;
    }
    public boolean doesStateMatchTestState(TestState testState)
    {
        boolean equal = true;
        if(testState.PC!=PC)equal=false;
        if(testState.AC!=AC)equal=false;
        if(testState.X!=X)equal=false;
        if(testState.Y!=Y)equal=false;
        if(testState.SP!=SP)equal=false;
        if(testState.Negative!=Negative)equal=false;
        if(testState.Overflow!=Overflow)equal=false;
        if(testState.Break!=Break)equal=false;
        if(testState.Decimal!=Decimal)equal=false;
        if(testState.Interrupt!=Interrupt)equal=false;
        if(testState.Zero!=Zero)equal=false;
        if(testState.Carry!=Carry)equal=false;
        return equal;
    }
    public void setNegative(boolean arg)
    {
        Negative=arg;
    }
    public void setOverflow(boolean arg)
    {
        Overflow=true;
    }
    public void setBreak(boolean arg)
    {
        Break=arg;
    }
    public void setDecimal(boolean arg)
    {
        Decimal=arg;
    }
    public void setInterrupt(boolean arg)
    {
        Interrupt=arg;
    }
    public void setZero(boolean arg)
    {
        Zero=arg;
    }
    public void setCarry(boolean arg)
    {
        Carry=arg;
    }

    public boolean isNegative()
    {
        return Negative;
    }
    public boolean isOverflow()
    {
        return Overflow;
    }
    public boolean isBreak()
    {
        return Break;
    }
    public boolean isDecimal()
    {
        return Decimal;
    }
    public boolean isInterrupt()
    {
        return Interrupt;
    }
    public boolean isZero()
    {
        return Zero;
    }
    public boolean isCarry()
    {
        return Carry;
    }

}
