package calc

import cucumber.api.java.en.When

@Mixin(PrintHello)
class SayHello {

    @When('^I say hello$')
    def iSayHello() {
        response = "hello"
    }
}
