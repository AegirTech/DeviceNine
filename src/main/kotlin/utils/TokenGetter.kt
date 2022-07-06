package moe.dazecake.utils

import com.google.gson.JsonParser
import moe.dazecake.DeviceNineConfig
import moe.dazecake.DeviceNineData
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

object TokenGetter {
    fun get(): String? {
        //创建okhttp4 post请求
        OkHttpClient().newCall(
            Request.Builder()
                .url(DeviceNineConfig.baseUrl)
                .post(
                    FormBody.Builder()
                        .add("username", DeviceNineConfig.adminAccount)
                        .add("password", DeviceNineConfig.adminPassword)
                        .build()
                )
                .build()
        ).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                println("get token failed")
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val body = response.body?.string()
                if (body != null) {
                    val data = JsonParser.parseString(body).asJsonObject
                    if (data["code"]?.asInt == 200) {
                        DeviceNineData.token = data["data"].asJsonObject["token"].asString
                        println("get token success")
                    } else {
                        println("get token failed")
                    }
                }
            }
        })

        return DeviceNineData.token
    }
}