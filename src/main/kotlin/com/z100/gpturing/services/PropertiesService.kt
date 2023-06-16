package com.z100.gpturing.services

import com.z100.gpturing.Properties
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.lang.Thread.currentThread

const val PROPERTIES_FILE = "properties.json"

/**
 * Loads properties.json into [properties]
 *
 * @author Z-100
 */
class PropertiesService {

    val properties: Properties

    init {
        currentThread().contextClassLoader = PropertiesService::class.java.classLoader

        val propertiesStream = currentThread().contextClassLoader.getResourceAsStream(PROPERTIES_FILE)

        properties = Json.decodeFromString(String(propertiesStream?.readAllBytes() ?: "{}".toByteArray()))
    }
}
