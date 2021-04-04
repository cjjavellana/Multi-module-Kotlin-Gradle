package me.cjavellana.controllers.exceptions

open class BusinessException(msg: String) : Exception(msg)
class TenantAlreadyExistException(msg: String): BusinessException(msg)