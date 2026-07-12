public class Util {
    public static InstructionUnit[] generateInstructionUnitSet()
    {
        InstructionUnit ius[] = new InstructionUnit[255];

        ius[0x00] = new InstructionUnit(InstructionUnit.OPCODE_BREAK,InstructionUnit.ADDRESS_IMPLIED,7);
        ius[0x01] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0x05] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x06] = new InstructionUnit(InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0x08] = new InstructionUnit(InstructionUnit.OPCODE_PUSH_PROCESSOR_STATUS,InstructionUnit.ADDRESS_IMPLIED,3);
        ius[0x09] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0x0A] = new InstructionUnit(InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT,InstructionUnit.ADDRESS_ACCUMULATOR,2);
        ius[0x0D] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x0E] = new InstructionUnit(InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0x10] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_PLUS,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0x11] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0x15] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x16] = new InstructionUnit(InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0x18] = new InstructionUnit(InstructionUnit.OPCODE_CLEAR_CARRY,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x19] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0x1D] = new InstructionUnit(InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0x1E] = new InstructionUnit(InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        ius[0x20] = new InstructionUnit(InstructionUnit.OPCODE_JUMP_SUBROUTINE,InstructionUnit.ADDRESS_ABSOLUTE,6);
        ius[0x21] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0x24] = new InstructionUnit(InstructionUnit.OPCODE_BIT_TEST,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x25] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x26] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_LEFT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0x28] = new InstructionUnit(InstructionUnit.OPCODE_PULL_PROCESSOR_STATUS,InstructionUnit.ADDRESS_IMPLIED,4);
        ius[0x29] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0x2A] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_LEFT,InstructionUnit.ADDRESS_ACCUMULATOR,2);
        ius[0x2C] = new InstructionUnit(InstructionUnit.OPCODE_BIT_TEST,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x2D] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x2E] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_LEFT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0x30] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_MINUS,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0x31] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0x35] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x36] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_LEFT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0x38] = new InstructionUnit(InstructionUnit.OPCODE_SET_CARRY,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x39] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0x3D] = new InstructionUnit(InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0x3E] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_LEFT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        ius[0x40] = new InstructionUnit(InstructionUnit.OPCODE_RETURN_FROM_INTERRUPT,InstructionUnit.ADDRESS_IMPLIED,6);
        ius[0x41] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0x45] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x46] = new InstructionUnit(InstructionUnit.OPCODE_LOGICAL_SHIFT_RIGHT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0x48] = new InstructionUnit(InstructionUnit.OPCODE_PUSH_ACCUMULATOR,InstructionUnit.ADDRESS_IMPLIED,3);
        ius[0x49] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0x4A] = new InstructionUnit(InstructionUnit.OPCODE_LOGICAL_SHIFT_RIGHT,InstructionUnit.ADDRESS_ACCUMULATOR,2);
        ius[0x4C] = new InstructionUnit(InstructionUnit.OPCODE_JUMP,InstructionUnit.ADDRESS_ABSOLUTE,3);
        ius[0x4D] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x4E] = new InstructionUnit(InstructionUnit.OPCODE_LOGICAL_SHIFT_RIGHT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0x50] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_OVERFLOW_CLEAR,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0x51] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0x55] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x56] = new InstructionUnit(InstructionUnit.OPCODE_LOGICAL_SHIFT_RIGHT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0x58] = new InstructionUnit(InstructionUnit.OPCODE_CLEAR_INTERRUPT_DISABLE,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x59] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0x5D] = new InstructionUnit(InstructionUnit.OPCODE_EOR_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0x5E] = new InstructionUnit(InstructionUnit.OPCODE_LOGICAL_SHIFT_RIGHT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        ius[0x60] = new InstructionUnit(InstructionUnit.OPCODE_RETURN_FROM_SUBROUTINE,InstructionUnit.ADDRESS_IMPLIED,6);
        ius[0x61] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0x65] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x66] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_RIGHT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0x68] = new InstructionUnit(InstructionUnit.OPCODE_PULL_ACCUMULATOR,InstructionUnit.ADDRESS_IMPLIED,4);
        ius[0x69] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0x6A] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_RIGHT,InstructionUnit.ADDRESS_ACCUMULATOR,2);
        ius[0x6C] = new InstructionUnit(InstructionUnit.OPCODE_JUMP,InstructionUnit.ADDRESS_INDIRECT,5);
        ius[0x6D] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x6E] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_RIGHT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0x70] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_OVERFLOW_SET,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0x71] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0x75] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x76] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_RIGHT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0x78] = new InstructionUnit(InstructionUnit.OPCODE_SET_INTERRUPT_DISABLE,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x79] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0x7D] = new InstructionUnit(InstructionUnit.OPCODE_ADD_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0x7E] = new InstructionUnit(InstructionUnit.OPCODE_ROTATE_RIGHT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        ius[0x81] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0x84] = new InstructionUnit(InstructionUnit.OPCODE_STORE_Y,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x85] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x86] = new InstructionUnit(InstructionUnit.OPCODE_STORE_X,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0x88] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT_Y,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x8A] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_X_TO_ACCUMULATOR,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x8C] = new InstructionUnit(InstructionUnit.OPCODE_STORE_Y,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x8D] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0x8E] = new InstructionUnit(InstructionUnit.OPCODE_STORE_X,InstructionUnit.ADDRESS_ABSOLUTE,4);

        ius[0x90] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_CARRY_CLEAR,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0x91] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,6);
        ius[0x94] = new InstructionUnit(InstructionUnit.OPCODE_STORE_Y,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x95] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0x96] = new InstructionUnit(InstructionUnit.OPCODE_STORE_X,InstructionUnit.ADDRESS_ZEROPAGE_Y_INDEXED,4);
        ius[0x98] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_Y_TO_ACCUMULATOR,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x99] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,5);
        ius[0x9A] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_X_STACK_POINTER,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0x9D] = new InstructionUnit(InstructionUnit.OPCODE_STORE_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,5);

        ius[0xA0] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xA1] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0xA2] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xA4] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xA5] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xA6] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_X,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xA8] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_ACCUMULATOR_TO_Y,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xA9] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xAA] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_ACCUMULATOR_TO_X,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xAC] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xAD] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xAE] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_X,InstructionUnit.ADDRESS_ABSOLUTE,4);

        ius[0xB0] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_CARRY_SET,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0xB1] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0xB4] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0xB5] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0xB6] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_X,InstructionUnit.ADDRESS_ZEROPAGE_Y_INDEXED,4);
        ius[0xB8] = new InstructionUnit(InstructionUnit.OPCODE_CLEAR_OVERFLOW,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xB9] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0xBA] = new InstructionUnit(InstructionUnit.OPCODE_TRANSFER_STACK_POINTER_TO_X,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xBC] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_Y,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0xBD] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0xBE] = new InstructionUnit(InstructionUnit.OPCODE_LOAD_X,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);

        ius[0xC0] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_Y,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xC1] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0xC4] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_Y,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xC5] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xC6] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0xC8] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT_Y,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xC9] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xCA] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT_X,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xCC] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_Y,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xCD] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xCE] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0xD0] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_NOT_EQUAL,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0xD1] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0xD5] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0xD6] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0xD8] = new InstructionUnit(InstructionUnit.OPCODE_CLEAR_DECIMAL,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xD9] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0xDD] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_ACCUMULATOR,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0xDE] = new InstructionUnit(InstructionUnit.OPCODE_DECREMENT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        ius[0xE0] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_X,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xE1] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_X_INDEXED_INDIRECT,6);
        ius[0xE4] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_X,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xE5] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_ZEROPAGE,3);
        ius[0xE6] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT,InstructionUnit.ADDRESS_ZEROPAGE,5);
        ius[0xE8] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT_X,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xE9] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_IMMEDIATE,2);
        ius[0xEA] = new InstructionUnit(InstructionUnit.OPCODE_NO_OPERATION,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xEC] = new InstructionUnit(InstructionUnit.OPCODE_COMPARE_WITH_X,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xED] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE,4);
        ius[0xEE] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT,InstructionUnit.ADDRESS_ABSOLUTE,6);

        ius[0xF0] = new InstructionUnit(InstructionUnit.OPCODE_BRANCH_ON_EQUAL,InstructionUnit.ADDRESS_RELATIVE,2);
        ius[0xF1] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED,5);
        ius[0xF5] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,4);
        ius[0xF6] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT,InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED,6);
        ius[0xF8] = new InstructionUnit(InstructionUnit.OPCODE_SET_DECIMAL,InstructionUnit.ADDRESS_IMPLIED,2);
        ius[0xF9] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED,4);
        ius[0xFD] = new InstructionUnit(InstructionUnit.OPCODE_SUBTRACT_WITH_CARRY,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,4);
        ius[0xFE] = new InstructionUnit(InstructionUnit.OPCODE_INCREMENT,InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED,7);

        return ius;
    }
}
