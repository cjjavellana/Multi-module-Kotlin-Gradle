package me.cjavellana.lib

import com.alphamail.plugin.api.AlphamailPlugin

class SomeLib : AlphamailPlugin {

    override fun beforeSend(): Any? {
        return "Hello"
    }

    override fun afterSend(): Any? {
        TODO("Not yet implemented")
    }
}