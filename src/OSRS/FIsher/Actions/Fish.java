package OSRS.FIsher.Actions;

import OSRS.FIsher.Fisher;
import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.powerbot.script.Condition;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;
import z.P;
import z.S;

import java.util.Timer;
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
                    Variables.status = "Starting to fish.";
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            Variables.status = "Fishing.";
                            return ctx.players.local().animation() != -1;
                        }
                    });
                }
            } else
                ctx.camera.turnTo(spot);
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
        }
        return answer;
    }

    public static boolean cantReach = false;
}
