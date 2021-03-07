package dirtybug

class AuthorController {
	static responseFormats = ['json', 'xml']
    AuthorService authorService
	
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
        respond authorService.update(id,new UpdateAuthorCommand(request.JSON))
    }
}
