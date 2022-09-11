package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class JoinListener  extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        Member member = event.getMember();
        TextChannel channel = event.getGuild().getTextChannelById("1018302446222716968");

        if (channel != null) {

            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle("\uD83D\uDC4B Neues Mitglied");
            eb.setDescription("Hallo " + member.getEffectiveName() + ", wilkommen in der Lounge. Wir hoffen es gefällt dir hier");
            eb.addField("\uD83D\uDCD5 Regeln", "<#999288376672923780>",true);
            eb.addField(" ","",true);
            eb.addField("✅ Verify","<#1008638199985356800>",true);
            eb.setThumbnail(member.getEffectiveAvatarUrl());
            eb.setFooter("ID "+ member.getId(), member.getEffectiveAvatarUrl());
            eb.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
            eb.setColor(0x0099ff);

            channel.sendMessageEmbeds(eb.build()).queue();

            //channel.sendMessage("Wilkommen"+ member.getEffectiveName()).queue();
        }else {
            System.out.println("X");
        }

    }

}
