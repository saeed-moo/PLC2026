import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }

    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveResult = false;
        E result = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveResult )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                result = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveResult = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return result;
    }
  
    private static Error result2Error(Result r)
    {
        Error error = null;
        
        switch (e) {
        case A_Bit_DIFFERENT:
            error = Error.A_BIT_DIFFERENT;
            break;
        case INFINITY:
            error = Error.INFINITY;
            break;
        case ZERO:
            error = Error.ZERO;
            break;
        case VERY_DIFFERENT:
            error = Error.VERY_DIFFERENT;
            break;
        }
        
        return error;
    }

    public static void main(String[] args)
    {
        System.out.print("Known errors = ");
        for (Error e : EnumSet.allOf(Error.class)) 
        {
            System.out.print(e + " ");
        }
        System.out.println();
        
        Error e = getEnumElement("error", Error.class);
        System.out.println(e + " results in: " + error2Result(e));
    }
}
