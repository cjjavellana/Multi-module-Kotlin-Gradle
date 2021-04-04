package com.alphamail.plugin.inspector

import com.alphamail.plugin.sample.SampleConfigurablePlugin
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PluginDescriptorTest {

    @Test
    fun test() {
        val descriptor = PluginDescriptor().getConfigurationsOf(SampleConfigurablePlugin::class)
        assertEquals(2, descriptor?.fieldConfigurations?.size)
    }

}