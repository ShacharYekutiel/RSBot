package OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import OSRS.FIsher.Utils.Walker;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

public class Walk extends Task {
    private final Walker walker = new Walker(ctx);
    public Walk(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return !Variables.powerFishing && ctx.inventory.select().count() > 27 || (!Variables.powerFishing && ctx.inventory.select().count() < 28 && !Variables.fishingArea.contains(ctx.players.local().tile()));
    }
    @Override
    public void execute() {
        if (!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            if (ctx.inventory.select().count() > 27 && !Variables.bankArea.contains(ctx.players.local().tile())) {
                walker.walkPath(Variables.pathToBank);
                Variables.status = "Walking to bank";
            }
            else {
                walker.walkPathReverse(Variables.pathToBank);
                Variables.status = "Walking to Fishing spot";
            }
        }

    }
}
