package moe.dazecake.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import moe.dazecake.DeviceNineConfig
import moe.dazecake.DeviceNineData
import moe.dazecake.pojo.CDKListData

class CDKGetter {
    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun createCDK(type: String, param: Int, tag: String, count: Int): CDKListData {
        val cdkListData = client.post<CDKListData>(DeviceNineConfig.baseUrl + "createCDK") {
            headers {
                append(HttpHeaders.Authorization, DeviceNineData.token.toString())
            }
            parameter("type", type)
            parameter("param", param)
            parameter("tag", tag)
            parameter("count", count)
        }

        return cdkListData
    }

    suspend fun showMyCDK(tag: String): CDKListData {
        val cdkListData = client.get<CDKListData>(DeviceNineConfig.baseUrl + "checkCDKByTag") {
            headers {
                append(HttpHeaders.Authorization, DeviceNineData.token.toString())
            }
            parameter("tag", tag)
        }

        return cdkListData
    }
}