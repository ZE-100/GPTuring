package com.z100.gpturing.types

import kotlinx.serialization.SerialName
import java.util.*

/**
 * The language the plugin is running in
 * Might be replaced by IntelliJ logic (?)
 *
 * @author Z-100
 */
enum class Language(val code: String) {
    @SerialName(value = "en") EN("en"),
    @SerialName(value = "de") DE("de");

    companion object {
        fun forCode(code: String): Language {
            return Arrays.stream(Language.values())
                .filter { it.code == code }
                .findFirst().orElse(EN)
        }
    }
}
