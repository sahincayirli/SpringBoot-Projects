package com.sahin.covid19tracker.services;

import com.sahin.covid19tracker.models.LocationStates;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service // Spring Servisi olmasini saglar
public class Covid19DataServices {

    private static String COVID19_DATA_CONFIRM_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static String COVID19_DATA_DEATHS_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_deaths_global.csv";
    private static String COVID19_DATA_RECOVERED_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_recovered_global.csv";

    private List<LocationStates> allStates = new ArrayList<>();

    public List<LocationStates> getAllStates() {
        return allStates;
    }

    @PostConstruct // when the constructed the service then execute the function
    @Scheduled(cron = "* * 1 * * *")
    public void fetchCovidDataConfirm() throws IOException, InterruptedException {
        List<LocationStates> newStates = new ArrayList<>();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COVID19_DATA_CONFIRM_URL))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader reader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records) {
            LocationStates locationStates = new LocationStates();
            locationStates.setState(record.get("Province/State"));
            locationStates.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size() - 1));
            int previousCases = Integer.parseInt(record.get(record.size() - 2));
            locationStates.setLatestTotalCases(latestCases);
            locationStates.setDiffFromPrevDay(latestCases - previousCases);
            newStates.add(locationStates);
        }

        this.allStates = newStates;

        fetchCovidDataDeaths();
        fetchCovidDataRecovered();
    }

    public void fetchCovidDataDeaths() throws IOException, InterruptedException {


        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(COVID19_DATA_DEATHS_URL))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        int i = 0;
        for (CSVRecord record : records) {
            int deaths = Integer.parseInt(record.get(record.size() - 1));
            allStates.get(i++).setLatestTotalDeaths(deaths);
        }


    }

    public void fetchCovidDataRecovered() throws IOException, InterruptedException {


        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(COVID19_DATA_RECOVERED_URL))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        StringReader csvReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);
        int i = 0;
        for (CSVRecord record : records) {
            int recovered = Integer.parseInt(record.get(record.size() - 1));
            allStates.get(i++).setLatestTotalRecovered(recovered);
        }


    }

}
