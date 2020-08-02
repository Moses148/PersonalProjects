package org.AMoses;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        AppTest_Bible.class,
        AppTest_Dictionary.class,
        AppTest_Welcome.class
})

public class AppTest_Suite
{
}
