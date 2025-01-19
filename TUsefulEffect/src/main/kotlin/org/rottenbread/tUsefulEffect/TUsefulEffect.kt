package org.rottenbread.tUsefulEffect

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class TUsefulEffect : JavaPlugin(), Listener, CommandExecutor {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name.equals("te", ignoreCase = true)) {
            if (sender is Player) {
                if (sender.isOp) {
                    if (args.isNotEmpty()) {
                        when (args[0].lowercase()) {
                            "invisibility", "inv" -> {
                                if (sender.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                                    sender.removePotionEffect(PotionEffectType.INVISIBILITY)
                                    sender.sendMessage("§a[서버] §7투명화 효과를 제거했습니다.")
                                } else {
                                    sender.addPotionEffect(PotionEffect(PotionEffectType.INVISIBILITY, Int.MAX_VALUE, 0, false, false))
                                    sender.sendMessage("§a[서버] §7투명화 효과가 지급되었습니다.")
                                }
                            }
                            "night_vision", "vis" -> {
                                if (sender.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                                    sender.removePotionEffect(PotionEffectType.NIGHT_VISION)
                                    sender.sendMessage("§a[서버] §7야간투시 효과를 제거했습니다.")
                                } else {
                                    sender.addPotionEffect(PotionEffect(PotionEffectType.NIGHT_VISION, Int.MAX_VALUE, 0, false, false))
                                    sender.sendMessage("§a[서버] §7야간투시 효과가 지급되었습니다.")
                                }
                            }
                        }
                    }
                }
            }
        }
        return true
    }

}
