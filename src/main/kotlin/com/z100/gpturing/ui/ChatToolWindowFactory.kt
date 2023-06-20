package com.z100.gpturing.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory

/**
 * Factory for main toolwindow
 *
 * @author Z-100
 */
class ChatToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val toolWindowContent = ChatToolWindowContent(toolWindow)
        val content = ContentFactory.getInstance().createContent(toolWindowContent.tokenEntryPanel(), "", false)
        toolWindow.contentManager.addContent(content)
    }
}
