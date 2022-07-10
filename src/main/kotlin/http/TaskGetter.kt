package moe.dazecake.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import moe.dazecake.DeviceNineConfig
import moe.dazecake.DeviceNineData
import moe.dazecake.pojo.FreeTaskListData
import moe.dazecake.pojo.FreezeTaskListData
import moe.dazecake.pojo.LockTaskListData

class TaskGetter {

    private val client = HttpClient(CIO) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    suspend fun getLockTaskList(): LockTaskListData {
        val lockTaskListData = client.get<LockTaskListData>(DeviceNineConfig.baseUrl + "showLockTaskList") {
            headers {
                append(HttpHeaders.Authorization, DeviceNineData.token.toString())
            }
        }

        return lockTaskListData
    }

    suspend fun getFreeTaskList(): FreeTaskListData {
        val freeTaskListData = client.get<FreeTaskListData>(DeviceNineConfig.baseUrl + "showFreeTaskList") {
            headers {
                append(HttpHeaders.Authorization, DeviceNineData.token.toString())
            }
        }

        return freeTaskListData
    }

    suspend fun getFreezeTaskList(): FreezeTaskListData {
        val freezeTaskListData = client.get<FreezeTaskListData>(DeviceNineConfig.baseUrl + "showFreezeTaskList") {
            headers {
                append(HttpHeaders.Authorization, DeviceNineData.token.toString())
            }
        }

        return freezeTaskListData
    }
}