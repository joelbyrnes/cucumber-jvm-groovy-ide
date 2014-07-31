package calc

import calc.support.CustomWorld
import helpers.HelperClass

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)
this.metaClass.mixin(CustomWorld)

When(~'^I create the helper class with "([^"]*)"$') { String data ->
    helper = new HelperClass(data)
}

Then(~'^I can get "([^"]*)" back from it$') { String data ->
    assert helper.data == data
}