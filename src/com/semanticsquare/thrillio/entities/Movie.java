package com.semanticsquare.thrillio.entities;

import com.semanticsquare.thrillio.constants.MovieGenre;
import com.semanticsquare.thrillio.partner.Shareable;

import java.util.Arrays;

public class Movie extends Bookmark implements Shareable {
   private int releaseYear;
   private String [] cast;
   private String [] directors;
   private String genre;
   private double imdRating;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getImdRating() {
        return imdRating;
    }

    public void setImdRating(double imdRating) {
        this.imdRating = imdRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "releaseYear=" + releaseYear +
                ", cast=" + Arrays.toString(cast) +
                ", directors=" + Arrays.toString(directors) +
                ", genre='" + genre + '\'' +
                ", imdRating=" + imdRating +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        if(genre.equals(MovieGenre.HORROR) || genre.equals(MovieGenre.THRILLERS)){
            return false;
        }
        return true;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type>Movie</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<releaseYear>").append(releaseYear).append("</releaseYear>");
        builder.append("<genre>").append(genre).append("</genre>");
        builder.append("<imdRating>").append(imdRating).append("</imdRating>");
        builder.append("<cast>").append(String.join(",", cast)).append("</cast>");
        builder.append("<directors>").append(String.join(",", directors)).append("</directors>");
        builder.append("</item>");
        return builder.toString();

    }
}
//        builder.append("<directors>");
//        if (directors != null) {
//            for (String director : directors) {
//                builder.append("<director>").append(director).append("</director>");
//            }
//        }
//        builder.append("</directors>");