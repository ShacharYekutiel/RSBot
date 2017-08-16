package OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import OSRS.FIsher.Utils.Walker;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Walk extends Task {
    public final Walker walker = new Walker(ctx);
    public Walk(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return !Variables.powerFishing && ctx.inventory.select().count() > 27 || (ctx.inventory.select().count() < 28 && Variables.Lumbridge_Swamp_To_Castle[0].distanceTo(ctx.players.local()) > 6);
    }
    @Override
    public void execute() {
        if (!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            if (ctx.inventory.select().count() > 27)
                walker.walkPath(Variables.pathToBank);
            else {
                if (!Variables.fishingArea.contains(ctx.players.local().tile()))
                    walker.walkPathReverse(Variables.pathToBank);
            }
        }

    }
}
