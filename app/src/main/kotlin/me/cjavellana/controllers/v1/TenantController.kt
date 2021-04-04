package me.cjavellana.controllers.v1

import me.cjavellana.controllers.v1.api.TenantRegistrationRequestV1
import me.cjavellana.controllers.v1.api.TenantRegistrationResponseV1
import me.cjavellana.entity.Tenant
import me.cjavellana.services.TenantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Responsible for handling requests related to tenant settings e.g. app related accounts, plugins, etc
 */
@RestController
@RequestMapping("/v1/tenant")
class TenantController(private val tenantService: TenantService) {

    /**
     * Called when a user wants to onboard an app.
     */
    @PostMapping
    fun submitRequest(@Valid @RequestBody registrationRequest: TenantRegistrationRequestV1): ResponseEntity<TenantRegistrationResponseV1> {
        val newTenant = tenantService.register(Tenant().apply {
            appCode = registrationRequest.appCode
            displayName = registrationRequest.displayName
        })

        return ResponseEntity.ok(TenantRegistrationResponseV1(newTenant.appCode!!, newTenant.status.toString()))
    }

    /**
     * Called when the primary or secondary application owner approves onboarding request via an email so this endpoint
     * is excluded from the security filter
     */
    @GetMapping("/approve-via-email")
    fun approveViaEmail(@RequestParam("token") securityToken: String) {
    }

}