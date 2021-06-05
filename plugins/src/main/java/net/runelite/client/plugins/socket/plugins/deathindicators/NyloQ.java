package net.runelite.client.plugins.socket.plugins.deathindicators;

import net.runelite.api.NPC;

public class NyloQ
{
    public NPC npc;
    public int queuedDamage;
    public int hp;
    public int hiddenTicks;
    public boolean hidden;
    public int maxHP;
    public int phase;
    public NyloQ(NPC npc, int queuedDamage, int hp)
    {
        this.npc = npc;
        this.queuedDamage = queuedDamage;
        this.hp = hp;
        maxHP = hp;
        hiddenTicks = 0;
        hidden = false;
        phase = 0;
    }
}
