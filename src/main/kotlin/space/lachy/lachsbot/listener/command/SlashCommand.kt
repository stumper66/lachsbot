package space.lachy.lachsbot.listener.command

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData

abstract class SlashCommand(
    val name: String,
    private val description: String,
    private val permissions: DefaultMemberPermissions,
    private val options: Collection<OptionData> = emptyList(),
) {

    fun build(): SlashCommandData {
        return Commands.slash(name, description)
            .setDefaultPermissions(permissions)
            .addOptions(options)
    }

    abstract fun execute(event: SlashCommandInteractionEvent)

}