package dirtybug

import grails.validation.Validateable

class UpdateAuthorCommand extends AuthorProperties implements Validateable {
    static constraints = {
        importFrom(Author)
    }
}
