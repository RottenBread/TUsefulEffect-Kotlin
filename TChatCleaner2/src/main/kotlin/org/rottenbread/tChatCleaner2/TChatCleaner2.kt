package org.rottenbread.tChatCleaner2

import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class TChatCleaner2 : JavaPlugin(), Listener, CommandExecutor {

    override fun onEnable() {
        logger.info("TChatCleaner enabled")

        server.pluginManager.registerEvents(this, this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name.equals("cc", ignoreCase = true)) {
            if (sender is Player) {
                if (sender.isOp) {
                    if (args.isNotEmpty()) {
                        when (args[0].lowercase()) {
                            "start" -> {
                                val message = Component.text(" ")
                                for (i in 1..20) {
                                    server.sendMessage(message)
                                }
                                sender.sendMessage("§a[서버] §7채팅이 성공적으로 청소되었습니다.")
                            }
                            "help" -> {
                                sender.sendMessage("§a[서버] §7TChatCleaner2 도움말")
                                sender.sendMessage("§7 - /cc help : 도움말 오픈")
                                sender.sendMessage("§7 - /cc start : 채팅청소 시작")
                            }
                        }
                    } else {
                        sender.sendMessage("§a[서버] §7TChatCleaner2 도움말")
                        sender.sendMessage("§7 - /cc help : 도움말 오픈")
                        sender.sendMessage("§7 - /cc start : 채팅청소 시작")
                    }
                } else {
                    sender.sendMessage("§a[서버] §7OP가 아닙니다.")
                }
            }
        }
        return true
    }
}