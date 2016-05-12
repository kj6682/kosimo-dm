package org.kj6682.kosimo.media;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by luigi on 23.04.16.
 * This is the pure and simple model: the Media
 * <p>
 * I do not want to expose this class outside of the package
 */


@Entity
class Media {

    static enum Type{
        AUDIO, BOOK, MOVIE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String author;

    private Type type;

    private String location;

    public Media() {
        super(); //JPA
    }

    // I know this boring telescope declaration is pretty annoying ...
    // ... but it saves time by now
    // In order to be really immutable, the attributes must be final but...
    // JPA imposes


    public Media(String author, String title, Type type, String location) {
        this.author = author;
        this.location = location;
        this.title = title;
        this.type = type;
    }

    public String getAuthors() {
        return author;
    }

    public void setAuthors(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


}
