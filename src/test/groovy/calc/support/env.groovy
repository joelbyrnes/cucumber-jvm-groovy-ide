package calc.support

import calc.Calculator
import helpers.HelperClass

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

class CustomWorld {
    private static final CustomWorld INSTANCE = new CustomWorld()
    static getInstance() { return INSTANCE }

    static Calculator calc
    static HelperClass helper

    String customMethod() {
        "foo"
    }
}

World {
    CustomWorld.instance
}

Before() {
    assert "foo" == customMethod()
    calc = new Calculator()
}

Before("@notused") {
    throw new RuntimeException("Never happens")
}

Before("@notused,@important", "@alsonotused") {
    throw new RuntimeException("Never happens")
}
