package com.alphamail.plugin.api

interface AlphamailPlugin {

    fun beforeSend(): Any?

    fun afterSend(): Any?
}