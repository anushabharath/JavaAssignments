package datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Days {
   public static void main(String[] args)
   {
       LocalDate firstDate = LocalDate.now();
       LocalDate SecondDate = LocalDate.of(2027,11,2);
       long d = ChronoUnit.DAYS.between(firstDate,SecondDate);
       System.out.println("Fisrt Date : "+firstDate + "Second Date : "+SecondDate);
       System.out.println("Days Between: "+d);

   }
}
