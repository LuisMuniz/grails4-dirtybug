package dirtybug

import grails.gorm.transactions.Transactional

@Transactional
class AuthorService {

    Author update(Long id, AuthorProperties props) {
        def existing=Author.get(id)
        existing.updateFromBuggy(props)
        existing.save(flush:true)
    }
}
