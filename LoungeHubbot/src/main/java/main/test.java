package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class test extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().equalsIgnoreCase("!2roles")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("HI");

                SelectMenu menu = SelectMenu.create("Test")
                        .setPlaceholder("test")
                        .addOption("1","1","1")
                        .addOption("2","2","2")
                        .build();

                event.getChannel().sendMessageEmbeds(eb.build()).setActionRow(menu).queue();

            }

        }

    }

    public void onSelectMenuInteraction (@NotNull SelectMenuInteractionEvent event) {

        if (Objects.equals(event.getSelectMenu().getId(), "Test")) {

            switch (event.getValues().get(0)) {
                case "1" -> {
                    EmbedBuilder eb2 = new EmbedBuilder();
                    eb2.setTitle("1");
                    Button button = Button.success("1", "2");
                    event.replyEmbeds(eb2.build()).setActionRow(button).setEphemeral(true).queue();
                }
                case "2" -> {
                    EmbedBuilder eb3 = new EmbedBuilder();
                    eb3.setTitle("2");
                    Button button2 = Button.success("1", "2");
                    event.replyEmbeds(eb3.build()).setActionRow(button2).setEphemeral(true).queue();
                }
            }

        }

    }

}
