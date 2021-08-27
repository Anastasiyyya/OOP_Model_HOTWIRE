package steps;

import constants.IPagesConstants;
import entities.Flight;
import entities.FlightFilter;
import entities.FlightSearch;
import java.util.List;
import static com.codeborne.selenide.Selenide.switchTo;

public class ChooseFlightsAndViewDetailsSteps extends BaseSteps implements IPagesConstants {

    /**
     * This step helps to choose round-trip flight with different parameters
     * @param flightFilter
     * @param flightSearch
     * @param flightOrder
     * @return List<Flight>
     */
    public List<Flight> chooseRoundTripFlightsWithParameters(FlightFilter flightFilter, FlightSearch flightSearch, int flightOrder){

        basePage.getFlightsSearchPage()
                .clickShowOptionsButton()
                .chooseAdultsCount(flightSearch.getPassenger().getAdultPassengersCount())
                .chooseChildrenCountAndAge(flightSearch.getPassenger().getChildrenPassengersCount())
                .chooseAirlineByName(flightFilter.getAirline().getAirlineName())
                .chooseSeatingClassByName(flightFilter.getAirline().getSeatingClass())
                .selectNonStopCheckbox()
                .chooseDepartingFlight(flightOrder)
                .chooseReturningFlight(flightOrder);
        switchTo().window(1);

        basePage.getFlightsSearchPage()
                .getTripDetailPage().clickShowDepartingDetails()
                .clickShowReturningDetails();

        return makeUpFlightsDetailsList();
    }

    /**
     * This step helps to choose one-way flight with different parameters
     * @param flightFilter
     * @param flightSearch
     * @param flightOrder
     * @return List<Flight>
     */
    public List<Flight> chooseOneWayTripFlightsWithParameters(FlightFilter flightFilter, FlightSearch flightSearch, int flightOrder){

        basePage.getFlightsSearchPage()
                .clickShowOptionsButton()
                .chooseAdultsCount(flightSearch.getPassenger().getAdultPassengersCount())
                .chooseChildrenCountAndAge(flightSearch.getPassenger().getChildrenPassengersCount())
                .chooseAirlineByName(flightFilter.getAirline().getAirlineName())
                .chooseSeatingClassByName(flightFilter.getAirline().getSeatingClass())
                .selectNonStopCheckbox()
                .chooseDepartingFlight(flightOrder);
        switchTo().window(1);

        basePage.getFlightsSearchPage()
                .getTripDetailPage().clickShowDepartingDetails()
                .clickShowReturningDetails();

        return makeUpFlightsDetailsList();
    }
}
