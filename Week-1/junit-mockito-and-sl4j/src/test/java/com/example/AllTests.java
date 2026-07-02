package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    CalculatorTest.class,
    AssertionsTest.class,
    ArrangeActAssertTest.class,
    EvenCheckerParameterizedTest.class,
    OrderedTests.class,
    ExceptionThrowerTest.class,
    PerformanceTesterTest.class,
    MockitoLabTest.class,
    AdvancedMockitoLabTest.class,
    UserServiceMockitoTest.class,
    UserControllerMockitoTest.class,
    SpringTestingLabTest.class
})
public class AllTests {
}
