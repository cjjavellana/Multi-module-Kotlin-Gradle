package me.cjavellana.entity

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "tenants")
class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id", length = 24, nullable = false)
    var tenantId: Int? = null

    /**
     *
     * TODO(christianj): This must be unique
     */
    @Column(name = "appcode", length = 24, nullable = false)
    var appCode: String? = null

    @Column(name = "display_name", length = 56, nullable = false)
    var displayName: String? = null

    @Column(name = "primary_owner_name", length = 256, nullable = false)
    var primaryOwnerName: String? = null

    @Column(name = "primary_owner_id", length = 24, nullable = false)
    var primaryOwnerId: String? = null

    @Column(name = "secondary_owner_name", length = 256, nullable = false)
    var secondaryOwnerName: String? = null

    @Column(name = "secondary_owner_id", length = 24, nullable = false)
    var secondaryOwnerId: String? = null

    /**
     * A key used to decrypt properties in the appSettings denoted by `[enc]`
     */
    @Column(name = "encryption_key", length = 512, nullable = false)
    var encryptionKey: String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 24, nullable = false)
    var status: Status = Status.PENDING_OWNER_APPROVAL

    enum class Status {
        ACTIVE, INACTIVE, PENDING_OWNER_APPROVAL
    }

    /**
     * A YML text representing the application's global settings e.g.
     *
     * app:
     *  plugin:
     *      saveToOutlook:
     *          gaasProxyUsername: username
     *          gaasProxyPassword: password
     *  email:
     *      defaultSender: myapp@helloworld.com
     *      footerMessage: |
     *          This is an automated message, please do not reply.
     * ...
     *
     * This can then be used when configuring plugins and or value to replace template placeholders as:
     * {{ app.plugin.saveToOutlook.gaasProxyUsername }}
     *
     * Email templates can reference these global variables as:
     *
     * ```
     * <html>
     *     <h1>My First Email Template</h1>
     *
     *     <div>
     *         {{ app.email.footerMessage }}
     *     </div>
     * </html>
     * ```
     *
     */
    @Lob
    @Column(name = "app_settings", nullable = false, columnDefinition = "TEXT")
    val appSettings: String? = null

    @Column(name = "created_by", length = 24, nullable = false)
    val createdBy: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false)
    val dateCreated: OffsetDateTime? = null

    @Column(name = "updated_by", length = 24)
    val updatedBy: String? = null

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated", nullable = false)
    val dateUpdated: OffsetDateTime? = null
}