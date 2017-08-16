package OSRS.FIsher.Actions;

import OSRS.FIsher.Fisher;
import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.powerbot.script.Condition;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import z.P;
import z.S;

import java.util.Timer;
import java.util.concurrent.Callable;

public class Fish extends Task {
    Variables ids = new Variables();

    public Fish(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1 && ctx.inventory.select().count() < 28;
    }

    @Override
    public void execute() {
        System.out.println("Creating NPC From Spot id");
        Npc spot = ctx.npcs.select().id(ids.spot).nearest().poll();
        if (ctx.inventory.select().id(ids.rodID).count() > 0) {
            System.out.println("Rod is in inventory");
            if (spot.valid()) {
                if (spot.inViewport()) {
                    System.out.println("spot is valid");
                    if (spot.interact(ids.method)) {
                        if (cantReach) {
                            System.out.println("I cant reach this spot.");
                            return;
                        }
                        System.out.println("Starts fishing");
                        Condition.wait(new Callable<Boolean>() {
                            @Override
                            public Boolean call() throws Exception {
                                System.out.println("Is Fishing!");
                                return ctx.inventory.select().count() > 27 || ctx.players.local().animation() == -1;
                            }
                        });
                    }
                }
                else {
                    ctx.camera.turnTo(spot);
                }
            }
        }
        else {
            System.out.println("You dont have rod in your inventory.");
            ctx.controller.stop();
        }
    }

    public static boolean cantReach = false;
}
