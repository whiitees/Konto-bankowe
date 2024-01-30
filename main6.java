class KontoBankowe {
    private String imie;
    private String nazwisko;
    private double saldo;

    public KontoBankowe(String imie, String nazwisko, double saldo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.saldo = saldo;
    }

    public void wplac(double kwota) {
        saldo += kwota;
        System.out.println("Wpłacono " + kwota + " PLN. Aktualne saldo: " + saldo + " PLN");
    }

    public void wyplac(double kwota) {
        if (kwota <= saldo) {
            saldo -= kwota;
            System.out.println("Wypłacono " + kwota + " PLN. Aktualne saldo: " + saldo + " PLN");
        } else {
            System.out.println("Brak wystarczających środków na koncie.");
        }
    }

    public void sprawdzSaldo() {
        System.out.println("Aktualne saldo dla " + imie + " " + nazwisko + ": " + saldo + " PLN");
    }
}

class KontoOsobiste extends KontoBankowe {
    private double kredyt;

    public KontoOsobiste(String imie, String nazwisko, double saldo, double kredyt) {
        super(imie, nazwisko, saldo);
        this.kredyt = kredyt;
    }

    public void wyplacZKredytu(double kwota) {
        if (kwota <= saldo + kredyt) {
            saldo -= kwota;
            System.out.println("Wypłacono " + kwota + " PLN. Aktualne saldo: " + saldo + " PLN. Kredyt pozostały: " + kredyt + " PLN");
        } else {
            System.out.println("Brak wystarczających środków (również kredytowych).");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        KontoBankowe konto1 = new KontoBankowe("Jan", "Kowalski", 1000);
        konto1.wplac(500);
        konto1.wyplac(300);
        konto1.sprawdzSaldo();

        KontoOsobiste konto2 = new KontoOsobiste("Anna", "Nowak", 2000, 1000);
        konto2.wplac(800);
        konto2.wyplacZKredytu(3000);
        konto2.sprawdzSaldo();
    }
}
