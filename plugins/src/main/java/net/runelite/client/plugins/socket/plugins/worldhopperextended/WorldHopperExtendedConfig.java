package net.runelite.client.plugins.socket.plugins.worldhopperextended;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("socketworldhopper")
public interface WorldHopperExtendedConfig extends Config {
    public static final String GROUP = "socketworldhopper";

    @ConfigItem(
            keyName = "previousKey",
            name = "Quick-hop previous",
            description = "When you press this key you'll hop to the previous world",
            position = 0
    )
    default Keybind previousKey() {
        return new Keybind(37, 192);
    }

    @ConfigItem(
            keyName = "nextKey",
            name = "Quick-hop next",
            description = "When you press this key you'll hop to the next world",
            position = 1
    )
    default Keybind nextKey() {
        return new Keybind(39, 192);
    }

    @ConfigItem(
            keyName = "quickhopOutOfDanger",
            name = "Quick-hop out of dangerous worlds",
            description = "Don't hop to a PVP/high risk world when quick-hopping",
            position = 2
    )
    default boolean quickhopOutOfDanger() {
        return true;
    }

    @ConfigItem(
            keyName = "quickHopRegionFilter",
            name = "Quick-hop region",
            description = "Limit quick-hopping to worlds of a specific region",
            position = 3
    )
    default RegionFilterMode quickHopRegionFilter()
    {
        return RegionFilterMode.NONE;
    }

    @ConfigItem(
            keyName = "showSidebar",
            name = "Show world hopper sidebar",
            description = "Show sidebar containing all worlds that mimics in-game interface",
            position = 3
    )
    default boolean showWorldHopperSidebar() {
        return true;
    }

    @ConfigItem(
            keyName = "ping",
            name = "Show world ping",
            description = "Shows ping to each game world",
            position = 4
    )
    default boolean worldPing() {
        return true;
    }

    @ConfigItem(
            keyName = "showMessage",
            name = "Show world hop message in chat",
            description = "Shows what world is being hopped to in the chat",
            position = 5
    )
    default boolean showWorldHopMessage() {
        return true;
    }

    @ConfigItem(
            keyName = "menuOption",
            name = "Show Hop-to menu option",
            description = "Adds Hop-to menu option to the friends list and clan members list",
            position = 6
    )
    default boolean menuOption() {
        return false;
    }

    @ConfigItem(
            keyName = "subscriptionFilter",
            name = "Show subscription types",
            description = "Only show free worlds, member worlds, or both types of worlds in sidebar",
            position = 7
    )
    default SubscriptionFilterMode subscriptionFilter() {
        return SubscriptionFilterMode.BOTH;
    }

    @ConfigItem(
            keyName = "regionFilter",
            name = "Filter worlds by region",
            description = "Restrict sidebar worlds to one region",
            position = 8
    )
    default RegionFilterMode regionFilter() { return RegionFilterMode.NONE; }

    @ConfigItem(
            keyName = "displayPing",
            name = "Display current ping",
            description = "Displays ping to current game world",
            position = 8
    )
    default boolean displayCurrentPing() {
        return false;
    }

    @ConfigItem(
            keyName = "combatHop",
            name = "Combat Hop",
            description = "Queue up world hop to instantly hop after out of combat",
            position = 9
    )
    default boolean combatHop() {
        return false;
    }

    @ConfigItem(
            keyName = "customWorldCycle",
            name = "Custom world cycle",
            description = "Hopping cycles between this list of worlds if present. Seperate with Comma and NO spaces. Compatible with socket plugin. Any player in socket can set the current custom worlds by updating their config. ",
            position = 10
    )
    default String customWorldCycle() {
        return "";
    }

    @ConfigItem(
            position = 11,
            keyName = "hopperName",
            name = "Hopper Name",
            description = "Name of the player you're waiting to hop after"
    )
    default String getHopperName() {
        return "";
    }

    @ConfigItem(
            position = 12,
            keyName = "hopperName2",
            name = "Hopper2 Name",
            description = "Name of the player you're waiting to hop after"
    )
    default String getHopperName2() {
        return "";
    }

    @ConfigItem(
            position = 13,
            keyName = "hopSound",
            name = "Hop Sound",
            description = "Sound when world hopping"
    )
    default boolean playSound() {
        return true;
    }
}
