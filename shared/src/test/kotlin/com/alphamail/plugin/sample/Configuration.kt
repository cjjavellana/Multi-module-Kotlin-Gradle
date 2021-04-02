package com.alphamail.plugin.sample

import com.alphamail.plugin.api.FieldDescriptor
import com.alphamail.plugin.api.FieldType
import com.alphamail.plugin.api.PluginConfiguration

data class Configuration(
    @FieldDescriptor(displayName = "Name", fieldType = FieldType.STRING)
    val name: String,

    @FieldDescriptor(displayName = "Options", fieldType = FieldType.ENUM, allowedOptions = ["OPTION1", "OPTION2"])
    val options: String
) : PluginConfiguration