package testjenkins



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ScriptsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Scripts.list(params), model:[scriptsInstanceCount: Scripts.count()]
    }

    def show(Scripts scriptsInstance) {
        respond scriptsInstance
    }

    def create() {
        respond new Scripts(params)
    }

    @Transactional
    def save(Scripts scriptsInstance) {
        if (scriptsInstance == null) {
            notFound()
            return
        }

        if (scriptsInstance.hasErrors()) {
            respond scriptsInstance.errors, view:'create'
            return
        }

        scriptsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'scripts.label', default: 'Scripts'), scriptsInstance.id])
                redirect scriptsInstance
            }
            '*' { respond scriptsInstance, [status: CREATED] }
        }
    }

    def edit(Scripts scriptsInstance) {
        respond scriptsInstance
    }

    @Transactional
    def update(Scripts scriptsInstance) {
        if (scriptsInstance == null) {
            notFound()
            return
        }

        if (scriptsInstance.hasErrors()) {
            respond scriptsInstance.errors, view:'edit'
            return
        }

        scriptsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Scripts.label', default: 'Scripts'), scriptsInstance.id])
                redirect scriptsInstance
            }
            '*'{ respond scriptsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Scripts scriptsInstance) {

        if (scriptsInstance == null) {
            notFound()
            return
        }

        scriptsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Scripts.label', default: 'Scripts'), scriptsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'scripts.label', default: 'Scripts'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
