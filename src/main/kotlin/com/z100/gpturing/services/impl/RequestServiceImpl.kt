package com.z100.gpturing.services.impl

import com.intellij.openapi.components.Service
import com.z100.gpturing.services.RequestService

@Service
class RequestServiceImpl : RequestService {

    override fun getAnswer(q: String): String = q.reversed()
}
