package moe.dazecake.command

import moe.dazecake.DeviceNine
import moe.dazecake.http.TaskGetter
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand

object StateQueryCommand : CompositeCommand(DeviceNine, "sh") {

    @SubCommand("state")
    suspend fun CommandSender.getState(account: String) {

        var index = 0

        //等待查询
        val freeTaskList = TaskGetter().getFreeTaskList().data
        freeTaskList.forEach {
            if (it.account == account) {
                sendMessage(
                    "前方还有 $index 个账号\n" +
                            "排队中..."
                )
                return
            } else {
                index++
            }
        }

        //占线查询
        val lockTaskList = TaskGetter().getLockTaskList().data
        println(lockTaskList)
        lockTaskList.forEach {
            if (it.value.account.account == account) {
                sendMessage("正在作战中，请勿顶号\n")
                return
            }
        }

        sendMessage("空闲中...")

    }
}