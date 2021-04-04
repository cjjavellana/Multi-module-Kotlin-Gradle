package me.cjavellana.controllers.v1

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Application's can upload images for use in their emails. Images are stored as blob in the database (s3 next phase).
 */
@RestController
@RequestMapping("/v1/image-upload")
class ImageHandlerController {
}