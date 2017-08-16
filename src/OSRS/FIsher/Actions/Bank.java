package  OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import javax.sound.midi.SysexMessage;

public class Bank extends Task {
    public Bank(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() > 27 && ctx.bank.nearest().tile().distanceTo(ctx.players.local()) < 6;
    }

    @Override
    public void execute() {
        if (ctx.bank.opened()) {
            System.out.println("Bank is open depositing");
            int count = ctx.inventory.select().id(Variables.fishID).count();
            ctx.bank.deposit(Variables.fishID, count);
        } else {
            if (ctx.bank.inViewport()) {
                System.out.println("Opening bank");
                ctx.bank.open();
            } else {
                ctx.camera.turnTo(ctx.bank.nearest());
            }
        }
    }
}
