package com.z100.gpturing

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.z100.gpturing.services.RequestService

class TestAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        thisLogger().info(service<RequestService>().getAnswer("Wow, this is a fake answer"))
    }
}
