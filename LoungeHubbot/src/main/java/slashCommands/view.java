package slashCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class view extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("view")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                User user;
                if (event.getOption("nutzer") != null) {
                    user = Objects.requireNonNull(event.getOption("nutzer")).getAsUser();
                    Member member = event.getMember();

                    EmbedBuilder embedBuilder = new EmbedBuilder();

                    embedBuilder.setThumbnail(user.getEffectiveAvatarUrl());
                    embedBuilder.setTitle("Nutzrinfos zu " + user.getName() + "");
                    embedBuilder.setDescription("Nutzrinfos zu <@" + user.getId() + ">");
                    embedBuilder.addField("ID des users", user.getId(), false);
                    embedBuilder.addField("Account erstellt am", String.valueOf(user.getTimeCreated()), false);
                    embedBuilder.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                    assert member != null;
                    embedBuilder.setFooter("Abgerufen von " + member.getEffectiveName(), member.getEffectiveAvatarUrl());
                    embedBuilder.setColor(0x42b580);

                    Button kickButton = Button.secondary("kick" + user.getId(), "Mitglied kicken");
                    Button banButton = Button.danger("ban" + user.getId(), "Mitglied bannen");
                    Button profil = Button.link(user.getEffectiveAvatarUrl(), "Profilbild");

                    event.replyEmbeds(embedBuilder.build()).setActionRow(kickButton, banButton, profil).setEphemeral(true).queue();
                } else {

                    event.reply("x").setEphemeral(true).queue();

                }
            }
        }
    }

    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (Objects.requireNonNull(event.getButton().getId()).startsWith("kick")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.KICK_MEMBERS)) {

                String nutzerID = event.getButton().getId().substring(4);

                Objects.requireNonNull(event.getGuild()).kick(User.fromId(nutzerID)).queue();

                event.reply("Bestrafung erfolgreich!").queue();

            } else {

                event.reply("Dir fehlen die Rechte hierzu!").queue();

            }

        } else if (event.getButton().getId().startsWith("ban")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.BAN_MEMBERS)) {

                String nutzerID = event.getButton().getId().substring(3);

                Objects.requireNonNull(event.getGuild()).ban(User.fromId(nutzerID), 7, "Bann eines Admins").queue();

                event.reply("Bestrafung erfolgreich!").queue();

            } else {

                event.reply("Dir fehlen die Rechte hierzu!").queue();

            }

        }

    }
}
