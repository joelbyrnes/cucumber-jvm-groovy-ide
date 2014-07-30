package calc

import calc.support.CustomWorld

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(CustomWorld)

Before() {
    assert "foo" == customMethod()
}

When(~"I press add") { ->
    println "calc = ${calc}"
    result = calc.add()
}
