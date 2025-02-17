/*
 * Copyright (c) 2020, Charles Xu <github.com/kthisiscvpv>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.socket.plugins.playerstatus;

import net.runelite.client.config.*;

@ConfigGroup("Socket Player Status Config v3")
public interface PlayerStatusConfig extends Config {

    @ConfigItem(
            position = 0,
            keyName = "getFontSize",
            name = "Indicator Font Size",
            description = "This is the size of the indicator and it's containing text."
    )
    default int getIndicatorSize() {
        return 15;
    }

    @ConfigItem(
            position = 1,
            keyName = "getIndicatorXOffset",
            name = "Indicator X Offset",
            description = "This is horizontal offset of the indicators."
    )
    default int getIndicatorXOffset() {
        return 5;
    }

    @ConfigItem(
            position = 2,
            keyName = "getIndicatorPadding",
            name = "Indicator Border Padding",
            description = "This is the border around each indicator entry."
    )
    default int getIndicatorPadding() {
        return 3;
    }

    @ConfigItem(
            position = 3,
            keyName = "showVengeance",
            name = "Show Vengeance Cooldown",
            description = "Show players who have vengeance on cooldown."
    )
    default boolean showVengeanceCooldown() {
        return false;
    }

    @ConfigItem(
            position = 4,
            keyName = "showVengeanceActive",
            name = "Show Vengeance Active",
            description = "Show players with an active vengeance."
    )
    default boolean showVengeanceActive() {
        return false;
    }

    @ConfigItem(
            position = 5,
            keyName = "showStamina",
            name = "Show Stamina",
            description = "Show players who drank a stamina."
    )
    default boolean showStamina() {
        return false;
    }

    @ConfigItem(
            position = 6,
            keyName = "showOverload",
            name = "Show Overload",
            description = "Show players who drank an overload."
    )
    default boolean showOverload() {
        return false;
    }

    @ConfigItem(
            position = 7,
            keyName = "showPrayerEnhance",
            name = "Show Prayer Enhance",
            description = "Show players who drank a prayer enhance."
    )
    default boolean showPrayerEnhance() {
        return false;
    }

    @ConfigItem(
            position = 8,
            keyName = "showImbuedHeart",
            name = "Show Imbued Heart",
            description = "Show players who invigorated their imbued heart."
    )
    default boolean showImbuedHeart() {
        return false;
    }

    @ConfigItem(
            position = 9,
            keyName = "getStatsRefreshRate",
            name = "Stats Refresh Rate",
            description = "The amount of ticks to wait in-between each stat request. I wouldn't touch this variable."
    )
    default int getStatsRefreshRate() {
        return 3;
    }

    @ConfigItem(
            position = 10,
            keyName = "showPlayerHealth",
            name = "Show Team Health",
            description = "Show player's health level."
    )
    default boolean showPlayerHealth() {
        return true;
    }

    @ConfigItem(
            position = 11,
            keyName = "showPlayerPrayer",
            name = "Show Team Prayer",
            description = "Show player's prayer level."
    )
    default boolean showPlayerPrayer() {
        return false;
    }

    @ConfigItem(
            position = 12,
            keyName = "showPlayerRunEnergy",
            name = "Show Team Run Energy",
            description = "Show player's run energy level."
    )
    default boolean showPlayerRunEnergy() {
        return false;
    }

    @ConfigItem(
            position = 13,
            keyName = "showPlayerSpecial",
            name = "Show Team Special",
            description = "Show player's special attack bar level."
    )
    default boolean showPlayerSpecial() {
        return false;
    }

    @ConfigItem(
            position = 14,
            keyName = "showSpecXfer",
            name = "Show Energy Transfer",
            description = "Show players who can use energy transfer."
    )
    default xferIconMode showSpecXfer() {
        return xferIconMode.OFF;
    }

    @ConfigItem(
            position = 15,
            keyName = "specXferList",
            name = "Energy Transfer List",
            description = "List for who you want the energy transfer icon to show on."
    )
    default String specXferList() { return ""; }

    @Range(max = 100, min = 0)
    @Units("%")
    @ConfigItem(
            position = 17,
            keyName = "specThreshold",
            name = "Spec Threshold",
            description = "The % or under at which you want the energy transfer icon to show on people in socket."

    )
    default int specThreshold() {
        return 100;
    }

    enum xferIconMode {
        OFF, LIST, ALL;

    }
}
