/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-08
 */

package Filme;

import java.util.List;

public class MovieBuilder {
    private Movie movie;

    public MovieBuilder(){}

    public MovieBuilder createMovie(){
        movie = new Movie();
        return this;
    }

    public Movie getMovie(){
        return movie;
    }

    public MovieBuilder setTitle(String title) {
        movie.setTitle(title);
        return this;
    }

    public MovieBuilder setYear(int year) {
        movie.setYear(year);
        return this;
    }

    public MovieBuilder setDirector(Person director) {
        movie.setDirector(director);
        return this;
    }

    public MovieBuilder setWriter(Person writer) {
        movie.setWriter(writer);
        return this;
    }

    public MovieBuilder setSeries(String series) {
        movie.setSeries(series);
        return this;
    }

    public MovieBuilder setCast(List<Person> cast) {
        movie.setCast(cast);
        return this;
    }

    public MovieBuilder setLocations(List<Place> locations) {
        movie.setLocations(locations);
        return this;
    }

    public MovieBuilder setLanguages(List<String> languages) {
        movie.setLanguages(languages);
        return this;
    }

    public MovieBuilder setGenres(List<String> genres) {
        movie.setGenres(genres);
        return this;
    }

    public MovieBuilder setTelevision(boolean isTelevision) {
        movie.setTelevision(isTelevision);
        return this;
    }

    public MovieBuilder setNetflix(boolean isNetflix) {
        movie.setNetflix(isNetflix);
        return this;
    }

    public MovieBuilder setIndependent(boolean isIndependent) {
        movie.setIndependent(isIndependent);
        return this;
    }
    
}   