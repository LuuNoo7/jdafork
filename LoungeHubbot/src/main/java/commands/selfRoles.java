package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.Objects;

public class selfRoles extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().equals("!roles")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                EmbedBuilder ebp = new EmbedBuilder();
                ebp.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003931010252861/Vorlage_231.jpg");
                ebp.setColor(0x0099ff);
                EmbedBuilder ebp1 = new EmbedBuilder();
                ebp1.setTitle("<:arrow1:1017472357780160523> __Deine Pings:__");
                ebp1.setColor(0x0099ff);
                ebp1.setDescription("<:arrow2:1017473109365895330>Wähle hier dein Pings, indem du unter mir reagierst!");
                ebp1.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                Button bp1 = Button.success("events", "Events").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));
                Button bp2 = Button.success("neuhigkeiten", "Neihigkeiten").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));
                Button bp3 = Button.success("umfragen", "Umfragen").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));


                EmbedBuilder ebpp = new EmbedBuilder();
                ebpp.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003930704052244/Vorlage_23.jpg");
                ebpp.setColor(0x0099ff);
                EmbedBuilder ebpp2 = new EmbedBuilder();
                ebpp2.setColor(0x0099ff);
                ebpp2.setTitle("<:arrow1:1017472357780160523> __Deine Plattformen:__");
                ebpp2.setDescription("<:arrow2:1017473109365895330> Wähle hier dein Plattformen, indem du unter mir reagierst!");
                ebpp2.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                Button bp4 = Button.success("windows", "Windows").withEmoji(Emoji.fromFormatted("\uD83D\uDCBB"));
                Button bp5 = Button.success("andriod", "Andriod").withEmoji(Emoji.fromFormatted("\uD83D\uDCF1"));
                Button bp6 = Button.success("apple", "Apple").withEmoji(Emoji.fromFormatted("\uD83C\uDF4E"));
                Button bp7 = Button.success("playstation", "Playstation").withEmoji(Emoji.fromFormatted("\uD83C\uDFAE"));
                Button bp8 = Button.success("x-box", "X Box").withEmoji(Emoji.fromFormatted("❎"));


                EmbedBuilder ebh = new EmbedBuilder();
                ebh.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003931282870332/Vorlage_232.jpg");
                ebh.setColor(0x0099ff);
                EmbedBuilder ebh2 = new EmbedBuilder();
                ebh2.setColor(0x0099ff);
                ebh2.setTitle("<:arrow1:1017472357780160523> __Deine Hobbys:__");
                ebh2.setDescription("<:arrow2:1017473109365895330> Wähle hier dein Hobbys, indem du unter mir reagierst!");
                ebh2.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                Button bh = Button.success("programmieren", "Programmieren").withEmoji(Emoji.fromFormatted("⌨"));
                Button bh2 = Button.success("malen", "Malen").withEmoji(Emoji.fromFormatted("\uD83D\uDD8C"));
                Button bh3 = Button.success("gaming", "Gaming").withEmoji(Emoji.fromFormatted("\uD83C\uDFAE"));
                Button bh4 = Button.success("musik", "Musik").withEmoji(Emoji.fromFormatted("\uD83C\uDFBC"));
                Button bh5 = Button.success("mint", "MINT").withEmoji(Emoji.fromFormatted("♨"));


                event.getChannel().sendMessageEmbeds(ebp.build()).queue();
                event.getChannel().sendMessageEmbeds(ebp1.build()).setActionRow(bp1, bp2, bp3).queue();
                event.getChannel().sendMessageEmbeds(ebpp.build()).queue();
                event.getChannel().sendMessageEmbeds(ebpp2.build()).setActionRow(bp4, bp5, bp6, bp7, bp8).queue();
                event.getChannel().sendMessageEmbeds(ebh.build()).queue();
                event.getChannel().sendMessageEmbeds(ebh2.build()).setActionRow(bh, bh2, bh3, bh4, bh5).queue();

            }

        }

    }

    public void onButtonInteraction(ButtonInteractionEvent event) {

        Role role = null;

        if (Objects.equals(event.getButton().getId(), "event")) { //1
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1001257479721734165");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "neuhigkeiten")) { //2
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1001257523950661705");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "umfragen")) {//3
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1001264763780743198");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "windows")) { //4
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747468895473684");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "andriod")) { //5
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747433201942629");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "apple")) {//6
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747536637665401");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "playstation")) { //7
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747783040450670");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "x-box")) {//8
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747815147839660");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "programmieren")) {//9
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944610222186548");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else if (Objects.equals(event.getButton().getId(), "malen")) {//10
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944805890658335");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "gaming")) {//11
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944946026557451");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "musik")) {//12
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944971704086649");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }else
            if (Objects.equals(event.getButton().getId(), "mint")) {//13
            role = Objects.requireNonNull(event.getGuild()).getRoleById("1015945019263287417");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
        }

            event.reply("Du hast dich erfolgreich verifiziert!").setEphemeral(true).queue();

    }

}


