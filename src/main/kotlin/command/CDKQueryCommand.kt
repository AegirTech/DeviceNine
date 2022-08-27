package moe.dazecake.command

import moe.dazecake.DeviceNine
import moe.dazecake.DeviceNineConfig
import moe.dazecake.http.CDKGetter
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.isUser

object CDKQueryCommand : CompositeCommand(DeviceNine, "cdk") {

    @SubCommand("create")
    suspend fun CommandSender.createCDK(type: String, param: Int, tag: String, count: Int) {
        if (isUser() && user.id != DeviceNineConfig.root) {
            sendMessage("权限不足")
            return
        }
        val status = CDKGetter().createCDK(type, param, tag, count).code
        if (status == 200) {
            sendMessage("创建成功")
            return
        }
    }

    @SubCommand("get")
    suspend fun CommandSender.getCDK(type: String, param: Int, count: Int) {
        if (isUser()) {
            val list = CDKGetter().showMyCDK(user.id.toString()).data
            if (list.size >= count) {
                var msg = ""
                var num = 1
                for (cdkData in list) {
                    if (num > count) {
                        break
                    }
                    if (cdkData.param == param && cdkData.type == type) {
                        msg += "${cdkData.cdk}\n"
                        num++
                    }
                }
                sendMessage(msg)
            } else {
                sendMessage("剩余不足，请联系管理员加卡")
            }
        }
    }

}