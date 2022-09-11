package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class selfcommands extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if (event.getMessage().getContentStripped().startsWith("!finalroles")) {

            if (Objects.requireNonNull(event.getMember()).getPermissions().contains(Permission.ADMINISTRATOR)) {

                EmbedBuilder ebt = new EmbedBuilder();

                ebt.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1001270192871063722/selfroles.jpg");
                ebt.setColor(0x0099ff);

                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle("Wähle deine Rollen aus!");
                eb.setDescription("Wähle eine kategorie aus, indem du unten auf das Selectmenu klickst");
                eb.addField("\uD83C\uDFAD Was sind Rollen?", "Rollen machen dich und dein Profil individuell", true);
                eb.addField("\uD83D\uDD14 Was sind Pings?","Pings benachrichtigen dich, wenn ein Bebestimmtes Ereigis auf dem Server stattfindet",true);
                eb.setThumbnail("https://cdn.discordapp.com/attachments/906251556637249547/935971897638801438/4291148.png");
                eb.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                eb.setColor(0x0099ff);

                EmbedBuilder ebu = new EmbedBuilder();

                ebu.setTitle("<:notiz:1012667633558106183> Klicke um eine kategorie auszuwählen");
                ebu.setDescription("Klicke auf das Menü unter dieser Nachricht, um deine Rollen auswählen zu können!");
                ebu.setThumbnail("https://cdn.discordapp.com/attachments/906251556637249547/936636138255421520/basic1-030_dropdown-512_16234.png");
                ebu.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                ebu.setColor(0x0099ff);

                SelectMenu menu = SelectMenu.create("menus")
                        .setPlaceholder("Wähle deine Rollen aus")
                        .addOption("Pings","pings","Wähle deine Pings", Emoji.fromFormatted("\uD83D\uDD14"))
                        .addOption("Plattform","plattform","Wähle deine Plattform", Emoji.fromFormatted("\uD83D\uDCBB"))
                        .addOption("Hobbys","hobbys","Wähle deine Hobbys", Emoji.fromFormatted("\uD83C\uDFAE"))
                        .addOption("Games","games","Wähle deine Games",Emoji.fromFormatted("\uD83C\uDFAE"))
                        .build();

                event.getChannel().sendMessageEmbeds(ebt.build()).queue();
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
                event.getChannel().sendMessageEmbeds(ebu.build()).setActionRow(menu).queue();

            }

        }

    }

    public void onSelectMenuInteraction (@NotNull SelectMenuInteractionEvent event) {

        if (Objects.equals(event.getSelectMenu().getId(), "menus")) {

            switch (event.getValues().get(0)) {
                case "pings" -> {
                    EmbedBuilder ebp = new EmbedBuilder();
                    ebp.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003931010252861/Vorlage_231.jpg");
                    ebp.setColor(0x0099ff);
                    EmbedBuilder ebp1 = new EmbedBuilder();
                    ebp1.setTitle("<:arrow1:1017472357780160523> __Deine Pings:__");
                    ebp1.setColor(0x0099ff);
                    ebp1.setDescription("<:arrow2:1017473109365895330>Wähle hier deine Pings, indem du unter mir reagierst!");
                    ebp1.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                    SelectMenu pings = SelectMenu.create("pings")
                            .setPlaceholder("Pings")
                            .addOption("Events","events","Klicke, um die Benachrichtigung auszuwählen", Emoji.fromFormatted("\uD83D\uDD14"))
                            .addOption("Neihigkeiten","neuhigkeiten","Klicke, um die Benachrichtigung auszuwählen", Emoji.fromFormatted("\uD83D\uDD14"))
                            .addOption("Umfragen","umfragen","Klicke, um die Benachrichtigung auszuwählen", Emoji.fromFormatted("\uD83D\uDD14"))
                            .build();
                    Button bp1 = Button.success("events", "Events").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));
                    Button bp2 = Button.success("neuhigkeiten", "Neihigkeiten").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));
                    Button bp3 = Button.success("umfragen", "Umfragen").withEmoji(Emoji.fromFormatted("\uD83D\uDD14"));

                    // event.replyEmbeds(ebp.build()).setEphemeral(true).queue();
                    //event.replyEmbeds(ebp1.build()).setActionRow(bp1, bp2, bp3).setEphemeral(true).queue();
                    event.replyEmbeds(ebp.build(),ebp1.build()).setActionRow(bp1, bp2, bp3).setActionRow(pings).setEphemeral(true).queue();

                }
                case "plattform" -> {
                    EmbedBuilder ebpp = new EmbedBuilder();
                    ebpp.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003930704052244/Vorlage_23.jpg");
                    ebpp.setColor(0x0099ff);
                    EmbedBuilder ebpp2 = new EmbedBuilder();
                    ebpp2.setColor(0x0099ff);
                    ebpp2.setTitle("<:arrow1:1017472357780160523> __Deine Plattformen:__");
                    ebpp2.setDescription("<:arrow2:1017473109365895330> Wähle hier deine Plattformen, indem du unter mir reagierst!");
                    ebpp2.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                    SelectMenu plattform = SelectMenu.create("plattform")
                            .setPlaceholder("Plattformen")
                            .addOption("Windows","windows","Klicke, um diese Plattform Spiel auszuwählen", Emoji.fromFormatted("\uD83D\uDCBB"))
                            .addOption("Andriod","andriod","Klicke, um diese Plattform auszuwählen", Emoji.fromFormatted("\uD83D\uDCF1"))
                            .addOption("Apple","apple","Klicke, um diese Plattform auszuwählen", Emoji.fromFormatted("\uD83C\uDF4E"))
                            .addOption("Playstation","playstation","Klicke, um diese Plattform auszuwählen", Emoji.fromFormatted("\uD83C\uDFAE"))
                            .addOption("X Box","x-box","Klicke, um diese Plattform auszuwählen", Emoji.fromFormatted("❎"))
                            .build();
                    Button bp4 = Button.success("windows", "Windows").withEmoji(Emoji.fromFormatted("\uD83D\uDCBB"));
                    Button bp5 = Button.success("andriod", "Andriod").withEmoji(Emoji.fromFormatted("\uD83D\uDCF1"));
                    Button bp6 = Button.success("apple", "Apple").withEmoji(Emoji.fromFormatted("\uD83C\uDF4E"));
                    Button bp7 = Button.success("playstation", "Playstation").withEmoji(Emoji.fromFormatted("\uD83C\uDFAE"));
                    Button bp8 = Button.success("x-box", "X Box").withEmoji(Emoji.fromFormatted("❎"));

                    // event.replyEmbeds(ebpp.build()).setEphemeral(true).queue();
                 // event.replyEmbeds(ebpp2.build()).setActionRow(bp4, bp5, bp6, bp7, bp8).setEphemeral(true).queue();
                    event.replyEmbeds(ebpp.build(),ebpp2.build()).setActionRow(bp4, bp5, bp6, bp7, bp8).setActionRow(plattform).setEphemeral(true).queue();

                }
                case "hobbys" -> {
                    EmbedBuilder ebh = new EmbedBuilder();
                    ebh.setImage("https://cdn.discordapp.com/attachments/1000558689477984307/1016003931282870332/Vorlage_232.jpg");
                    ebh.setColor(0x0099ff);
                    EmbedBuilder ebh2 = new EmbedBuilder();
                    ebh2.setColor(0x0099ff);
                    ebh2.setTitle("<:arrow1:1017472357780160523> __Deine Hobbys:__");
                    ebh2.setDescription("<:arrow2:1017473109365895330> Wähle hier deine Hobbys, indem du unter mir reagierst!");
                    ebh2.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                    SelectMenu hobbys = SelectMenu.create("hobbys")
                            .setPlaceholder("Hobbys")
                            .addOption("Programmieren","programmieren","Klicke, um dieses Hobby auszuwählen", Emoji.fromFormatted("⌨"))
                            .addOption("Malen","malen","Klicke, um dieses Hobby auszuwählen", Emoji.fromFormatted("\uD83D\uDD8C"))
                            .addOption("Gaming","gaming","Klicke, um dieses Hobby auszuwählen", Emoji.fromFormatted("\uD83C\uDFAE"))
                            .addOption("Musik","musik","Klicke, um dieses Hobby auszuwählen", Emoji.fromFormatted("\uD83C\uDFBC"))
                            .addOption("mint","Mint","Klicke, um dieses Hobby auszuwählen", Emoji.fromFormatted("♨"))
                            .build();
                    Button bh = Button.success("programmieren", "Programmieren").withEmoji(Emoji.fromFormatted("⌨"));
                    Button bh2 = Button.success("malen", "Malen").withEmoji(Emoji.fromFormatted("\uD83D\uDD8C"));
                    Button bh3 = Button.success("gaming", "Gaming").withEmoji(Emoji.fromFormatted("\uD83C\uDFAE"));
                    Button bh4 = Button.success("musik", "Musik").withEmoji(Emoji.fromFormatted("\uD83C\uDFBC"));
                    Button bh5 = Button.success("mint", "MINT").withEmoji(Emoji.fromFormatted("♨"));

                    //event.replyEmbeds(ebh.build()).setEphemeral(true).queue();
                    //event.replyEmbeds(ebh2.build()).setActionRow(bh, bh2, bh3, bh4, bh5).setEphemeral(true).queue();
                    event.replyEmbeds(ebh.build(),ebh2.build()).setActionRow(bh, bh2, bh3, bh4, bh5).setActionRow(hobbys).setEphemeral(true).queue();
                }
                case "games" -> {
                    EmbedBuilder ebg = new EmbedBuilder();
                    ebg.setImage("https://cdn.discordapp.com/attachments/1016319045290700841/1018148357648171088/Vorla222ge_23.jpg");
                    ebg.setColor(0x0099ff);
                    EmbedBuilder ebg2 = new EmbedBuilder();
                    ebg2.setColor(0x0099ff);
                    ebg2.setTitle("<:arrow1:1017472357780160523> __Deine Games:__");
                    ebg2.setDescription("<:arrow2:1017473109365895330> Wähle hier deine Games, indem du unter mir reagierst!");
                    ebg2.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
                    SelectMenu spiel = SelectMenu.create("spiel")
                            .setPlaceholder("Spiele")
                            .addOption("Minecraft","minecraft","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("⛏"))
                            .addOption("GTA V","gta-v","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("\uD83D\uDEAC"))
                            .addOption("Valorant","valorant","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("\uD83D\uDCAE"))
                            .addOption("LoL","lol","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("\uD83D\uDC8E"))
                            .addOption("Rainbow Six Siege","rainbow-six-siege","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("\uD83E\uDE93"))
                            .addOption("Overwatch","overwatch","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("\uD83C\uDCCF"))
                            .addOption("Rust","rust","Klicke, um dieses Spiel auszuwählen", Emoji.fromFormatted("☢"))
                            .build();
                    Button bg = Button.success("minecraft", "Minecraft").withEmoji(Emoji.fromFormatted("⛏"));
                    Button bg2 = Button.success("gta-v", "GTA V").withEmoji(Emoji.fromFormatted("\uD83D\uDEAC"));
                    Button bg3 = Button.success("lol", "LoL").withEmoji(Emoji.fromFormatted("\uD83D\uDC8E"));
                    Button bg4 = Button.success("rainbow-six-siege", "Rainbow Six Siege").withEmoji(Emoji.fromFormatted("\uD83E\uDE93"));
                    Button bg5 = Button.success("overwatch", "Overwatch").withEmoji(Emoji.fromFormatted("\uD83C\uDCCF"));
                    Button bg6 = Button.success("rust", "Rust").withEmoji(Emoji.fromFormatted("☢"));

                    event.replyEmbeds(ebg.build(),ebg2.build()).setActionRow(spiel).setEphemeral(true).queue();
                    //.setActionRow(bg, bg2, bg3, bg4, bg5, bg6)


                }

            }

        }

    }

    public void onButtonInteraction(ButtonInteractionEvent event) {

        Role role = null;

        if (Objects.equals(event.getButton().getId(), "event1")) { //1

            role = Objects.requireNonNull(event.getGuild()).getRoleById("999297703735463946");
            assert false;
            event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();

        }else

        if (Objects.equals(event.getButton().getId(), "events")) { //1
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

        event.reply("Du hast deine Rollen erfolgreich geändert").setEphemeral(true).queue();

    }

}
