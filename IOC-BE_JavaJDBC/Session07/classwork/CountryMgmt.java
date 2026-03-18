import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Country {
    private String id;
    private String name;
    private String continent;
    private double population;
    private double area;
    private String languageId;
    private LocalDate independenceDay;


    public Country(String id, String name, String continent, double population, double area, String languageId, LocalDate independenceDay) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.area = area;
        this.languageId = languageId;
        this.independenceDay = independenceDay;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("###,###,###");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return name.toUpperCase()+"\n"+
                "\tAbbreviation: "+id+"\n"+
                "\tContinent: "+continent+"\n"+
                "\tPopulation: "+df.format(population)+" people\n"+
                "\tArea: "+df.format(area)+" sqkm\n"+
                "\tLanguage ID: "+languageId+"\n"+
                "\tIndependence Day: "+independenceDay.format(dtf);
    }
}


class CountryMgmt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do{
            System.out.print("Enter the number of countries: ");
            n = Integer.parseInt(sc.nextLine());
            if (n<1) {
                System.out.println("Please enter a valid number of countries.");
            }
        } while (n<1);
        
        Country[] countries = new Country[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter country " + (i + 1) + ": ");
            System.out.println("Abbreviated name:");
            String id = sc.nextLine();
            System.out.print("Full name: ");
            String name = sc.nextLine();
            System.out.print("Continent: ");
            String continent = sc.nextLine();
            System.out.print("Population: ");
            double population = Double.parseDouble(sc.nextLine());
            System.out.print("Area: ");
            double area = Double.parseDouble(sc.nextLine());
            System.out.print("Language ID: ");
            String languageId = sc.nextLine();
            System.out.print("Independence day (yyyy-MM-dd): ");
            LocalDate independenceDay = LocalDate.parse(sc.nextLine());

            countries[i] = new Country(id, name, continent, population, area, languageId, independenceDay);
        }

        System.out.println("\nCountries entered:");
        for (Country country : countries) {
            System.out.println(country);
        }

        sc.close();
    }
}
/*TEST DATA
VN - Việt Nam (Tiếng Việt)
BE - Bỉ (Tiếng Pháp/Đức/Hà Lan)
BR - Brazil (Tiếng Bồ Đào Nha)
-----------------------
3
VN
Socialist Republic of Vietnam
Asia
100000000
331344
vi
1945-09-02
BE
Kingdom of Belgium
Europe
11825551
30689
fr/de/nl
1831-07-21
BR
Republic of Brazil
South America
213421037
8515767
pt
1822-07-07
 */