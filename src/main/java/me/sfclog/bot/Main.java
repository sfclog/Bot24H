package me.sfclog.bot;

import com.github.steveice10.mc.protocol.data.game.entity.player.Hand;
import me.sfclog.bot.botutils.Bot;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;

public class Main extends JavaPlugin {

    public static Bot bot;
    @Override
    public void onEnable() {
        bot = new Bot("Bot", new InetSocketAddress("116.202.172.223",42520) , null);
        bot.start();

        Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                bot.sw_hand(Hand.MAIN_HAND);
            }
        }, 1000, 1000);

    }

    public static void sendlog(String s) {
        Bukkit.getConsoleSender().sendMessage(s);
    }
}
