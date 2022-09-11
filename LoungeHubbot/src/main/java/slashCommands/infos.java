package slashCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class infos extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("infos")) {

            Member member123 = event.getMember();


            EmbedBuilder embedBuilder = new EmbedBuilder();

            embedBuilder.setTitle("Serverinformationen");
            embedBuilder.setDescription("Der Servername lautet " + Objects.requireNonNull(event.getGuild()).getName());
            embedBuilder.addField( ":crown: Owner", "<@433678484473249792>", true);
            embedBuilder.addField("<:member:1016435042697875546> Mitglieder", event.getGuild().getMemberCount() + " Mitglieder", true);
            embedBuilder.addField(" ","          ",true);
            embedBuilder.addField("<:roles:1016435044056842402> Regeln", "<#999288376672923780>", true);
            embedBuilder.addField("<:verify:1016435039921246328> Verify" , "<#1008638199985356800>", true);
            embedBuilder.setImage("https://cdn.discordapp.com/attachments/1015950663273943040/1015962974185345034/unten-datei2_-_Kopie.png");
            assert member123 != null;
            embedBuilder.setFooter("Abgerufen von " + member123.getEffectiveName(), member123.getEffectiveAvatarUrl());
            embedBuilder.setThumbnail(event.getGuild().getIconUrl());
            embedBuilder.setColor(0x42b580);

            event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();


        } else {

            event.reply("x").queue();

        }

    }

}


