public class CPUCore {
    public static final boolean SHIFT_LEFT = true;
    public static final boolean SHIFT_RIGHT = false;

    public static final int ARITHMETIC_SHIFT = 1;
    public static final int LOGICAL_SHIFT = 2;
    public static final int ROTATION = 3;

    public static final boolean JUMP_SUBROUTINE = true;
    public static final boolean JUMP_NOT_TO_SUBROUTINE = false;

    public static final int BITOP_AND = 1;
    public static final int BITOP_OR = 2;

    public static final int PULL_STATUS = 1;

    public static final int BRANCH_ON_CARRY_CLEAR = 1;
    public static final int BRANCH_ON_CARRY_SET = 2;
    public static final int BRANCH_ON_RESULT_ZERO = 3;
    public static final int BRANCH_ON_RESULT_MINUS = 4;
    public static final int BRANCH_ON_RESULT_NOT_ZERO = 5;
    public static final int BRANCH_ON_RESULT_PLUS = 6;
    public static final int BRANCH_ON_OVERFLOW_CLEAR = 7;
    public static final int BRANCH_ON_OVERFLOW_SET = 8;

    public static final int FLAG_CARRY = 1;
    public static final int FLAG_DECIMAL = 2;
    public static final int FLAG_INTERRUPT_DISABLE = 3;
    public static final int FLAG_OVERFLOW = 4;

    public static final int PUSH_STATUS = 1;

    public static final int CPU_SPEED = 1000*1000;//1 mhz
    CPUState cpuState;
    AddressBus addressBus;

    InstructionUnit[] ius;
    public CPUCore()
    {
        addressBus = new AddressBus();
        addressBus.setVector(AddressBus.ADRESS_RES,0x0010);
        cpuState = new CPUState(addressBus);

        ius = Util.generateInstructionUnitSet();
    }

    public void runCore()
    {

    }
    public void executeInstruction()
    {
        int instructionIndex = (int)(addressBus.readByte(cpuState.PC) & 0xff);
        switch (ius[instructionIndex].opcode)
        {
            case InstructionUnit.OPCODE_AND_WITH_ACCUMULATOR:
                BitOps(BITOP_AND,ius[instructionIndex].address_mode);
                break;
            case InstructionUnit.OPCODE_ARITHMETIC_SHIFT_LEFT:
                Shift(SHIFT_LEFT,ARITHMETIC_SHIFT,ius[instructionIndex].address_mode);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_CARRY_CLEAR:
                Branch(BRANCH_ON_CARRY_CLEAR);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_CARRY_SET:
                Branch(BRANCH_ON_CARRY_SET);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_EQUAL:
                Branch(BRANCH_ON_RESULT_ZERO);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_MINUS:
                Branch(BRANCH_ON_RESULT_MINUS);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_NOT_EQUAL:
                Branch(BRANCH_ON_RESULT_NOT_ZERO);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_PLUS:
                Branch(BRANCH_ON_RESULT_PLUS);
                break;
            case InstructionUnit.OPCODE_BREAK:
                Break();
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_OVERFLOW_CLEAR:
                Branch(BRANCH_ON_OVERFLOW_CLEAR);
                break;
            case InstructionUnit.OPCODE_BRANCH_ON_OVERFLOW_SET:
                Branch(BRANCH_ON_OVERFLOW_SET);
                break;
            case InstructionUnit.OPCODE_CLEAR_CARRY:
                ClearFlag(FLAG_CARRY);
                break;
            case InstructionUnit.OPCODE_CLEAR_DECIMAL:
                ClearFlag(FLAG_DECIMAL);
                break;
            case InstructionUnit.OPCODE_CLEAR_INTERRUPT_DISABLE:
                ClearFlag(FLAG_INTERRUPT_DISABLE);
                break;
            case InstructionUnit.OPCODE_CLEAR_OVERFLOW:
                ClearFlag(FLAG_OVERFLOW);
                break;
            case InstructionUnit.OPCODE_OR_WITH_ACCUMULATOR:
                BitOps(BITOP_OR,ius[instructionIndex].address_mode);
                break;
            case InstructionUnit.OPCODE_PUSH_PROCESSOR_STATUS:
                Push(PUSH_STATUS);
                break;
            case InstructionUnit.OPCODE_JUMP_SUBROUTINE:
                Jump(JUMP_SUBROUTINE);
                break;
            case InstructionUnit.OPCODE_ROTATE_LEFT:
                Shift(SHIFT_LEFT,ROTATION,ius[instructionIndex].address_mode);
                break;
            case InstructionUnit.OPCODE_PULL_PROCESSOR_STATUS:
                Pull(PULL_STATUS);
                break;
        }
        cpuState.clock+=ius[instructionIndex].cycles;
    }

    public void Add()
    {

    }

    public void Shift(boolean direction,int typeOfShift,int address_mode)
    {
        if(typeOfShift==ARITHMETIC_SHIFT) {
            if (direction == SHIFT_LEFT) {
                if(address_mode==InstructionUnit.ADDRESS_ACCUMULATOR){
                    cpuState.AC = (byte) ((cpuState.AC << 1) & 0xff);
                    cpuState.PC+=1;
                }else {
                    int addr = readAddressFromMemoryBasedOnAdressingMode(address_mode);
                    byte mem = readByteFromMemoryBasedOnAdressingMode(address_mode);
                    mem = (byte) ((mem << 1) & 0xff);
                    addressBus.writeByte(addr,mem);
                }
            } else if (direction == SHIFT_RIGHT) {
                if(address_mode==InstructionUnit.ADDRESS_ACCUMULATOR){
                    cpuState.AC = (byte) ((cpuState.AC << 1) & 0xff);
                }else {
                    int addr = readAddressFromMemoryBasedOnAdressingMode(address_mode);
                    byte mem = readByteFromMemoryBasedOnAdressingMode(address_mode);
                    mem = (byte) ((mem >> 1) & 0xff);
                    addressBus.writeByte(addr,mem);
                }
            }
        }else if(typeOfShift==ROTATION)
        {
            if (direction == SHIFT_LEFT) {
                if(address_mode==InstructionUnit.ADDRESS_ACCUMULATOR) {
                    //System.out.println("rotate left accumulator");
                    byte mem = (byte)(cpuState.AC & 0xff);
                    int bit8 = mem & 128;
                    int sevenBits = mem & 127;
                    sevenBits = sevenBits << 1;
                    bit8 = bit8 >>> 7;
                    int finalByte = bit8 | sevenBits;
                    mem = (byte) ((finalByte) & 0xff);
                    cpuState.AC = mem;
                    cpuState.AC=cpuState.AC & 0xff;
                    cpuState.PC+=1;
                }else {
                    int addr = readAddressFromMemoryBasedOnAdressingMode(address_mode);
                    byte mem = readByteFromMemoryBasedOnAdressingMode(address_mode);
                    int bit8 = mem & 128;
                    int sevenBits = mem & 127;
                    sevenBits = sevenBits << 1;
                    bit8 = bit8 >>> 7;
                    int finalByte = bit8 | sevenBits;
                    mem = (byte) ((finalByte) & 0xff);
                    addressBus.writeByte(addr, mem);
                }
            }
        }
    }
    public void Branch(int branch_type)
    {
        if(branch_type==BRANCH_ON_CARRY_CLEAR)
        {
            if(!cpuState.isCarry())
            {
                cpuState.PC+=addressBus.readByte(cpuState.PC+1);
            }
        }else if(branch_type==BRANCH_ON_CARRY_SET)
        {
            if(cpuState.isCarry())
            {
                cpuState.PC+=addressBus.readByte(cpuState.PC+1);
            }
        }else if(branch_type==BRANCH_ON_RESULT_ZERO)
        {
            if(cpuState.isZero())
            {
                cpuState.PC+=addressBus.readByte(cpuState.PC+1);
            }
        }else if(branch_type==BRANCH_ON_RESULT_PLUS)
        {
            if(!cpuState.isNegative())
            {
                cpuState.PC+=addressBus.readByte(cpuState.PC+1);
            }
        }
    }
    public void BitTest()
    {

    }
    public void Break()
    {

    }
    public void ClearFlag(int flag)
    {
        if(flag==FLAG_CARRY)
        {
            cpuState.setCarry(false);
        }else if(flag==FLAG_DECIMAL)
        {
            cpuState.setDecimal(false);
        }else if(flag==FLAG_INTERRUPT_DISABLE)
        {
            cpuState.setInterrupt(false);
        }else if(flag==FLAG_OVERFLOW)
        {
            cpuState.setOverflow(false);
        }
        cpuState.PC++;
    }
    public void Compare()
    {

    }
    public void Increment()
    {

    }
    public void Decrement()
    {

    }
    public void BitOps(int operation,int address_mode)
    {
        if(operation==BITOP_AND)
        {
            //System.out.println("and func hit");
            byte bb = readByteFromMemoryBasedOnAdressingMode(address_mode);
            cpuState.AC = (cpuState.AC & bb);
        }else if(operation==BITOP_OR)
        {
            byte bb = readByteFromMemoryBasedOnAdressingMode(address_mode);
            //System.out.println("address mode: "+address_mode+" "+bb);
            //System.out.println(Integer.toHexString((int)(bb & 0xff)));
            cpuState.AC = (cpuState.AC | bb);
        }
    }

    public void Push(int type)
    {
        if(type==PUSH_STATUS)
        {
            String status = "";
            if(cpuState.Carry)status=status+"1";
            if(!cpuState.Carry)status=status+"0";
            if(cpuState.Zero)status=status+"1";
            if(!cpuState.Zero)status=status+"0";
            if(cpuState.Interrupt)status=status+"1";
            if(!cpuState.Interrupt)status=status+"0";
            if(cpuState.Decimal)status=status+"1";
            if(!cpuState.Decimal)status=status+"0";
            status=status+"1";
            status=status+"1";
            if(cpuState.Overflow)status=status+"1";
            if(!cpuState.Overflow)status=status+"0";
            if(cpuState.Negative)status=status+"1";
            if(!cpuState.Negative)status=status+"0";
            //System.out.println("status: "+status);
            int mm = 0;
            for(int i=0;i<status.length();i++)
            {
                if(status.charAt(i)=='1') {
                    //System.out.println("true");
                    mm = mm + (int)Math.pow(2,status.length()-(i+1));
                }
            }
            //System.out.println("mm: "+mm);
            //System.out.println(Integer.toBinaryString(mm));
            addressBus.writeByte(cpuState.SP,(byte)(mm&0xff));
            cpuState.SP+=1;
            cpuState.PC++;
        }
    }
    public void PushByte(byte arg)
    {
        addressBus.writeByte(cpuState.SP,(byte)(arg&0xff));
        cpuState.SP+=1;
    }
    public byte PullByte()
    {
        cpuState.SP-=1;
        byte ret = addressBus.readByte(cpuState.SP);
        return ret;
    }
    public void Pull(int type_of_pull)
    {
        if(type_of_pull==PULL_STATUS)
        {
            byte bt = PullByte();
            int btt = (int)(bt&0xff);
            int[] bits = new int[8];
            int bitMask = 1;
            for(int i=0;i<bits.length;i++)
            {
                bits[i] = btt&bitMask;
                bitMask=bitMask<<1;
            }
            for(int i=0;i<bits.length;i++)
            {
                bits[i] = bits[i]>>i;
                //System.out.println(bits[i]);
            }
            //Break flag and bit5 is ignored
            if(bits[0]==1)cpuState.Carry=true;
            if(bits[1]==1)cpuState.Zero=true;
            if(bits[2]==1)cpuState.Interrupt=true;
            if(bits[3]==1)cpuState.Decimal=true;
            if(bits[6]==1)cpuState.Overflow=true;
            if(bits[7]==1)cpuState.Negative=true;

            if(bits[0]==0)cpuState.Carry=false;
            if(bits[1]==0)cpuState.Zero=false;
            if(bits[2]==0)cpuState.Interrupt=false;
            if(bits[3]==0)cpuState.Decimal=false;
            if(bits[6]==0)cpuState.Overflow=false;
            if(bits[7]==0)cpuState.Negative=false;
            cpuState.PC+=2;
        }
    }
    public void Rotate()
    {

    }
    public void Return()
    {

    }
    public void Jump(boolean isSubroutine)
    {
        if(isSubroutine)
        {

            int addr = readAddressFromMemoryBasedOnAdressingMode(InstructionUnit.ADDRESS_ABSOLUTE);

            int pc = cpuState.PC+2;
            //System.out.println("jump pc: "+addr);
            cpuState.PC=addr;
            byte low = (byte)(pc&0x00ff);
            byte high = (byte)(pc&0xff00);

            //System.out.println("jump subroutine");
            //System.out.println("low: "+low);

            PushByte(high);
            PushByte(low);
        }else{
            byte lo = addressBus.readByte(cpuState.PC+2);
            byte hi = addressBus.readByte(cpuState.PC+1);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            cpuState.PC=addr;
        }
    }
    public void SetFlag()
    {

    }
    public void Store()
    {

    }
    public void Transfer()
    {

    }

    public int readAddressFromMemoryBasedOnAdressingMode(int address_mode)
    {
        int ret = 0;
        if(address_mode==InstructionUnit.ADDRESS_IMMEDIATE)
        {
            ret = cpuState.PC+1;
            //cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ZEROPAGE)
        {
            int zpg = (int)(addressBus.readByte(cpuState.PC+1) & 0xff);
            ret = zpg;
            //ret = addressBus.readByte(zpg);
            //cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED)
        {
            int zpg = (int)(addressBus.readByte(cpuState.PC+1) & 0xff)+cpuState.X;
            ret = zpg;
            //cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE)
        {
            byte lo = addressBus.readByte(cpuState.PC+2);
            byte hi = addressBus.readByte(cpuState.PC+1);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            ret = addr;
            //cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED)
        {
            byte lo = addressBus.readByte(cpuState.PC+1);
            byte hi = addressBus.readByte(cpuState.PC+2);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            addr+=cpuState.X;
            ret = addr;
            //cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED)
        {
            byte lo = addressBus.readByte(cpuState.PC+1);
            byte hi = addressBus.readByte(cpuState.PC+2);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff)+cpuState.Y;
            ret = addr;
            //cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_X_INDEXED_INDIRECT)
        {
            int arg = (int)(addressBus.readByte(cpuState.PC+1) & 0xFF);
            int addr = addressBus.readByte(arg+cpuState.X+1)<<8;
            addr+=(addressBus.readByte(arg+cpuState.X)&0xff);
            ret = addr;
            //cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED)
        {
            int arg = (int)(addressBus.readByte(cpuState.PC+1) & 0xFF);
            byte lo = addressBus.readByte(arg+1);
            byte hi = addressBus.readByte(arg);
            int addr = hi<<8+lo;
            addr+=cpuState.Y;
            ret = addr;
            //cpuState.PC+=2;
        }
        return ret;
    }
    public byte readByteFromMemoryBasedOnAdressingMode(int address_mode)
    {
        byte ret = 0;
        if(address_mode==InstructionUnit.ADDRESS_IMMEDIATE)
        {
            ret = addressBus.readByte(cpuState.PC+1);
            cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ZEROPAGE)
        {
            int zpg = (int)(addressBus.readByte(cpuState.PC+1) & 0xff);
            ret = addressBus.readByte(zpg);
            cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ZEROPAGE_X_INDEXED)
        {
            int zpg = (int)(addressBus.readByte(cpuState.PC+1) & 0xff)+cpuState.X;
            ret = addressBus.readByte(zpg);
            cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE)
        {
            byte lo = addressBus.readByte(cpuState.PC+2);
            byte hi = addressBus.readByte(cpuState.PC+1);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            ret = addressBus.readByte(addr);
            cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE_X_INDEXED)
        {
            byte lo = addressBus.readByte(cpuState.PC+1);
            byte hi = addressBus.readByte(cpuState.PC+2);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            addr+=cpuState.X;
            ret = addressBus.readByte(addr);
            cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_ABSOLUTE_Y_INDEXED)
        {
            byte lo = addressBus.readByte(cpuState.PC+1);
            byte hi = addressBus.readByte(cpuState.PC+2);
            int addr = ((hi & 0xff)<<8)+(lo & 0xff);
            addr+=cpuState.Y;
            ret = addressBus.readByte(addr);
            cpuState.PC+=3;
        }else if(address_mode==InstructionUnit.ADDRESS_X_INDEXED_INDIRECT)
        {
            int arg = addressBus.readByte(cpuState.PC+1) & 0xff;
            byte lo = addressBus.readByte(arg+cpuState.X);
            byte hi = addressBus.readByte(arg+cpuState.X+1);
            int addr = ((hi&0xff)<<8)+(lo&0xff);
            ret = addressBus.readByte(addr);
            cpuState.PC+=2;
        }else if(address_mode==InstructionUnit.ADDRESS_INDIRECT_Y_INDEXED)
        {
            int arg = (int)(addressBus.readByte(cpuState.PC+1) & 0xFF);
            //System.out.println("indirect, arg: "+arg);
            byte lo = addressBus.readByte(arg+1);
            byte hi = addressBus.readByte(arg);
            int addr = (hi<<8)+lo;
            //System.out.println("addr indirect: "+addr);
            ret = addressBus.readByte(addr);
            ret+=cpuState.Y;
            //System.out.println("indirect ret: "+ret);
            cpuState.PC+=2;
        }
        return  ret;
    }
}
