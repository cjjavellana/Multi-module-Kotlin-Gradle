package com.alphamail.plugin.inspector

import com.alphamail.plugin.api.*
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter

class PluginDescriptor {

    fun <T : AlphamailPlugin> getConfigurationsOf(plugin: KClass<T>): Configuration? {

        for (constructor in plugin.constructors) {
            val pluginCfgClass = configurationOf(constructor)

            if (pluginCfgClass != null) {
                val fields = pluginCfgClass.declaredFields.map { field ->
                    val descriptor = field.getAnnotation(FieldDescriptor::class.java)
                    FieldConfiguration(
                        name = field.name,
                        displayName = descriptor.displayName,
                        fieldType = descriptor.fieldType,
                        allowedOptions = descriptor.allowedOptions,
                        validationExpr = descriptor.validationExpression
                    )
                }

                return Configuration(fields)
            }

        }

        return null
    }

    /**
     * Find a single-arg constructor where arg implements `PluginConfiguration`
     */
    private fun <T : AlphamailPlugin> configurationOf(constructor: KFunction<T>): Class<*>? {
        val p = constructor.parameters

        if (isSingleArgConstructor(p)) {
            val configurationClass = Class.forName(p.first().type.toString())
            for (implementedInterface in configurationClass.interfaces) {
                if (implementedInterface == PluginConfiguration::class.java) {
                    return configurationClass
                }
            }
        }

        return null
    }

    private fun isSingleArgConstructor(parameters: List<KParameter>) = parameters.size == 1
}