
import java.math.*;
import java.util.*;
class MemoryObj{
    String cpu;
    String memory;

    MemoryObj(String cpu, String memory){
        this.cpu = cpu;
        this.memory = memory;
    }
    MemoryObj(){}
}
public class DominoDataLabVirtualOnsiteCoding {
    // # Enter your code here. Read input from STDIN. Print output to STDOUT

// # 100M -> 100000000
// # input {
//  #   cpu:           2
//   #  memory:        2048380Ki
// #}

// # output {
//     cpu: 2000 # millicpus
//     memory: 2097541120 # bytes
// # }
        static ArrayList<String> arrayUnits = new ArrayList<String>(6);
        static {
            arrayUnits.add("Ki");
            arrayUnits.add("Mi");
            arrayUnits.add("Mi");
            arrayUnits.add("m");
            arrayUnits.add("k");
            arrayUnits.add("M");
        }

        public MemoryObj calculateBytes(MemoryObj inputObj){
            MemoryObj resMemory = new MemoryObj();
            // 1. check if cpu and memory are numbers
            boolean isMemoryNumeric = isNumeric(inputObj.memory);
            if(isMemoryNumeric){
                resMemory.memory = inputObj.memory;
            } else {

            }
            if(isNumeric(inputObj.cpu)){
                resMemory.cpu = inputObj.cpu;
            }{

            }
            return resMemory;

        }

        public boolean isNumeric(String input){
            if(input == null) return false;
            try{
                double d = Double.parseDouble(input);
            }catch(NumberFormatException ex){
                return false;
            }
            return true;
        }

        public static  String calculateMemoryBytes(String memory){
            //String[] retArr = new String[](2);
            String memoryInBytes = null;
            String memoryValue = memory.substring(0, memory.length() - 2);
            System.out.println(memoryValue);//2048380Ki
            String memoryUnit = memory.substring(memory.length()-2, memory.length());
            System.out.println(memoryUnit);//2048380Ki
            if(!arrayUnits.contains(memoryUnit)){
                memoryUnit = "0";
            } else {
                //retArr[0] = memoryValue;
                //retArr[1] = memoryUnit;
                int memoryInt = getKBytes(Integer.parseInt(memoryValue));
                System.out.println(memoryInt);
            }
            return memoryInBytes;
        }

        public static int getKBytes(int input){
            BigInteger bigInt = new BigInteger("0");
            BigInteger kilo = BigInteger.valueOf(input);
            bigInt = kilo.multiply(BigInteger.valueOf(1024));
            return bigInt.intValue();
        }

        public static void main(String[] args){
            System.out.println(calculateMemoryBytes("2048380Ki"));
        }
    }
