package net.runelite.client.plugins.socket.plugins.socketdefence;

import com.google.common.collect.ImmutableSet;
import net.runelite.api.Point;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

import net.runelite.client.plugins.socket.plugins.ModelOutlineRenderer;
import net.runelite.client.ui.overlay.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.awt.*;
import java.util.Objects;
import java.util.Set;

@Singleton
public class SocketDefenceOverlay extends OverlayPanel
{
    private static final Set<Integer> GAP = ImmutableSet.of(34, 33, 26, 25, 18, 17, 10, 9, 2, 1);
    private final Client client;
    private final SocketDefencePlugin plugin;
    private final SocketDefenceConfig config;
    private ModelOutlineRenderer modelOutlineRenderer;

    @Inject
    private SocketDefenceOverlay(final Client client, final SocketDefencePlugin plugin, final SocketDefenceConfig config, ModelOutlineRenderer modelOutlineRenderer)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;
        this.modelOutlineRenderer = modelOutlineRenderer;
        setPosition(OverlayPosition.DYNAMIC);
        setPriority(OverlayPriority.HIGH);
        setLayer(OverlayLayer.ABOVE_SCENE);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (config.corpChally() != SocketDefenceConfig.CorpTileMode.OFF) {
            for (NPC npc : this.client.getNpcs()) {
                if(npc.getName() != null && npc.getName().toLowerCase().equals("corporeal beast")) {
                    Color color = Color.RED;

                    if (plugin.bossDef >= 0 && plugin.bossDef <= 10) {
                        color = Color.GREEN;
                    }
                    if (config.corpChally() == SocketDefenceConfig.CorpTileMode.AREA) {
                        renderAreaOverlay(graphics, npc, color);
                        continue;
                    }
                    if (this.config.corpChally() == SocketDefenceConfig.CorpTileMode.TILE) {
                        NPCComposition npcComp = npc.getComposition();
                        int size = npcComp.getSize();
                        LocalPoint lp = npc.getLocalLocation();
                        Polygon tilePoly = Perspective.getCanvasTileAreaPoly(this.client, lp, size);
                        renderPoly(graphics, color, tilePoly);
                        continue;
                    }
                    if (this.config.corpChally() == SocketDefenceConfig.CorpTileMode.HULL) {
                        Shape objectClickbox = npc.getConvexHull();
                        if (objectClickbox != null) {
                            graphics.setStroke(new BasicStroke(config.corpChallyThicc()));
                            graphics.setColor(color);
                            graphics.draw(objectClickbox);
                        }
                        continue;
                    }
                    if (this.config.corpChally() == SocketDefenceConfig.CorpTileMode.TRUE_LOCATION) {
                        int size = 1;
                        NPCComposition composition = npc.getTransformedComposition();
                        if (composition != null)
                            size = composition.getSize();
                        LocalPoint lp = LocalPoint.fromWorld(this.client, npc.getWorldLocation());
                        if (lp != null) {
                            lp = new LocalPoint(lp.getX() + size * 128 / 2 - 64, lp.getY() + size * 128 / 2 - 64);
                            Polygon tilePoly = Perspective.getCanvasTileAreaPoly(this.client, lp, size);
                            renderPoly(graphics, color, tilePoly);
                        }
                        continue;
                    }
                    if (this.config.corpChally() == SocketDefenceConfig.CorpTileMode.OUTLINE)
                        this.modelOutlineRenderer.drawOutline((Actor) npc, 2, color);
                }
            }
        }
        return null;
    }

    private void renderAreaOverlay(Graphics2D graphics, NPC actor, Color color) {
        Shape objectClickbox = actor.getConvexHull();
        if (objectClickbox != null) {
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 40));
            graphics.fill(actor.getConvexHull());
        }
    }

    private void renderPoly(Graphics2D graphics, Color color, Shape polygon) {
        if (polygon != null) {
            graphics.setColor(color);
            graphics.setStroke(new BasicStroke(config.corpChallyThicc()));
            graphics.draw(polygon);
            graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), config.corpChallyOpacity()));
            graphics.fill(polygon);
        }
    }
}