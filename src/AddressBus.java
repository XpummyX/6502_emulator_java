public class AddressBus {
    public static final int ADRESS_NMI = 0;
    public static final int ADRESS_RES = 1;
    public static final int ADRESS_IRQ = 2;

    byte[] ram;
    byte[] vectorTable;
    public AddressBus()
    {
        ram = new byte[2048];
        vectorTable = new byte[6];
    }

    public void setVector(int type,int value)
    {
        if(type==ADRESS_NMI)
        {

        }else if(type==ADRESS_RES)
        {
            byte lo = (byte)(value&0xff);
            byte hi = (byte)((value&0xff00)>>8);
            vectorTable[2] = lo;
            vectorTable[3] = hi;
            //System.out.println("lo: "+lo+",hi: "+hi);
        }else if(type==ADRESS_IRQ)
        {

        }
    }

    public byte readByte(int address)
    {
        int translated = address&0xffff;

        if(translated<2048){
            return ram[translated];
        }else if(translated>(0xffff-7)){
            return vectorTable[translated-0xfffa];
        }else {
            return 0;
        }
    }
    public void writeByte(int address,byte arg)
    {
        int translated = address&0xffff;

        if(translated<2048){
            ram[translated] = arg;
        }else if(translated>(0xffff-7)){
            vectorTable[translated-0xfffa] = arg;
        }else {
            System.out.println("null address");
        }
    }
}
