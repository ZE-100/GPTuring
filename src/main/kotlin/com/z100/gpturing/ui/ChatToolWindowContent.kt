package com.z100.gpturing.ui

import com.intellij.openapi.components.service
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.JBInsets
import com.z100.gpturing.services.PropertiesService
import com.z100.gpturing.types.TranslationEntry.*
import java.awt.*
import java.awt.GridBagConstraints.*
import javax.swing.JLabel
import javax.swing.JPanel


/**
 * ContentManager for [ChatToolWindowFactory]
 *
 * @author Z-100
 */
class ChatToolWindowContent(val toolWindow: ToolWindow) {

    private val contentPanel: JPanel = JPanel()

    private val properties = service<PropertiesService>().properties

    fun welcomePanel(): JPanel {
        TODO("Add a welcome panel to display information about initial setup")
    }

    fun tokenEntryPanel(): JPanel {

        val tokenFieldDesc = JLabel().apply {
            text = properties.getTranslationEntry(TOKEN_FIELD_DESC)
        }

        val tokenEntryField = JBTextField().apply {

        }

        val generateNewTokenDesc = JLabel().apply {
            text = properties.getTranslationEntry(GENERATE_NEW_TOKEN_DESC)
        }

        val sendTokenTestDesc = JLabel().apply {
            text = properties.getTranslationEntry(SEND_TOKEN_TEST_DESC)
        }

        contentPanel.layout = GridBagLayout().apply {

        }

        addComponent(contentPanel, tokenFieldDesc,          0, 0, 1, 1, JBInsets(0, 0, 5, 5), CENTER, HORIZONTAL)
        addComponent(contentPanel, tokenEntryField,         1, 0, 2, 1, JBInsets(0, 0, 5, 0), CENTER, HORIZONTAL)
        addComponent(contentPanel, generateNewTokenDesc,    0, 1, 2, 1, JBInsets(0, 0, 5, 0), CENTER, HORIZONTAL)
        addComponent(contentPanel, sendTokenTestDesc,       0, 2, 2, 1, JBInsets(0, 0, 0, 0), CENTER, HORIZONTAL)

        return contentPanel
    }

    private fun addComponent(
        container: Container, component: Component,
        posX: Int, posY: Int, width: Int, height: Int,
        insets: JBInsets, anchor: Int, fill: Int
    ) {

        val gbc = GridBagConstraints(
            posX, posY, width, height, 1.0, 0.2,
            anchor, fill, insets, 0, 0
        )

        container.add(component, gbc)
    }

}
