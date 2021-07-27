package classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.Period;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class Passenger {

    private String passengerName;
    private String passengerSurname;
    private LocalDate birthdayDate;

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        int years;
        if ((birthDate != null) && (currentDate != null)) {
            years = Period.between(birthDate, currentDate).getYears();
            return years;
        } else {
            return 0;
        }
    }

    public boolean isPassengerAdult(int years) {
        return years >= 18;
    }

    public String createPassenger(String passengerName, String passengerSurname) {
        return passengerName + " " + passengerSurname;
    }
}