package com.z100.gpturing.ui

import com.intellij.openapi.components.service
import com.intellij.openapi.wm.ToolWindow
import com.intellij.util.ui.components.BorderLayoutPanel
import com.z100.gpturing.services.PropertiesService
import com.z100.gpturing.types.TranslationEntry.TOKEN_ENTRY_DESCRIPTION
import com.z100.gpturing.types.TranslationEntry.TOKEN_ENTRY_TITLE
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

/**
 * ContentManager for [ChatToolWindowFactory]
 *
 * @author Z-100
 */
class ChatToolWindowContent(val toolWindow: ToolWindow) {

    private val contentPanel: JPanel = JPanel()

    private val properties = service<PropertiesService>().properties

    fun testPanel(): JPanel {

        val title = JLabel().apply {
            text = properties.getTranslationEntry(TOKEN_ENTRY_TITLE)
        }

        val textField = JTextField()

        val button = JButton().apply {
            text = properties.getTranslationEntry(TOKEN_ENTRY_DESCRIPTION)
        }

        val parentBorder = BorderLayoutPanel().apply {
            addToTop(title)
//                addToLeft(image)
            addToCenter(textField)
//                addToRight()
            addToBottom(button)
        }

        contentPanel.add(parentBorder)

        return contentPanel
    }

    fun welcomePanel(): JPanel {
        TODO("Add a welcome panel to display information about initial setup")
    }

    fun tokenEntryPanel(): JPanel {
        TODO("Add a panel to enter a token. Add a settings-entry as well?")
    }
}
