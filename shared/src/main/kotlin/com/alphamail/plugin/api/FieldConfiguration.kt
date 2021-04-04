package com.alphamail.plugin.api

/**
 * Describes how a configuration field for a plugin should be configured
 */
data class FieldConfiguration(
    /**
     * The name of the field to set
     */
    val name: String,

    /**
     * The label used to display on UI
     */
    val displayName: String,

    /**
     * Describes the datatype of the field
     */
    val fieldType: FieldType,

    /**
     * When `fieldType` is `ENUM`, this field is used to supply the options
     */
    val allowedOptions: Array<String> = emptyArray(),

    /**
     * A regular expression used to validate the value for the field
     */
    val validationExpr: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FieldConfiguration

        if (name != other.name) return false
        if (displayName != other.displayName) return false
        if (fieldType != other.fieldType) return false
        if (!allowedOptions.contentEquals(other.allowedOptions)) return false
        if (validationExpr != other.validationExpr) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + displayName.hashCode()
        result = 31 * result + fieldType.hashCode()
        result = 31 * result + allowedOptions.contentHashCode()
        result = 31 * result + validationExpr.hashCode()
        return result
    }
}
