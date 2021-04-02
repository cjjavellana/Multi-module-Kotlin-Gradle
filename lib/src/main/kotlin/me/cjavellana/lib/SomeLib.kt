package me.cjavellana.lib

import com.alphamail.plugin.api.AlphamailPlugin

class SomeLib : AlphamailPlugin {

    override fun execute(): Any? {
        return "Hello"
    }
}