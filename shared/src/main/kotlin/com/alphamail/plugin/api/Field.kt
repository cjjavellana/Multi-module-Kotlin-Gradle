package com.alphamail.plugin.api

data class Field(
    val name: String,
    val displayName: String,
    val fieldType: FieldType,
    val allowedOptions: Array<String> = emptyArray(),
    val validationExpr: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Field

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
