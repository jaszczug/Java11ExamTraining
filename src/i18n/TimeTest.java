package i18n;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeTest {

	public static void main(String[] args) {
		ZonedDateTime ord = ZonedDateTime .of(2018, 3 , 24 , 17, 30,0,0,   ZoneId.of("America/Chicago"));	
		ZonedDateTime waw = ZonedDateTime .of(2018, 3 , 25 , 9, 35,0,0,   ZoneId.of("America/Chicago"));
		
		
		long timeInPlane = ChronoUnit.HOURS.between(ord, waw);
		System.out.println("Time in plane: " +timeInPlane);		
		
		
		Instant startI = Instant.now() ;
		
		LocalDateTime localDateTime = LocalDateTime.parse("2015-02-20T06:30:00");
		localDateTime.plusDays(1);
		localDateTime.minusHours(2);
		
		
		LocalDate start = LocalDate.now();
		
		start.plusDays(1);
		
		LocalDate end = LocalDate.of(2015, Month.FEBRUARY,25);
		
		
		//The Period class represents a quantity of time in terms of years, months and days 
		//and the Duration class represents a quantity of time in terms of seconds and nano seconds.
		Period timeInPlane2 = Period.between(start, end);
		
		
		Duration timeInPlane3 = Duration.between(ord, waw);
		
		timeInPlane3.getSeconds();
		
		System.out.println("Time in plane: " +timeInPlane3);
		
		System.out.println("Time in plane: " +timeInPlane3.toMillis());
		
		LocalDate finalDate = start.plus(Period.ofDays(5));
		
		
		String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
		
		
		localDateTime
		  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.GERMAN));
		
		
		
		System.out.println("localDateTime DE" + localDateTime);
		
		Instant endI = Instant.now() ;
		
		long duriation  = Duration.between(startI, endI).toMillis();
		
		System.out.println("Execution Time: " + duriation);
		
	}
}
