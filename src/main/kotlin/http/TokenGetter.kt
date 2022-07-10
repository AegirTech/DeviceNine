package moe.dazecake.http


import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import moe.dazecake.DeviceNineConfig
import moe.dazecake.DeviceNineData
import moe.dazecake.pojo.LoginData

object TokenGetter {

    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getToken(): String? {

        val loginData = client.post<LoginData>(DeviceNineConfig.baseUrl + "adminLogin") {
            parameter("username", DeviceNineConfig.adminAccount)
            parameter("password", DeviceNineConfig.adminPassword)
        }

        DeviceNineData.token = "Bearer ${loginData.data["token"]}"

        return DeviceNineData.token
    }
}