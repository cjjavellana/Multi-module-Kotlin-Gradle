package me.cjavellana.entity

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "images")
class Images {

    @Id
    @Column(name = "image_id", length = 255, nullable = false)
    var imageId: String? = null

    @Column(name = "app_code", length = 255, nullable = false)
    var appCode: String? = null

    @ManyToOne
    @JoinColumn(columnDefinition = "app_code", insertable = false, updatable = false)
    var tenant: Tenant? = null

    @Column(name = "file_name", length = 255, nullable = false)
    var fileName: String? = null

    /**
     * A base64 representation of the image
     */
    @Lob
    @Column(name = "image_data", nullable = false)
    var imageData: String? = null

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