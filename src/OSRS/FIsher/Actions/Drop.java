package OSRS.FIsher.Actions;

import OSRS.FIsher.Utils.Task;
import OSRS.FIsher.Utils.Variables;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

import java.util.concurrent.Callable;

public class Drop extends Task {
    public Drop(ClientContext arg0) {
        super(arg0);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() > 27 && Variables.powerFishing;
    }

    @Override
    public void execute() {
        for (Item item : ctx.inventory.select().id(Variables.fishID)) {
            if (item.interact("Drop")) {
                final int currentCount = ctx.inventory.select().count();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.inventory.select().count() != currentCount;
                    }
                }, 25, 20);
            }
        }
    }
}
