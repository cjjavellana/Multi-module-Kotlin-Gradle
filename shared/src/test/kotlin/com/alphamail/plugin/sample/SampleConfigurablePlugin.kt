package com.alphamail.plugin.sample

import com.alphamail.plugin.api.AlphamailPlugin
import com.alphamail.plugin.api.PluginConfiguration

/**
 * A sample plugin demonstrating a plugin with required configuration
 */
class SampleConfigurablePlugin(cfg: Configuration) : AlphamailPlugin {

    override fun execute(): Any? {
        TODO("Not yet implemented")
    }
}