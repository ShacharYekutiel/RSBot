package OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import java.util.concurrent.Callable;

public class Fish extends Task {

    public Fish(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1 && ctx.inventory.select().count() < 28;
    }

    @Override
    public void execute() {
        Npc spot = ctx.npcs.select().id(Variables.spot).nearest().poll();
        if (ctx.inventory.select().id(Variables.rodID).count() > 0) {
            if (spot.inViewport()) {
                if (spot.interact(Interacting())) {
                    Variables.status = "Starts fishing";
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return ctx.players.local().animation() != -1;
                        }
                    });
                }
                Variables.status = "Fishing";
            }
            else {
                Variables.status = "Turning camera to spot";
                ctx.camera.turnTo(spot);
            }
        } else
            ctx.controller.stop();
    }

    public String Interacting() {
        String answer = "";
        for (Item item : ctx.inventory.select().id(Variables.rodID)){
            if (item.id() == Variables.Small_Net_ID)
                answer = "Net";
            else if (item.id() == Variables.Fishing_Rod_ID)
                answer = "Bait";
            else if (item.id() == Variables.Fly_Fishing_Rod)
                answer = "Lure";
        }
        return answer;
    }
}
