package com.rc.wefunit;

/**
 * Annotations
 */
public class Annotations {

    @Test
    private final String _testDefault = "default";

    @Test(enabled = true)
    private final String _testEnabled = "enabled";

    @Test(enabled = false)
    private final String _testDisabled = "disabled";

    @Inject
    private final Object _default = null;
}