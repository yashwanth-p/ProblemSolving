package DSA.Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class UndergroundSystem {

    Map<TravelLog, Data> logs = new HashMap<>();

    Map<Integer, CheckIn> userCheckIn = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        userCheckIn.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String checkOutStation, int checkOutTime) {
        // assuming there is a checkin for this customer

        CheckIn checkIn  = userCheckIn.get(id);
        TravelLog log = new TravelLog(checkIn.station, checkOutStation);
        System.out.println(log + " -- " + log.hashCode() + " -- " + logs.get(log));
        Data curData = logs.getOrDefault(log, new Data(0, 0));
        System.out.println(curData.entryCount + " -- " + curData.totalTime);
        curData.entryCount += 1;
        curData.totalTime += (checkOutTime - checkIn.time);
        System.out.println(curData.entryCount + " " + curData.totalTime);
        logs.put(log, curData);
    }

    public double getAverageTime(String startStation, String endStation) {
        System.out.println(startStation + " -- " + endStation);
        TravelLog log = new TravelLog(startStation, endStation);
        Data data = logs.get(log);
        System.out.println(data);
        System.out.println(log + " ==> " + log.hashCode());
        return data.totalTime*1.0/data.entryCount;
    }
}

class TravelLog {
    String source;
    String destination;

    TravelLog(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }

    @Override
    public boolean equals(Object obj) {
        TravelLog that = (TravelLog)obj;
        return this.source.equals(that.source) && this.destination.equals(that.destination);
    }

    @Override
    public String toString() {
        return "Src: " + source + " Des: " + destination;
    }
}

class Data {
    long entryCount;
    long totalTime;

    Data(long entryCount, long totalTime) {
        this.entryCount = entryCount;
        this.totalTime = totalTime;
    }
}

class CheckIn {
    String station;
    int time;

    CheckIn(String station, int time) {
        this.station = station;
        this.time = time;
    }
}
