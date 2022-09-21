package hu.petrik.emberekoop;

import java.time.LocalDate;

public class Ember {
    private String nev;
    private String szulDatum;
    private String szulHely;

    public Ember(String nev, String szulDatum, String szulHely) {
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.szulHely = szulHely;
    }


    public int getSzuletesiEv() {
        return Integer.parseInt(szulDatum.substring(0, 4));
    }

    public int getSzuletesiHonap() {
        return Integer.parseInt(szulDatum.split("-")[1]);
    }

    public int getSzuletesiNap() {
        return Integer.parseInt(szulDatum.split("-")[2]);
    }

    public LocalDate getSzuletesiDate() {
        return LocalDate.parse(szulDatum);
    }

    public int getEletkor() {
        LocalDate maiDatum = LocalDate.now();
        var age = maiDatum.getYear() - this.getSzuletesiEv();

        if (this.getSzuletesiHonap() <= maiDatum.getMonthValue()
                && this.getSzuletesiNap() <= maiDatum.getDayOfMonth()) {
            age--;
        }

        return age;
    }

    @Override
    public String toString() {
        return String.format("%-30s %10s (%d) %20s", this.nev, this.szulDatum, this.getEletkor(), this.szulHely);
    }
}