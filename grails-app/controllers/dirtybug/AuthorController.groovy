package dirtybug

class AuthorController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        respond Author.list()
    }

    def show(Long id) {
        respond Author.get(id)
    }

    def save(Author newAuthor) {
        respond newAuthor.save()
    }

    def update(Long id) {
        def existing=Author.get(id)
        existing.updateFromBuggy(new UpdateAuthorCommand(request.JSON))
        respond existing.save()
    }
}
