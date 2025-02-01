/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-08
 */

package Filme;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieBuilder mb = new MovieBuilder()
            .createMovie()
            .setTitle("Movie Title")
            .setYear(2025)
            .setLanguages(List.of("Portuguese","English"))
            .setTelevision(true);
            
        Movie movie = mb.getMovie();
        System.out.println("Movie: " + movie);
    }
}