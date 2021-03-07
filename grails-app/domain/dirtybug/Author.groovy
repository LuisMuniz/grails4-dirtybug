package dirtybug

class Author {
    String name

    static constraints = {
        name nullable: false, unique: true, maxSize: 100
    }

    //LMU: this does not mark the domain object dirty,
    //so the object is not persisted to the DB at the end of the transaction :(
    //Note that in the Hibernate session the object remains updated
    Author updateFromBuggy(AuthorProperties other) {
        this.name = other.name
        this
    }

    //this works
    Author updateFrom(AuthorProperties other) {
        this.name = other.name
        markDirty()
        this
    }
}
