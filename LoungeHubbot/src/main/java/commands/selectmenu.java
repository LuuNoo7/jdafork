package commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class selectmenu extends ListenerAdapter {

    public void onSelectMenuInteraction(@NotNull SelectMenuInteractionEvent event) {

        if (Objects.equals(event.getSelectMenu().getId(), "pings")) {
            Role role = null;
            switch (event.getValues().get(0)) {
                case "events" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1001257479721734165");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "neuhigkeiten" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1001257523950661705");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "umfragen" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1001264763780743198");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
            }

        } else if (Objects.equals(event.getSelectMenu().getId(), "plattform")) {
            Role role = null;
            switch (event.getValues().get(0)) {
                case "windows" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747468895473684");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "andriod" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747433201942629");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "apple" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747536637665401");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "playstation" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747783040450670");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "x-box" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015747815147839660");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }

            }

        } else if (Objects.equals(event.getSelectMenu().getId(), "hobbys")) {
            Role role = null;
            switch (event.getValues().get(0)) {
                case "programmieren" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944610222186548");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "malen" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944805890658335");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "gaming" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944946026557451");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "musik" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015944971704086649");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "mint" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1015945019263287417");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }

            }

        } else if (Objects.equals(event.getSelectMenu().getId(), "spiel")) {
            Role role = null;
            switch (event.getValues().get(0)) {
                case "minecraft" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074303700828211");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "gta-v" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074334671589429");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "valorant" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074383937871932");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "lol" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074834632622122");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "rainbow-six-siege" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074953197195384");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "overwatch" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074969106206780");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }
                case "rust" -> {
                    role = Objects.requireNonNull(event.getGuild()).getRoleById("1017074989729599539");
                    assert false;
                    event.getGuild().addRoleToMember(Objects.requireNonNull(event.getMember()), role).queue();
                    event.reply("Deine Rollen wurden aktualisiert").setEphemeral(true).queue();
                }

            }

        }

    }

}
