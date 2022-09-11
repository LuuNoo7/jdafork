package main;

import commands.*;
import events.JoinListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import slashCommands.infos;
import slashCommands.view;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Main {

    public static String prefix = "!";
    public static JDA bot;

    public static void main(String[] args) throws LoginException, InterruptedException {


        String status;
        status = "Lounge";

        String token = Value.token;

        JDABuilder builder = JDABuilder.createDefault(token).enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS);

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing(status));

        builder.addEventListeners(new view());
        builder.addEventListeners(new selfRoles());
        builder.addEventListeners(new neuhigkeiten());
        builder.addEventListeners(new verifySystem());
        builder.addEventListeners(new infos());
        builder.addEventListeners(new test());
        builder.addEventListeners(new selfcommands());
        builder.addEventListeners(new selectmenu());

        builder.addEventListeners(new JoinListener());

        bot = builder.build().awaitReady();

        builder.enableIntents(EnumSet.allOf(GatewayIntent.class));

        bot.updateCommands().addCommands(
                bot.upsertCommand("view","View eine Nutzer").addOption(OptionType.USER,"nutzer","Wähle einen Nutzer")).queue();
                bot.upsertCommand("infos", "Serverinformationen").queue();


    }

}


