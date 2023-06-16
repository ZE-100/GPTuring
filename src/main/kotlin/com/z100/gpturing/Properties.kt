package com.z100.gpturing

import com.z100.gpturing.types.Language
import com.z100.gpturing.types.Language.EN
import com.z100.gpturing.types.TranslationEntry
import kotlinx.serialization.Serializable
import org.apache.velocity.exception.ResourceNotFoundException

@Serializable
data class Properties(
    val settings: Settings,
    val translations: Map<String, Map<String, String>>
) {

    fun getTranslationEntry(key: TranslationEntry): String = getTranslationEntry(key, EN)

    fun getTranslationEntry(key: TranslationEntry, lang: Language): String {
        return translations[key.value]?.get(lang.code)
            ?: throw ResourceNotFoundException("No text-entry found for $key or $lang")
    }
}

@Serializable
data class Settings(
    val name: String,
    val language: Language
) {
    fun setLanguage(languageCode: String) = Language.forCode(languageCode)
}
