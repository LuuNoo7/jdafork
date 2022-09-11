package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Objects;

public class verifySystem extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().equals("!verify")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                Guild guild = event.getGuild();
                int min = 1000;
                int max = 99999;
                int randomInt = (int) Math.floor(Math.random() * (max - min + 1) + min);


                EmbedBuilder eb = new EmbedBuilder();
                eb.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1008668590674817054/Vorlage_23.jpg");
                eb.setColor(0x42b580);

                EmbedBuilder eb1 = new EmbedBuilder();
                eb1.setDescription("""
                        __**Verifiziere dich jetzt**__
                         ────────────────────────────────────────
                         Verifiziere dich um auf den server zugreifen zu können.
                         ────────────────────────────────────────

                        **Regeln in der Lounge**

                        <:write:1008807580581245009> **Verhalten in Textkanälen**

                         >   Höfliches verhalten\s
                         >   kein Spam
                         >   keine Eigenwerbung

                         <:speak:1008807608515305573> **Verhalten in Sprachkanälen**

                        >   höfliches verhalten
                        >   keine Eigenwerbung
                        >   keine Stimmenverzerrer

                         ────────────────────────────────────────""");
                eb1.setColor(0x42b580);

                Button button = Button.success("verify", "Verifiziere dich hier!").withEmoji(Emoji.fromFormatted("✅"));

                event.getChannel().sendMessageEmbeds(eb.build()).queue();
                event.getChannel().sendMessageEmbeds(eb1.build()).setActionRow(button).queue();

                final TextChannel channel = guild.createTextChannel("ticket-" + randomInt, guild.getCategoryById("999287949835382795")).complete();

                System.out.println("Created channel id" + channel.getIdLong());


            }

        }

    }
    public void onButtonInteraction (ButtonInteractionEvent event) {

        if (Objects.equals(event.getButton().getId(), "verify")) {

            Role verifyRole = Objects.requireNonNull(event.getGuild()).getRoleById("999297703735463946");
            Role verifyRole2 = Objects.requireNonNull(event.getGuild()).getRoleById("999297358649098300");
            Role a = Objects.requireNonNull(event.getGuild()).getRoleById("1001256886575829033");
            Role b = Objects.requireNonNull(event.getGuild()).getRoleById("1015747133757984859");
            Role c = Objects.requireNonNull(event.getGuild()).getRoleById("1015944229295497287");

            assert verifyRole != null;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), verifyRole).queue();
            assert a != null;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), a).queue();
            assert b != null;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), b).queue();
            assert c != null;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), c).queue();
            if (verifyRole2 != null) {
                event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), verifyRole2).queue();
            }

            event.reply("Du hast dich erfolgreich verifiziert!").setEphemeral(true).queue();

        }

    }

}
