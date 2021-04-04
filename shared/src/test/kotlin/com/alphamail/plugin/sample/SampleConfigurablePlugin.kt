package com.alphamail.plugin.sample

import com.alphamail.plugin.api.AlphamailPlugin

/**
 * A sample plugin demonstrating a plugin with required configuration
 */
class SampleConfigurablePlugin(cfg: Configuration) : AlphamailPlugin {

    override fun beforeSend(): Any? {
        TODO("Not yet implemented")
    }

    override fun afterSend(): Any? {
        TODO("Not yet implemented")
    }
}