import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {

        Scanner Data = new Scanner(System.in);
        System.out.println("Masukkan jumlah data: "); 
        
        int JumlahData = Data.nextInt();

        for(int loop = 1; loop <= JumlahData; loop++) {

            System.out.println("Angka ke " + loop + ":");
            
            try {
                long input_angka = Data.nextLong();
                System.out.println("Can be fitted in:");

                if(Long.MIN_VALUE <= input_angka && input_angka <= Long.MAX_VALUE) {
                System.out.println("-long");
                }

                if(Integer.MIN_VALUE <= input_angka && input_angka <= Integer.MAX_VALUE) {
                System.out.println("-int"); 
                }

                if(Short.MIN_VALUE <= input_angka && input_angka <= Short.MAX_VALUE) {
                System.out.println("-short");
                }

                if(Byte.MIN_VALUE <= input_angka && input_angka <= Byte.MAX_VALUE) {
                System.out.println("-byte");
                }
            }

            catch(Exception e) {   
             //bakalan jalan ketika angka melebihi Long                                           
                System.out.println(Data.next() + " can't be fitted anywhere.");
                //Data.next() biar angka yang error itu ngga nyangkut
                }
        }
    }   
}
