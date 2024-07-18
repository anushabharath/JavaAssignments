package functionalinterface;

import java.util.function.Supplier;

public class SupplierEx
{
    public static void main(String args[])
    {
        Supplier<Double> result = Math::random;
        System.out.println(result.get());
    }
}

