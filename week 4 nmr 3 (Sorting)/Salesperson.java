public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString() {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    public boolean equals(Object other) {
        return (lastName.equals(((Salesperson) other).getLastName()) &&
                firstName.equals(((Salesperson) other).getFirstName()));
    }

    public int compareTo(Object other) {
        int result;
        Salesperson otherPerson = (Salesperson) other;

        // Membandingkan berdasarkan totalSales
        if (this.totalSales < otherPerson.totalSales) {
            result = -1;
        } else if (this.totalSales > otherPerson.totalSales) {
            result = 1;
        } else {
            // Jika sales sama, gunakan lastName sebagai tie-breaker
            result = this.lastName.compareTo(otherPerson.lastName);
            // Jika lastName juga sama, gunakan firstName
            if (result == 0) {
                result = this.firstName.compareTo(otherPerson.firstName);
            }
        }
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }
}