public class InstructionUnit {
    public static final int OPCODE_ADD = 1;
    public static final int OPCODE_AND_WITH_ACCUMULATOR = 2;
    public static final int OPCODE_ARITHMETIC_SHIFT_LEFT = 3;
    public static final int OPCODE_BRANCH_ON_CARRY_CLEAR = 4;
    public static final int OPCODE_BRANCH_ON_CARRY_SET = 5;
    public static final int OPCODE_BRANCH_ON_EQUAL = 6;
    public static final int OPCODE_BIT_TEST = 7;
    public static final int OPCODE_BRANCH_ON_MINUS = 8;
    public static final int OPCODE_BRANCH_ON_NOT_EQUAL = 9;
    public static final int OPCODE_BRANCH_ON_PLUS = 10;
    public static final int OPCODE_BREAK = 11;
    public static final int OPCODE_BRANCH_ON_OVERFLOW_CLEAR = 12;
    public static final int OPCODE_BRANCH_ON_OVERFLOW_SET = 13;
    public static final int OPCODE_CLEAR_CARRY = 14;
    public static final int OPCODE_CLEAR_DECIMAL = 15;
    public static final int OPCODE_CLEAR_INTERRUPT_DISABLE = 16;
    public static final int OPCODE_CLEAR_OVERFLOW = 17;
    public static final int OPCODE_COMPARE_WITH_ACCUMULATOR = 18;
    public static final int OPCODE_COMPARE_WITH_X = 19;
    public static final int OPCODE_COMPARE_WITH_Y = 20;
    public static final int OPCODE_DECREMENT = 21;
    public static final int OPCODE_DECREMENT_X = 22;
    public static final int OPCODE_DECREMENT_Y = 23;
    public static final int OPCODE_EOR_WITH_ACCUMULATOR = 24;
    public static final int OPCODE_INCREMENT = 25;
    public static final int OPCODE_INCREMENT_X = 26;
    public static final int OPCODE_INCREMENT_Y = 27;
    public static final int OPCODE_JUMP = 28;
    public static final int OPCODE_JUMP_SUBROUTINE = 29;
    public static final int OPCODE_LOAD_ACCUMULATOR = 30;
    public static final int OPCODE_LOAD_X = 31;
    public static final int OPCODE_LOAD_Y = 32;
    public static final int OPCODE_LOGICAL_SHIFT_RIGHT = 33;
    public static final int OPCODE_NO_OPERATION = 34;
    public static final int OPCODE_OR_WITH_ACCUMULATOR = 35;
    public static final int OPCODE_PUSH_ACCUMULATOR = 36;
    public static final int OPCODE_PUSH_PROCESSOR_STATUS = 37;
    public static final int OPCODE_PULL_ACCUMULATOR = 38;
    public static final int OPCODE_PULL_PROCESSOR_STATUS = 39;
    public static final int OPCODE_ROTATE_LEFT = 40;
    public static final int OPCODE_ROTATE_RIGHT = 41;
    public static final int OPCODE_RETURN_FROM_INTERRUPT = 42;
    public static final int OPCODE_RETURN_FROM_SUBROUTINE = 43;
    public static final int OPCODE_SUBTRACT_WITH_CARRY = 44;
    public static final int OPCODE_SET_CARRY = 45;
    public static final int OPCODE_SET_DECIMAL = 46;
    public static final int OPCODE_SET_INTERRUPT_DISABLE = 47;
    public static final int OPCODE_STORE_ACCUMULATOR = 48;
    public static final int OPCODE_STORE_X = 49;
    public static final int OPCODE_STORE_Y = 50;
    public static final int OPCODE_TRANSFER_ACCUMULATOR_TO_X = 51;
    public static final int OPCODE_TRANSFER_ACCUMULATOR_TO_Y = 52;
    public static final int OPCODE_TRANSFER_STACK_POINTER_TO_X = 53;
    public static final int OPCODE_TRANSFER_X_TO_ACCUMULATOR = 54;
    public static final int OPCODE_TRANSFER_X_STACK_POINTER = 55;
    public static final int OPCODE_TRANSFER_Y_TO_ACCUMULATOR = 56;
    public static final int OPCODE_ADD_WITH_CARRY = 57;


    public static final int ADDRESS_ACCUMULATOR = 1;
    public static final int ADDRESS_ABSOLUTE = 2;
    public static final int ADDRESS_ABSOLUTE_X_INDEXED = 3;
    public static final int ADDRESS_ABSOLUTE_Y_INDEXED = 4;
    public static final int ADDRESS_IMMEDIATE = 5;
    public static final int ADDRESS_IMPLIED = 6;
    public static final int ADDRESS_INDIRECT = 7;
    public static final int ADDRESS_X_INDEXED_INDIRECT = 8;
    public static final int ADDRESS_INDIRECT_Y_INDEXED = 9;
    public static final int ADDRESS_RELATIVE = 10;
    public static final int ADDRESS_ZEROPAGE = 11;
    public static final int ADDRESS_ZEROPAGE_X_INDEXED = 12;
    public static final int ADDRESS_ZEROPAGE_Y_INDEXED = 13;

    int opcode;
    int address_mode;
    int cycles;
    public InstructionUnit(int opcode,int address_mode,int cycles)
    {
        this.cycles=cycles;
        this.opcode=opcode;
        this.address_mode=address_mode;
    }
}
