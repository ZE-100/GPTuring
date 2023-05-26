package com.z100.gpturing

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class GPTuring : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        BrowserUtil.browse("https://github.com/Z-100")
    }
}
