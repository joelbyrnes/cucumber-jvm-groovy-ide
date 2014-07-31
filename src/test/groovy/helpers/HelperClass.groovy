package helpers

/**
 * This class will break Cucumber if it is in the features path. Keep your features and steps in their own package independent of any other classes.
 */
class HelperClass {
    String data

    HelperClass(String data) {
        this.data = data
    }
}
