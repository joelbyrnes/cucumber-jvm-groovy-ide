package calc

import calc.support.CustomWorld

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(CustomWorld)

Given(~"I have entered (\\d+) into (.*) calculator") { int number, String ignore ->
//    println "calc = ${calc}"
    calc.push number
}

Given(~"(\\d+) into the") {->
    throw new RuntimeException("should never get here since we're running with --guess")
}

When(~"I press divide") { ->
//    println "calc = ${calc}"
    result = calc.divide()
}

Then(~"the stored result should be (.*)") { double expected ->
//    println "calc = ${calc}"
    assert expected == result
}
