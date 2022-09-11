package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class neuhigkeiten extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().equals("!update")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                EmbedBuilder eb = new EmbedBuilder();

                eb.setColor(0x2c5dbf);
                eb.setTitle("Neues Update");
                eb.setDescription("<@&1001257523950661705> Man kann sich jetzt verifizieren"+
                        "\n" +
                        "\n**Verify**" +
                        "\n" +
                        "\nIn <#1008638199985356800> kann man sich jetzt problemlos verifizieren" +
                        "\n" +
                        "\n────────────────────────────────────────");

                event.getChannel().sendMessageEmbeds(eb.build()).queue();

            }
        }
    }
}
