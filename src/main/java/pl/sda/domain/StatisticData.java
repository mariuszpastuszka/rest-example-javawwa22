package pl.sda.domain;

public class StatisticData {
    private long numberOfPeople;

    public StatisticData(long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public StatisticData() {
    }

    public long getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(long numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "StatisticData{" +
                "numberOfPeople=" + numberOfPeople +
                '}';
    }
}
