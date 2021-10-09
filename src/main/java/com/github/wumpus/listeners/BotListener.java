package com.github.wumpus.listeners;

import com.github.wumpus.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class BotListener extends ListenerAdapter {

    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        String messageSent = event.getMessage().getContentRaw();

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "hello")) {
            event.getChannel().sendMessage("Hello, I'm alive").queue();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("Wumpus Information");
            info.setDescription("The unofficial Wumpus bot\n```\nType " + "\"!" + "help\"" + " for commands\n```");
            info.setColor(0x346beb);
            info.setFooter("Created by Ryzon", event.getMember().getUser().getAvatarUrl());

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
            info.clear();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "avatar")) {
            EmbedBuilder pfp = new EmbedBuilder();
            pfp.setTitle("Avatar: ");
            pfp.setImage(event.getMember().getUser().getAvatarUrl());
            pfp.setColor(0x346beb);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(pfp.build()).queue();
            pfp.clear();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "wieny")) {
            event.getChannel().sendMessage("Wieny loves the AEK").queue();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "yunhai")) {
            event.getChannel().sendMessage("Yunhai spent money on EA instead of PS5").queue();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "announce")) {
            event.getChannel().sendMessage("Announcement").queue();
            event.getGuild().getTextChannelById("896430018199171072").sendMessage("Announcement").queue();
        }

        if (messageSent.equalsIgnoreCase(Wumpus.prefix + "help")) {
            event.getChannel().sendMessage("```\nCommands:\n! hello\n! wieny\n! yunhai\n! info\n! announce\n```").queue();
        }

    }
}
