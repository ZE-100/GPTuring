package com.z100.gpturing

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile

class TestAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {

        e.getData(CommonDataKeys.PROJECT)?.let { printProjectInformation(it) }

        // Can also be retrieved by `FilenameIndex.getVirtualFilesByName()`
        e.getData(PlatformDataKeys.VIRTUAL_FILE)?.let { printFileInformation(it) }
    }

    private fun writeCommentToFile(file: VirtualFile) {

        val vfsUtil = VfsUtil()

        val comment = "// Comment added\n"

        VfsUtil.saveText(file, comment + String(file.contentsToByteArray()))

        val vfsUtilCore = VfsUtilCore()
    }

    private fun printFileInformation(it: VirtualFile) {
        val s = """
            name: ${it.name}
            path: ${it.path}
            extension: ${it.extension}
            isWritable: ${it.isWritable}
            isDirectory: ${it.isDirectory}
            ${String(it.contentsToByteArray())}
        """.trimIndent()

        println(s)

        writeCommentToFile(it)
    }

    private fun printProjectInformation(project: Project) {

        val projectInfo = """
            Project name:   ${project.name}
            Project fPath:  ${project.projectFilePath}
            Project file:   ${project.projectFile}
        """.trimIndent()

        println(projectInfo)
    }
}
