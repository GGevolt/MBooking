<<<<<<< HEAD:src/main/java/com/mycompany/moviebooking/Model/Galaxycinema.java
package com.mycompany.moviebooking.Model;
=======
package com.mycompany.moviebooking;
>>>>>>> parent of 255df50 (MVC):src/main/java/com/mycompany/moviebooking/Galaxycinema.java
import java.util.Date;

public class Galaxycinema extends Movie {
    private double ticketPrice;
    private int seatNumber;
    private int halls;
    private Date movieTime;

    public Galaxycinema(String name, int releaseYear, String director, String genre, double ticketPrice, int seatNumber, int halls, Date movieTime) {
    super(name, releaseYear, director, genre);
        this.ticketPrice = ticketPrice;
        this.seatNumber = seatNumber;
        this.halls = halls;
        this.movieTime = movieTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getHalls() {
        return halls;
    }

    public void setHalls(int halls) {
        this.halls = halls;
    }

    public Date getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Date movieTime) {
        this.movieTime = movieTime;
    }
}
