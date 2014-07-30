package calc

import cucumber.api.java.en.Then

class PrintHello {

    static def response

    @Then('^Hello should be printed$')
    def iPrintHello() {
        assert response == "hello"
    }
}