package moe.dazecake.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.gson.*
import moe.dazecake.DeviceNineConfig
import moe.dazecake.DeviceNineData
import moe.dazecake.pojo.LoginData

object TokenGetter {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            gson()
        }
    }

    suspend fun get(): String? {
        val response: HttpResponse = client.post(DeviceNineConfig.baseUrl + "admin_url") {
            url {
                parameters.append("username", DeviceNineConfig.adminAccount)
                parameters.append("password", DeviceNineConfig.adminPassword)
            }
        }

        DeviceNineData.token = "Bearer ${response.body<LoginData>().data["token"]}"
        return DeviceNineData.token
    }
}