public class TestState {
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

    boolean resultsInMemory = false;
    int address = 0;
    byte value = 0;

    public TestState(int PC,int AC,int X,int Y,int SP)
    {
        this.PC=PC;
        this.AC=AC;
        this.X=X;
        this.Y=Y;
        this.SP=SP;

        Negative = false;
        Overflow = false;
        Break = false;
        Decimal = false;
        Interrupt = false;
        Zero = false;
        Carry = false;
    }
}
