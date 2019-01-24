
public class company {

    String symbol;
    String name;
    double lastSale;
    double marketCap;
    double ADR;
    double IPOyear;
    String sector;
    String industry;
    String summaryQoute;

    @Override
    public String toString() {
        return "company{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", lastSale=" + lastSale +
                ", marketCap=" + marketCap +
                ", ADR=" + ADR +
                ", IPOyear=" + IPOyear +
                ", sector='" + sector + '\'' +
                ", industry='" + industry + '\'' +
                ", summaryQoute='" + summaryQoute + '\'' +
                '}';
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLastSale() {
        return lastSale;
    }

    public void setLastSale(double lastSale) {
        this.lastSale = lastSale;
    }

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    public double getADR() {
        return ADR;
    }

    public void setADR(double ADR) {
        this.ADR = ADR;
    }

    public double getIPOyear() {
        return IPOyear;
    }

    public void setIPOyear(double IPOyear) {
        this.IPOyear = IPOyear;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSummaryQoute() {
        return summaryQoute;
    }

    public void setSummaryQoute(String summaryQoute) {
        this.summaryQoute = summaryQoute;
    }
}
