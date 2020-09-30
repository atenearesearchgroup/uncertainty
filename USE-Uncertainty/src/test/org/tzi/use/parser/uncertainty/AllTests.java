package org.tzi.use.parser.uncertainty;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    private AllTests() {}


    /**
     * Returns a new <code>TestSuite</code> containing all
     * soil parser tests.
     * @return
     */
    public static Test suite() {
        final TestSuite testSuite = new TestSuite("All soil parser tests");
        testSuite.addTestSuite(org.tzi.use.parser.uncertainty.USECompilerUncertaintyTest.class);
        return testSuite;
    }
}
