package com.github.wumpus;

import com.github.wumpus.listeners.*;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.*;
import net.dv8tion.jda.api.utils.cache.*;
import javax.security.auth.login.LoginException;

public class Wumpus {

    public static JDABuilder builder;

    public static String prefix;

    public static void main(String[] args) throws LoginException {
        String token = "ODk2NDYzNTMzMDU3OTA4Nzk2.YWHeuQ.lQqExqydjH4HMSPWu7zlhPz57bY"; // I changed this token so don't you even think about it
        prefix = "~";

        builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);

        builder.setBulkDeleteSplittingEnabled(false);

        builder.setCompression(Compression.NONE);

        builder.setActivity(Activity.watching("YouTube"));

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);

        registerListeners();

        builder.build();
    }

    public static void registerListeners() {
        builder.addEventListeners(new BotListener());
    }

}

