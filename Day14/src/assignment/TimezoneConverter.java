package assignment;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Scanner;

public class TimezoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define a date-time formatter to parse user input
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Prompt the user for the date and time in the original timezone
        System.out.print("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeInput = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeInput, formatter);

        // Prompt the user for the original timezone
        System.out.print("Enter the original timezone (e.g., America/New_York): ");
        String originalTimezone = scanner.nextLine();
        ZoneId originalZoneId = ZoneId.of(originalTimezone);

        // Prompt the user for the target timezone
        System.out.print("Enter the target timezone (e.g., Europe/London): ");
        String targetTimezone = scanner.nextLine();
        ZoneId targetZoneId = ZoneId.of(targetTimezone);

        // Convert the LocalDateTime to ZonedDateTime in the original timezone
        ZonedDateTime originalZonedDateTime = localDateTime.atZone(originalZoneId);

        // Convert the ZonedDateTime to the target timezone
        ZonedDateTime targetZonedDateTime = originalZonedDateTime.withZoneSameInstant(targetZoneId);

        // Format the result for display
        String formattedDateTime = targetZonedDateTime.format(formatter);

        // Output the result
        System.out.println("The time in " + targetTimezone + " is: " + formattedDateTime);
    }
}
