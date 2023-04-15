<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/com/mycompany/moviebooking/Model/Movie.java
package com.mycompany.moviebooking.Model;
=======
package com.mycompany.moviebooking;
>>>>>>> parent of 255df50 (MVC):src/main/java/com/mycompany/moviebooking/Movie.java
=======
package com.mycompany.moviebooking;
>>>>>>> parent of 255df50 (MVC)

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private int releaseYear;
    private String director;
    private String genre;

    public Movie(String name, int releaseYear, String director, String genre) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

}
