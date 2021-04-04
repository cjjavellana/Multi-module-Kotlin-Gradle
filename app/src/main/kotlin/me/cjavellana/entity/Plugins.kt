package me.cjavellana.entity

import java.time.OffsetDateTime
import javax.persistence.*

// The max size of a medium blob https://mariadb.com/kb/en/mediumblob/
const val PLUGIN_MAX_SIZE: Long = 16777215

/**
 * Plugins are jar files that implements `AlphamailPlugin` interface.
 *
 * Plugins are stored in the database a blobs (s3 next phase - due to environment constraints).
 */
@Entity
@Table(name = "plugins")
class Plugins {

    @Id
    @Column(name = "plugin_id", length = 32, nullable = false)
    var pluginId: String? = null

    @Column(name = "tenant_id", length = 32, nullable = false)
    var tenantId: String? = null

    /**
     * Column that holds the jar file's binary data. Holds a max of 16MB.
     *
     * See https://mariadb.com/kb/en/mediumblob/
     */
    @Lob
    @Column(name = "jar", columnDefinition = "MEDIUMBLOB", nullable = false)
    var jar: ByteArray? = null

    @Column(name = "filename", nullable = false)
    var fileName: String? = null

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