package com.alphamail.plugin.api

@Target(AnnotationTarget.FIELD)
annotation class FieldDescriptor(
    val displayName: String,
    val fieldType: FieldType,

    /**
     * Used in conjunction with FieldType ENUM. Provides the list of options for enum types
     */
    val allowedOptions: Array<String> = [],

    /**
     * Must be a valid regular expression. To be used to validate the value set into the field.
     */
    val validationExpression: String = ""
)
