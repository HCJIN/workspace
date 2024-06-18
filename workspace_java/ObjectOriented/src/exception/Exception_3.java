package exception;

public class Exception_3 {
    public static void main(String[] args) {
        try {
            bbb();
        }catch (Exception e){
            
        }

    }

    public static void aaa() throws Exception{

        System.out.println( 5 / 0);
    }

    public static void bbb() throws Exception{
        aaa();
    }
}
