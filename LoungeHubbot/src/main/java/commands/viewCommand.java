package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class viewCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().startsWith("!viewadmin")) {

            Member member = event.getMessage().getMentions().getMembers().get(0);

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setThumbnail(member.getEffectiveAvatarUrl());
            embedBuilder.setTitle("Nutzerinfos zu " + member.getEffectiveName());
            embedBuilder.addField("ID des users", event.getMember().getId(), false);
            embedBuilder.addField("Beigetreten am", String.valueOf(event.getMember().getTimeJoined()), false);
            embedBuilder.addField("Account erstellt am", String.valueOf(event.getMember().getTimeCreated()), false);
            embedBuilder.setColor(0x42b580);
            embedBuilder.setDescription(" ");

            Button kickButton = Button.secondary("kick" + member.getId(), "Mitglied kicken");
            Button banButton = Button.danger("ban" + member.getId(), "Mitglied bannen");
            Button profil = Button.link(member.getEffectiveAvatarUrl(), "Profilbild");

            event.getChannel().sendMessageEmbeds(embedBuilder.build()).setActionRow(kickButton, banButton, profil).queue();


        }


    }

    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getButton().getId().startsWith("kick")) {

            if (event.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {

                String nutzerID = event.getButton().getId().substring(4);

                event.getGuild().kick(User.fromId(nutzerID)).queue();

                event.reply("Bestrafung erfolgreich!").queue();

            } else {

                event.reply("Dir fehlen die Rechte hierzu!").queue();

            }

        } else if (event.getButton().getId().startsWith("ban")) {

            if (event.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {

                String nutzerID = event.getButton().getId().substring(3);

                event.getGuild().ban(User.fromId(nutzerID), 7, "Bann eines Admins").queue();

                event.reply("Bestrafung erfolgreich!").queue();

            } else {

                event.reply("Dir fehlen die Rechte hierzu!").queue();

            }

        }

    }


}